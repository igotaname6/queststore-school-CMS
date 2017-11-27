package com.codecool_mjs.controller.webAccessController.logIn;

import com.codecool_mjs.controller.applicationActionsController.SessionController;
import com.codecool_mjs.dataaccess.dao.DaoException;
import com.sun.net.httpserver.HttpExchange;
import com.sun.net.httpserver.HttpHandler;

import java.io.IOException;

public class LogOutController implements HttpHandler {

    private SessionController sessionController;

    public LogOutController() {
        this.sessionController = new SessionController();
    }

    @Override
    public void handle(HttpExchange httpExchange) throws IOException {
        try {
            sessionController.logOut(httpExchange);
            httpExchange.getResponseHeaders().add("Location", "/home");
            httpExchange.sendResponseHeaders(302, -1);
        } catch (DaoException e) {
            httpExchange.sendResponseHeaders(503, -1);
        }
    }
}
