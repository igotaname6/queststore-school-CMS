package com.codecool_mjs.controller.webAccessController.adminActionsController;

import com.codecool_mjs.controller.applicationActionsController.MentorController;
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
import java.util.List;
import java.util.Map;

public class EditMentorsActions implements HttpHandler{

    private TemplatesProcessor templateProcessor;
    private Admin loggedUser;
    private MentorController mentorController = new MentorController();


    public EditMentorsActions(){
        this.templateProcessor = new TemplatesProcessor();
    }

    public void setLoggedUser(Admin loggedUser) {
        this.loggedUser = loggedUser;
    }

    @Override
    public void handle(HttpExchange httpExchange) throws IOException {

        String responseBody = "";
        int responseCode = 200;

        String method = httpExchange.getRequestMethod();
        Integer id = Integer.parseInt(UriResolver.getUserIdFromURI(httpExchange));
        System.out.println(id);

        if(method.equals("GET")) {

            if (id == null) {
                try {
                    responseBody = ShowMentorsToEdit();
                } catch (DaoException e) {
                    responseBody = "No such page";
                    responseCode = 404;
                }
            } else {
                try {
                    responseBody = EditMentor(id);
                } catch (DaoException e) {
                    responseBody = "No such page";
                    responseCode = 404;
                }
            }
        }

        httpExchange.sendResponseHeaders(responseCode, responseBody.getBytes().length);
        OutputStream os = httpExchange.getResponseBody();
        os.write(responseBody.getBytes());
        os.close();
    }

    private String ShowMentorsToEdit() throws DaoException {

        //temporary example of logged user. To remove when sessions will be implemented
        setLoggedUser(new Admin(15,"Janusz", "Kowal", "j.k@cc.pl", "typoweHasło"));

        Map<String, Object> variables = new HashMap<>();

        List<Mentor> allMentors = mentorController.getAllMentors();

        variables.put("user", loggedUser);
        variables.put("mentorsList", allMentors);

        templateProcessor.setVariables(variables);
        String page = templateProcessor.ProcessTemplateToPage("admin/admin-edit-mentors");
        return page;
    }

    private String EditMentor(Integer id) throws DaoException {

        Mentor mentor;
        Map<String, Object> variables = new HashMap<>();
        mentor = mentorController.getMentorById(id);
        variables.put("mentor", mentor);

        templateProcessor.setVariables(variables);
        String page = templateProcessor.ProcessTemplateToPage("admin/edit-mentor");
        return page;
    }
}
