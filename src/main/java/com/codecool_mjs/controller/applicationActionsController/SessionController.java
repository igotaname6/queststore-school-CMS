package com.codecool_mjs.controller.applicationActionsController;

import com.codecool_mjs.dataaccess.dao.DaoException;
import com.codecool_mjs.dataaccess.dao.LogInDao;
import com.codecool_mjs.model.User;
import com.sun.net.httpserver.HttpExchange;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.URLDecoder;
import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

public class SessionController{

    private LogInDao dao;
    private User loggedUser;


    public SessionController(){
        dao = new LogInDao();
    }

    public boolean logIn(HttpExchange httpExchange) throws DaoException, IOException {

        Map<String, String> loginData = parseForm(httpExchange);
        String email = loginData.get("email");
        String password = loginData.get("password");

        User user = dao.checkLogin(email, password);
        if(user != null) {
            String uuid = createUuid();
            saveSessionIdToDb(uuid, user.getId());
            String cookie = createCookie(uuid);
            httpExchange.getResponseHeaders().add("Set-Cookie", cookie);
            this.loggedUser = user;
            return true;
        }else{
            this.loggedUser = null;
            return false;
        }
    }

    public boolean checkAccountAccess(HttpExchange httpExchange, String accessType) throws IOException, DaoException {

        boolean isSessionExist = verifySession(httpExchange);
        this.loggedUser = getLoggedUser();
        boolean accessStatus;

        String profession = loggedUser.getProfession();

        if(!isSessionExist){
            httpExchange.getResponseHeaders().add("Location", "/home");
            httpExchange.sendResponseHeaders(302, -1);
            accessStatus = false;
        }else if(!profession.equals(accessType)){
            httpExchange.sendResponseHeaders(403, -1);
            accessStatus = false;
        }
        else {
            accessStatus = true;
        }
        return accessStatus;
    }

    public User getSessionsUser(HttpExchange httpExchange) throws DaoException{
        Map<String, String> cookiesMap = parseCookies(httpExchange);
        User user = dao.logInBySession(cookiesMap.get("session_id"));
        return user;
    }

    private boolean saveSessionIdToDb(String sessionId, int userId) throws DaoException {
        return dao.addSession(sessionId, userId);
    }

    private String createUuid(){
        return UUID.randomUUID().toString();
    }

    private String createCookie(String uuid){
        StringBuilder sb = new StringBuilder();
         sb.append("session_id=").append(uuid);
         return sb.toString();
    }

    private Map<String, String> parseForm(HttpExchange httpExchange) throws IOException {

        InputStreamReader isr = new InputStreamReader(httpExchange.getRequestBody(), "utf-8");
        BufferedReader br = new BufferedReader(isr);
        String formData = br.readLine();
        String decodedFormData = URLDecoder.decode(formData, "UTF-8");

        String[] pairsArray = decodedFormData.split("&");

        Map<String, String> formMap = new HashMap<>();
        for (String pair : pairsArray) {
            String[] keyValue = pair.split("=");
            formMap.put(keyValue[0], keyValue[1]);
        }
        return formMap;
    }

    public boolean verifySession(HttpExchange httpExchange) throws DaoException {

        dao.setConnection();
        Map<String, String> cookiesMap = parseCookies(httpExchange);
        if(cookiesMap == null){
            return false;
        }else{
            //check if browser-side cookie exist in db
            String cookie = cookiesMap.get("session_id");
            boolean isSessionInDb = dao.checkSessionStatus(cookie);

            if(isSessionInDb){
                this.loggedUser = dao.logInBySession(cookie);
                return true;
            }else{
                //session id don't exist in db.
                return false;
            }
        }
    }

    private Map<String, String> parseCookies(HttpExchange httpExchange) {
        Map<String, String> cookiesMap = new HashMap<>();

        String cookies = httpExchange.getRequestHeaders().getFirst("Cookie");

        if(cookies == null) {
            return null;
        }
        String[] cookiesArray = cookies.split(";");

        for (String cookiePair : cookiesArray) {
            String[] cookie = cookiePair.split("=");

            cookiesMap.put(cookie[0], cookie[1].replaceAll("\"", ""));
        }
        return cookiesMap;
    }

    public void logOut(HttpExchange httpExchange) throws DaoException {
        Map<String, String > sessionCookie = parseCookies(httpExchange);
        String sessionId = sessionCookie.get("session_id");

        dao.setConnection();
        dao.remove(sessionId);
        StringBuilder resettingCookie = new StringBuilder();
        resettingCookie.append("session_id=").append(sessionId).append(";");
        resettingCookie.append("MAX-AGE=").append(0).append(";");
        httpExchange.getResponseHeaders().add("Set-cookie", resettingCookie.toString());

    }

    public User getLoggedUser() {
        return loggedUser;
    }
}
