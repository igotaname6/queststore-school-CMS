package com.codecool_mjs.controller.webAccessController.adminActionsController;

import com.codecool_mjs.controller.applicationActionsController.MentorController;
import com.codecool_mjs.controller.applicationActionsController.SessionController;
import com.codecool_mjs.dataaccess.dao.DaoException;
import com.codecool_mjs.model.User;
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

    private TemplatesProcessor templatesProcessorr;
    private User loggedUser;
    private MentorController mentorController;
    private SessionController sessionController;

    public AddMentorController(){
        this.templatesProcessorr = new TemplatesProcessor();
        this.mentorController = new MentorController();
        this.sessionController = new SessionController();
    }

    private void setLoggedUser(User loggedUser) {
        this.loggedUser = loggedUser;
    }

    @Override
    public void handle(HttpExchange httpExchange) throws IOException {

        String responseBody = "";
        int responseCode = 200;

        boolean isSessionExist = false;

        try {
            isSessionExist = sessionController.verifySession(httpExchange);
            this.loggedUser = sessionController.getLoggedUser();
        } catch (DaoException e) {
            httpExchange.sendResponseHeaders(503, -1);
        }

        String userProffesion = loggedUser.getProfession();

        if(!isSessionExist){
            httpExchange.getResponseHeaders().add("Location", "/home");
            httpExchange.sendResponseHeaders(302, -1);
        }else if(!userProffesion.equals("Admin")){
            httpExchange.sendResponseHeaders(403, -1);
        }


        String method = httpExchange.getRequestMethod();

        if(method.equals("GET")) {
            responseBody = AddMentorPage();
        }else if(method.equals("POST")) {
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
            responseBody = templatesProcessorr.ProcessTemplateToPage("admin/admin-add-confirmation");
        }

        httpExchange.sendResponseHeaders(responseCode, responseBody.getBytes().length);
        OutputStream os = httpExchange.getResponseBody();
        os.write(responseBody.getBytes());
        os.close();

    }

    private String AddMentorPage() {

        Map<String, Object> variables = new HashMap<>();
        variables.put("user", loggedUser);
        templatesProcessorr.setVariables(variables);

        String page = templatesProcessorr.ProcessTemplateToPage("admin/admin-create-mentor");
        return page;
    }
}
