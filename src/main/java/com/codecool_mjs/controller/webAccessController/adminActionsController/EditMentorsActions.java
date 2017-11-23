package com.codecool_mjs.controller.webAccessController.adminActionsController;

import com.codecool_mjs.controller.applicationActionsController.MentorController;
import com.codecool_mjs.dataaccess.dao.DaoException;
import com.codecool_mjs.model.Admin;
import com.codecool_mjs.model.Mentor;
import com.codecool_mjs.utilities.FormResolver;
import com.codecool_mjs.utilities.UriResolver;
import com.codecool_mjs.view.webView.TemplatesProcessor;
import com.sun.net.httpserver.HttpExchange;
import com.sun.net.httpserver.HttpHandler;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
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
        String idStr = UriResolver.getUserIdFromURI(httpExchange);

        if(method.equals("GET")) {

            if (idStr == null) {
                try {
                    responseBody = ShowMentorsToEdit();
                } catch (DaoException e) {
                    responseBody = "No such page";
                    responseCode = 404;
                }
            } else {

                Integer id = Integer.parseInt(idStr);

                try {

                    responseBody = EditMentor(id);
                } catch (DaoException e) {
                    responseBody = "No such page";
                    responseCode = 404;
                }
            }
        }

        if(method.equals("POST")) {

            Map<String, String> records = new HashMap<>();

            InputStreamReader isr = new InputStreamReader(httpExchange.getRequestBody(), "UTF-8");
            BufferedReader br = new BufferedReader(isr);
            String dataForm = br.readLine();

            records = FormResolver.parseDataForm(dataForm);
            records.put("id", idStr);
            System.out.println(records);

            try {
                mentorController.editMentor(records);
            } catch (DaoException e) {
                e.printStackTrace();
            }

            responseBody = templateProcessor.ProcessTemplateToPage("admin/admin-confirmation");
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
        String page = templateProcessor.ProcessTemplateToPage("admin/admin-edit-mentor");
        return page;
    }
}
