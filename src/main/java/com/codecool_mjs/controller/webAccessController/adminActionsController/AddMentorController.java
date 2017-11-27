package com.codecool_mjs.controller.webAccessController.adminActionsController;

import com.codecool_mjs.controller.applicationActionsController.MentorController;
import com.codecool_mjs.dataaccess.dao.DaoException;
import com.codecool_mjs.model.Admin;
import com.codecool_mjs.utilities.FormResolver;
import com.codecool_mjs.view.webView.TemplatesProcessor;
import com.sun.net.httpserver.HttpExchange;
import com.sun.net.httpserver.HttpHandler;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.util.HashMap;
import java.util.Map;

public class AddMentorController implements HttpHandler{

    private TemplatesProcessor templatesProcessor;
    private Admin loggedUser;
    private MentorController mentorController;

    public AddMentorController(){
        this.templatesProcessor = new TemplatesProcessor();
        this.mentorController = new MentorController();
    }

    public void setLoggedUser(Admin loggedUser) {
        this.loggedUser = loggedUser;
    }

    @Override
    public void handle(HttpExchange httpExchange) throws IOException {


        String responseBody = "";
        int responseCode = 200;


        String method = httpExchange.getRequestMethod();

        if(method.equals("GET")) {

            responseBody = addMentor();
        }

        if(method.equals("POST")) {

            Map<String, String> records;

            InputStreamReader isr = new InputStreamReader(httpExchange.getRequestBody());
            BufferedReader br = new BufferedReader(isr);
            String formData = br.readLine();

            records = FormResolver.parseDataForm(formData);

            try {
                mentorController.addMentor(records);
            } catch (DaoException e) {
                e.printStackTrace();
            }

            responseBody = templatesProcessor.ProcessTemplateToPage("admin/add-confirmation");

        }

        httpExchange.sendResponseHeaders(responseCode, responseBody.getBytes().length);
        OutputStream os = httpExchange.getResponseBody();
        os.write(responseBody.getBytes());
        os.close();

    }

    private String addMentor() {

        Admin admin = new Admin(15,"Janusz", "Kowal", "j.k@cc.pl", "typoweHasło");

        Map<String, Object> variables = new HashMap<>();

        variables.put("user", admin);

        templatesProcessor.setVariables(variables);

        String page = templatesProcessor.ProcessTemplateToPage("admin/create-mentor");
        return page;
    }
}
