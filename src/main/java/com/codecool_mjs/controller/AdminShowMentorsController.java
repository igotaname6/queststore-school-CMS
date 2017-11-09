package com.codecool_mjs.controller;

import com.codecool_mjs.dataaccess.dao.DaoException;
import com.codecool_mjs.model.Admin;
import com.codecool_mjs.model.Mentor;
import com.sun.net.httpserver.HttpExchange;
import com.sun.net.httpserver.HttpHandler;

import java.io.IOException;
import java.io.OutputStream;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class AdminShowMentorsController implements HttpHandler{

    private TemplatesEngine templateEngine;
    private Admin loggedUser;


    public AdminShowMentorsController(){
        this.templateEngine = new TemplatesEngine();
    }

    public void setLoggedUser(Admin loggedUser) {
        this.loggedUser = loggedUser;
    }

    @Override
    public void handle(HttpExchange httpExchange) throws IOException {
        String responseBody;
        int responseCode;

        try {
            responseBody = showAllMentors();
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

    public String showAllMentors() throws DaoException {
        //temporary example of logged user. To remove when sessions will be implemented
        setLoggedUser(new Admin(15,"Janusz", "Kowal", "j.k@cc.pl", "typoweHasło"));

        Map<String, Object> variables = new HashMap<>();

        MentorController mentorController = new MentorController();
        List<Mentor> allMentors = mentorController.getAllMentors();

        variables.put("user", loggedUser);
        variables.put("mentorsList", allMentors);

        templateEngine.setVariables(variables);

        String page = templateEngine.ProcessTemplateToPage("admin-show-mentors");
        return page;
    }
}
