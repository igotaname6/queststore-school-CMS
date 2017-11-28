package com.codecool_mjs.controller.webAccessController.adminActionsController;

import com.codecool_mjs.controller.applicationActionsController.SessionController;
import com.codecool_mjs.controller.webAccessController.Sessionable;
import com.codecool_mjs.dataaccess.dao.DaoException;
import com.codecool_mjs.model.Admin;
import com.codecool_mjs.model.User;
import com.codecool_mjs.view.webView.TemplatesProcessor;
import com.sun.net.httpserver.HttpExchange;
import com.sun.net.httpserver.HttpHandler;

import java.io.IOException;
import java.io.OutputStream;
import java.util.HashMap;
import java.util.Map;

public class AdminHomeController implements HttpHandler, Sessionable{

    private TemplatesProcessor templatesProcessor;
    private SessionController sessionController;

    public AdminHomeController(){
        this.templatesProcessor = new TemplatesProcessor();
        this.sessionController = new SessionController();
    }

    @Override
    public void handle(HttpExchange httpExchange) throws IOException {

        try {
            boolean correctAccessRequest = sessionController.checkAccountAccess(httpExchange, getAccessType());
            if (correctAccessRequest){
                sendPageForPopperAccess(httpExchange);
            }
        } catch (DaoException e) {
            httpExchange.sendResponseHeaders(500, -1);
        }
    }

    @Override
    public void sendPageForPopperAccess(HttpExchange httpExchange) throws IOException, DaoException{
        String responseBody;
        int responseCode;

        responseBody = showAdminHomePage();
        responseCode = 200;

        httpExchange.sendResponseHeaders(responseCode, responseBody.getBytes().length);
        OutputStream os = httpExchange.getResponseBody();
        os.write(responseBody.getBytes());
        os.close();
    }

    private String showAdminHomePage() throws DaoException {

        Map<String, Object> variables = new HashMap<>();
        variables.put("user", sessionController.getLoggedUser());
        templatesProcessor.setVariables(variables);
        String page = templatesProcessor.ProcessTemplateToPage("/admin/home");
        return page;
    }

    @Override
    public String getAccessType() {
        return "Admin";
    }
}
