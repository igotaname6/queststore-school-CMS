package com.codecool_mjs.controller.webAccessController.mentorActionController;

import com.codecool_mjs.controller.applicationActionsController.CodecoolerController;
import com.codecool_mjs.controller.applicationActionsController.MentorController;
import com.codecool_mjs.dataaccess.dao.DaoException;
import com.codecool_mjs.model.Admin;
import com.codecool_mjs.model.Codecooler;
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
import java.util.Map;

public class EditStudentsActions implements HttpHandler{

    private TemplatesProcessor templateProcessor;
    private Mentor loggedUser;
    private CodecoolerController codecoolerController = CodecoolerController.getInstance();

    public EditStudentsActions(){
        this.templateProcessor = new TemplatesProcessor();
    }

    public void setLoggedUser(Mentor loggedUser) {
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

            responseBody = editStudent(id);
        }

        if(method.equals("POST")) {

            Map<String, String> records;

            InputStreamReader isr = new InputStreamReader(httpExchange.getRequestBody(), "UTF-8");
            BufferedReader br = new BufferedReader(isr);
            String dataForm = br.readLine();

            records = FormResolver.parseDataForm(dataForm);
            records.put("id", idStr);

            try {
                codecoolerController.editCodecooler(records);
            } catch (DaoException e) {
                e.printStackTrace();
            }

            responseBody = templateProcessor.ProcessTemplateToPage("mentor/edit-confirmation");
        }

        httpExchange.sendResponseHeaders(responseCode, responseBody.getBytes().length);
        OutputStream os = httpExchange.getResponseBody();
        os.write(responseBody.getBytes());
        os.close();
    }

    private String editStudent(Integer id){

        Codecooler codecooler = null

        Mentor mentor = new Mentor(15,"Janusz", "Kowal", "j.k@cc.pl", "typoweHasło");
        Map<String, Object> variables = new HashMap<>();

        try {
            mentor = codecoolerController.getCodecoolerById(id);
        } catch (DaoException e) {
            e.printStackTrace();
        }

        variables.put("user", mentor);
        variables.put("mentor", codecooler);

        templateProcessor.setVariables(variables);
        String page = templateProcessor.ProcessTemplateToPage("mentor/edit-student");

        return page;
    }
}
