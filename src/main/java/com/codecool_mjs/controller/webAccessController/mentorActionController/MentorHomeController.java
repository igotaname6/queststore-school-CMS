package com.codecool_mjs.controller.webAccessController.mentorActionController;

import com.codecool_mjs.dataaccess.dao.DaoException;
import com.codecool_mjs.model.Mentor;
import com.codecool_mjs.view.webView.TemplatesProcessor;
import com.sun.net.httpserver.HttpExchange;
import com.sun.net.httpserver.HttpHandler;

import java.io.IOException;
import java.io.OutputStream;
import java.util.HashMap;
import java.util.Map;

public class MentorHomeController implements HttpHandler{

    private TemplatesProcessor templatesProcessorr;
    private Mentor loggedUser;

    public MentorHomeController(){
        this.templatesProcessorr = new TemplatesProcessor();
    }

    public void setLoggedUser(Mentor loggedUser) {
        this.loggedUser = loggedUser;
    }

    @Override
    public void handle(HttpExchange httpExchange) throws IOException {
        String responseBody;
        int responseCode;

        try {
            responseBody = showMentorHomePage();
            responseCode = 200;
        } catch (DaoException e) {
            responseBody = "No such page";
            responseCode = 404;
        }

        httpExchange.sendResponseHeaders(responseCode, responseBody.getBytes().length);
        OutputStream os = httpExchange.getResponseBody();
        os.write(responseBody.getBytes());
        os.close();

    }

    public String showMentorHomePage() throws DaoException {
        //temporary example of logged user. To remove when sessions will be implemented
        setLoggedUser(new Mentor(15,"Janusz", "Kowal", "j.k@cc.pl", "typoweHasło"));

        Map<String, Object> variables = new HashMap<>();

        variables.put("user", loggedUser);

        templatesProcessorr.setVariables(variables);

        String page = templatesProcessorr.ProcessTemplateToPage("/mentor/mentor-home");

        return page;
    }
}
