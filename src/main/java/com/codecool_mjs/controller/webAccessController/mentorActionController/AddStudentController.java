package com.codecool_mjs.controller.webAccessController.mentorActionController;

import com.codecool_mjs.controller.applicationActionsController.CodecoolerController;
import com.codecool_mjs.controller.applicationActionsController.MentorController;
import com.codecool_mjs.dataaccess.dao.DaoException;
import com.codecool_mjs.model.Admin;
import com.codecool_mjs.model.Mentor;
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

public class AddStudentController implements HttpHandler{

    private TemplatesProcessor templatesProcessor;
    private Mentor loggedUser;
    private CodecoolerController codecoolerController;

    public AddStudentController(){
        this.templatesProcessor = new TemplatesProcessor();
        this.codecoolerController = CodecoolerController.getInstance();
    }

    public void setLoggedUser(Mentor loggedUser) {
        this.loggedUser = loggedUser;
    }

    @Override
    public void handle(HttpExchange httpExchange) throws IOException {


        String responseBody = "";
        int responseCode = 200;

        String method = httpExchange.getRequestMethod();

        if(method.equals("GET")) {

            responseBody = addStudent();
        }

        if(method.equals("POST")) {

            Map<String, String> records;

            InputStreamReader isr = new InputStreamReader(httpExchange.getRequestBody());
            BufferedReader br = new BufferedReader(isr);
            String formData = br.readLine();

            records = FormResolver.parseDataForm(formData);

            try {
                codecoolerController.addCodecooler(records);
            } catch (DaoException e) {
                e.printStackTrace();
            }

            responseBody = templatesProcessor.ProcessTemplateToPage("mentor/add-confirmation");

        }

        httpExchange.sendResponseHeaders(responseCode, responseBody.getBytes().length);
        OutputStream os = httpExchange.getResponseBody();
        os.write(responseBody.getBytes());
        os.close();

    }

    private String addStudent() {

        Mentor mentor = new Mentor(15,"Janusz", "Kowal", "j.k@cc.pl", "typoweHasło");

        Map<String, Object> variables = new HashMap<>();

        variables.put("user", mentor);

        templatesProcessor.setVariables(variables);

        String page = templatesProcessor.ProcessTemplateToPage("mentor/create-student");
        return page;
    }
}
