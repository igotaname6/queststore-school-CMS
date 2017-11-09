package com.codecool_mjs.controller;

import com.codecool_mjs.dataaccess.dao.DaoException;
import com.codecool_mjs.model.Admin;
import com.codecool_mjs.model.Mentor;
import com.sun.net.httpserver.HttpExchange;
import com.sun.net.httpserver.HttpHandler;
import org.thymeleaf.TemplateEngine;

import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class AdminActionsController implements HttpHandler{

    private TemplatesEngine templateEngine;
    private Admin loggedUser;


    public AdminActionsController(){
        this.templateEngine = new TemplatesEngine();
    }

    public void setLoggedUser(Admin loggedUser) {
        this.loggedUser = loggedUser;
    }

    @Override
    public void handle(HttpExchange httpExchange) throws IOException {

    }

    public String showAllMentors() throws DaoException {
        //temporary example of logged user. To remove when sessions will be implemented
        setLoggedUser(new Admin(15,"Janusz", "Kowalski", "j.k@cc.pl", "typoweHasło"));

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
