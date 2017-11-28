package com.codecool_mjs.controller.webAccessController.adminActionsController;

import com.codecool_mjs.controller.applicationActionsController.MentorController;
import com.codecool_mjs.controller.webAccessController.Sessionable;
import com.codecool_mjs.controller.webAccessController.WebActionController;
import com.codecool_mjs.dataaccess.dao.DaoException;
import com.codecool_mjs.model.Admin;
import com.codecool_mjs.model.Mentor;
import com.codecool_mjs.utilities.UriResolver;
import com.codecool_mjs.view.webView.TemplatesProcessor;
import com.sun.net.httpserver.HttpExchange;
import com.sun.net.httpserver.HttpHandler;

import java.io.IOException;
import java.io.OutputStream;
import java.util.HashMap;
import java.util.Map;

public class DeleteMentorsActions extends WebActionController implements Sessionable{

    private MentorController mentorController;
    private static String CONFIRMATION_TEMPLATE_URL = "admin/delete-confirmation";
    private static String DATA_TEMPLATE_URL = "admin/delete-mentor";

    public DeleteMentorsActions(){
        super();
        mentorController = new MentorController();
    }

    @Override
    public String getAccessType() {
        return "Admin";
    }

    @Override
    public void sendPageForPopperAccess(HttpExchange httpExchange) throws IOException, DaoException {
        String responseBody = "";
        int responseCode = 200;

        String method = httpExchange.getRequestMethod();
        String idStr = UriResolver.getUserIdFromURI(httpExchange);

        if(method.equals("GET")) {

            Integer id = Integer.parseInt(idStr);
            responseBody = showMentorToDelete(id);
        }

        else if(method.equals("POST")) {

            Integer id = Integer.parseInt(idStr);
            responseBody = deleteMentor(id);
        }

        httpExchange.sendResponseHeaders(responseCode, responseBody.getBytes().length);
        OutputStream os = httpExchange.getResponseBody();
        os.write(responseBody.getBytes());
        os.close();
    }


    private String showMentorToDelete(Integer id) throws DaoException {

        Mentor mentor = mentorController.getMentorById(id);
        setVariable("mentor", mentor);

        String page = processTemplate(DATA_TEMPLATE_URL);
        return page;
    }

    private String deleteMentor(Integer id) throws DaoException{

        mentorController.deleteMentor(id);
        String page = processTemplate(CONFIRMATION_TEMPLATE_URL);
        return page;
    }
}
