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
import java.util.Map;

public class DeleteMentorsActions implements HttpHandler{

    private TemplatesProcessor templateProcessor;
    private Admin loggedUser;
    private MentorController mentorController = new MentorController();


    public DeleteMentorsActions(){
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
        String idStr = UriResolver.getUserIdFromURI(httpExchange);

        if(method.equals("GET")) {

            Integer id = Integer.parseInt(idStr);

            responseBody = showMentorToDelete(id);
        }

        if(method.equals("POST")) {

            Integer id = Integer.parseInt(idStr);

            responseBody = deleteMentor(id);
        }

        httpExchange.sendResponseHeaders(responseCode, responseBody.getBytes().length);
        OutputStream os = httpExchange.getResponseBody();
        os.write(responseBody.getBytes());
        os.close();
    }

    private String showMentorToDelete(Integer id){

        Mentor mentor = null;
        //temporary example of logged user. To remove when sessions will be implemented
        setLoggedUser(new Admin(15,"Janusz", "Kowal", "j.k@cc.pl", "typoweHasło"));


        Map<String, Object> variables = new HashMap<>();

        try {
            mentor = mentorController.getMentorById(id);
        } catch (DaoException e) {
            e.printStackTrace();
        }

        variables.put("user", loggedUser);
        variables.put("mentor", mentor);

        System.out.println(variables);

        templateProcessor.setVariables(variables);
        String page = templateProcessor.ProcessTemplateToPage("admin/delete-mentor");
        return page;
    }

    private String deleteMentor(Integer id) {

        try {
            mentorController.deleteMentor(id);
        } catch (DaoException e) {
            e.printStackTrace();
        }

        String page = templateProcessor.ProcessTemplateToPage("admin/delete-confirmation");
        return page;
    }
}
