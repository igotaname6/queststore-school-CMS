package com.codecool_mjs.controller.webAccessController;

import com.codecool_mjs.controller.applicationActionsController.SessionController;
import com.codecool_mjs.dataaccess.dao.DaoException;
import com.codecool_mjs.model.User;
import com.codecool_mjs.view.webView.TemplatesProcessor;
import com.sun.net.httpserver.HttpExchange;
import com.sun.net.httpserver.HttpHandler;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

public abstract class WebActionController implements HttpHandler, Sessionable{

    private TemplatesProcessor templatesProcessor;
    private SessionController sessionController;
    private User loggedUser;
    private Map<String, Object> pageVariables;

    public WebActionController(){
        this.templatesProcessor = new TemplatesProcessor();
        this.sessionController = new SessionController();
        this.pageVariables = new HashMap<>();
    }


    @Override
    public void handle(HttpExchange httpExchange) throws IOException {

        try {
            boolean correctAccessRequest = sessionController.checkAccountAccess(httpExchange, getAccessType());
            if (correctAccessRequest){
                setLoggedUser();
                sendPageForProperAccess(httpExchange);
            }
        } catch (DaoException e) {
            httpExchange.sendResponseHeaders(500, -1);
        }
    }

    @Override
    public void setLoggedUser() {
        this.loggedUser = sessionController.getLoggedUser();
    }

    @Override
    public String processTemplate(String TemplateUrl) throws DaoException {
        setVariable("user", getLoggedUser());

        templatesProcessor.setVariables(pageVariables);
        String page = templatesProcessor.ProcessTemplateToPage(TemplateUrl);
        return page;
    }

    public void setVariable(String variableName, Object variableObject){
        this.pageVariables.put(variableName, variableObject);
    }

    public User getLoggedUser() {
        return loggedUser;
    }

    public TemplatesProcessor getTemplatesProcessor() {
        return templatesProcessor;
    }

    public SessionController getSessionController() {
        return sessionController;
    }

}
