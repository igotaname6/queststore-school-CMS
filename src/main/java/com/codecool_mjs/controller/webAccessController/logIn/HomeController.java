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

        Boolean isNewSession = sessionController.isNewSession(httpExchange);
        String method = httpExchange.getRequestMethod();

        if (isNewSession && method.equals("GET")) {
            String responseBody = templatesProcessor.ProcessTemplateToPage("index");

            httpExchange.sendResponseHeaders(200, responseBody.getBytes().length);
            OutputStream os = httpExchange.getResponseBody();
            os.write(responseBody.getBytes());
            os.close();
        } else if (isNewSession && method.equals("POST")) {
            try {
                User user = sessionController.logIn(httpExchange);
            } catch (DaoException e) {
                e.printStackTrace();
            }
        } else {
            String userRole = sessionController.getLoggedUser().getProfession();
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
}


