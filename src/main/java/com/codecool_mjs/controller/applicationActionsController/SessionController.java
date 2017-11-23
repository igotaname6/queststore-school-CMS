package com.codecool_mjs.controller.applicationActionsController;

import com.codecool_mjs.dataaccess.dao.DaoException;
import com.codecool_mjs.dataaccess.dao.LogInDao;
import com.codecool_mjs.model.User;
import com.sun.net.httpserver.HttpExchange;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpCookie;
import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

public class SessionController{

    private LogInDao dao;
    private User loggedUser;

    public SessionController(){
        dao = new LogInDao();
    }

    public User logIn(HttpExchange httpExchange) throws DaoException, IOException {

        Map<String, String> loginData = parseForm(httpExchange);
        String email = loginData.get("email");
        String password = loginData.get("password");

        User user = dao.checkLogin(email, password);
        if(user != null) {
            String uuid = createSessionUUID();
            HttpCookie cookie = new HttpCookie("session_id", uuid);
            httpExchange.getResponseHeaders().add("Set-Cookie", cookie.toString());
        }
        return user;
    }

    private String createSessionUUID(){
        return UUID.randomUUID().toString();
    }

    private Map<String, String> parseForm(HttpExchange httpExchange) throws IOException {

        InputStreamReader isr = new InputStreamReader(httpExchange.getRequestBody(), "utf-8");
        BufferedReader br = new BufferedReader(isr);
        String formData = br.readLine();

        String[] pairsArray = formData.split("&");

        Map<String, String> formMap = new HashMap<>();
        for (String pair : pairsArray) {
            String[] keyValue = pair.split("=");
            formMap.put(keyValue[0], keyValue[1]);
        }
        return formMap;
    }





}
