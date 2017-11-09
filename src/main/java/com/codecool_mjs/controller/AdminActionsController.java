package com.codecool_mjs.controller;

import com.codecool_mjs.dataaccess.dao.DaoException;
import com.codecool_mjs.model.Mentor;
import com.sun.net.httpserver.HttpExchange;
import com.sun.net.httpserver.HttpHandler;

import java.io.IOException;
import java.io.StringWriter;
import java.util.List;

public class AdminActionsController implements HttpHandler{



    @Override
    public void handle(HttpExchange httpExchange) throws IOException {

    }

    public void showAllMentors() throws DaoException {
        MentorController mentorController = new MentorController();
        List<Mentor> allMentors = mentorController.getAllMentors();




    }
}
