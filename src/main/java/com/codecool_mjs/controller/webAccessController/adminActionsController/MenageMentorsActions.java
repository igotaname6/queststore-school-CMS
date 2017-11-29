package com.codecool_mjs.controller.webAccessController.adminActionsController;

import com.codecool_mjs.controller.applicationActionsController.MentorController;
import com.codecool_mjs.controller.webAccessController.Sessionable;
import com.codecool_mjs.controller.webAccessController.WebActionController;
import com.codecool_mjs.dataaccess.dao.DaoException;
import com.codecool_mjs.model.Mentor;
import com.sun.net.httpserver.HttpExchange;

import java.io.IOException;
import java.io.OutputStream;
import java.util.List;

public class MenageMentorsActions extends WebActionController implements Sessionable {

    private static String DATA_TEMPLATE_URL = "admin/menage-mentors";
    private MentorController mentorController;

    public MenageMentorsActions(){
        super();
        mentorController = new MentorController();
    }


    @Override
    public void sendPageForProperAccess(HttpExchange httpExchange) throws IOException, DaoException {
        String responseBody = manageMentorsAction();
        int responseCode = 200;

        httpExchange.sendResponseHeaders(responseCode, responseBody.getBytes().length);
        OutputStream os = httpExchange.getResponseBody();
        os.write(responseBody.getBytes());
        os.close();
    }


    public String manageMentorsAction() throws DaoException {

        List<Mentor> allMentors = mentorController.getAllMentors();
        setVariable("mentorsList", allMentors);

        return processTemplate(DATA_TEMPLATE_URL);
    }

    @Override
    public String getAccessType() {
        return "Admin";
    }
}
