package com.codecool_mjs.controller.webAccessController.logIn;

import com.codecool_mjs.controller.applicationActionsController.SessionController;
import com.codecool_mjs.dataaccess.dao.DaoException;
import com.codecool_mjs.model.User;
import com.codecool_mjs.view.webView.TemplatesProcessor;
import com.sun.net.httpserver.HttpExchange;
import com.sun.net.httpserver.HttpHandler;

import java.io.*;

public class HomeController implements HttpHandler {

    private TemplatesProcessor templatesProcessor;
    private SessionController sessionController;

    public HomeController() {
        this.templatesProcessor = new TemplatesProcessor();
        this.sessionController = new SessionController();
    }

    @Override
    public void handle(HttpExchange httpExchange) throws IOException {

        Boolean isSessionExist = false;
        //check if cookie with session id exist in browser
        try {
            isSessionExist = sessionController.verifySession(httpExchange);
        } catch (DaoException e) {
            httpExchange.sendResponseHeaders(503, -1);
        }


        if (isSessionExist) {
        //means session id is in db, and user session is established.
        User user = sessionController.getLoggedUser();
        sendUserController(httpExchange, user);

        } else if (!isSessionExist) {
            String method = httpExchange.getRequestMethod();

            if (method.equals("GET")) {
                sendLoginPage(httpExchange);

            } else if (method.equals("POST")) {
                try {
                    //parse login form,  save session id to db, send cookie and redirect to proper user controller
                    sessionController.logIn(httpExchange);
                    User user = sessionController.getLoggedUser();
                    sendUserController(httpExchange, user);
                } catch (DaoException e) {
                    httpExchange.sendResponseHeaders(503, -1);
                }
            }
        }
    }

    private void sendLoginPage(HttpExchange httpExchange) throws IOException {
        String responseBody = templatesProcessor.ProcessTemplateToPage("index");

        httpExchange.sendResponseHeaders(200, responseBody.getBytes().length);
        OutputStream os = httpExchange.getResponseBody();
        os.write(responseBody.getBytes());
        os.close();
    }

    private void sendUserController(HttpExchange httpExchange, User user) throws IOException {
        String userRole = user.getProfession();

        if (userRole.equals("Mentor")) {
            httpExchange.getResponseHeaders().add("Location", "/mentor-home");
            httpExchange.sendResponseHeaders(302, -1);
        } else if (userRole.equals("Codecooler")) {
            httpExchange.getResponseHeaders().add("Location", "/codecooler-home");
            httpExchange.sendResponseHeaders(302, -1);
        } else if (userRole.equals("Admin")) {
            httpExchange.getResponseHeaders().add("Location", "/admin-home");
            httpExchange.sendResponseHeaders(302, -1);
        }
    }
}


