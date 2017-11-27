package com.codecool_mjs.controller.webAccessController.mentorActionController;

import com.codecool_mjs.controller.applicationActionsController.CodecoolerController;
import com.codecool_mjs.controller.applicationActionsController.MentorController;
import com.codecool_mjs.dataaccess.dao.DaoException;
import com.codecool_mjs.model.Admin;
import com.codecool_mjs.model.Codecooler;
import com.codecool_mjs.model.Mentor;
import com.codecool_mjs.utilities.UriResolver;
import com.codecool_mjs.view.webView.TemplatesProcessor;
import com.sun.net.httpserver.HttpExchange;
import com.sun.net.httpserver.HttpHandler;

import java.io.IOException;
import java.io.OutputStream;
import java.util.HashMap;
import java.util.Map;

public class DeleteStudentActions implements HttpHandler{

    private TemplatesProcessor templateProcessor;
    private Mentor loggedUser;
    private CodecoolerController codecoolerController = CodecoolerController.getInstance();


    public DeleteStudentActions(){
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

            responseBody = showStudentToDelete(id);
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

    private String showStudentToDelete(Integer id){

        Codecooler codecooler = null;
        //temporary example of logged user. To remove when sessions will be implemented
        setLoggedUser(new Mentor(15,"Janusz", "Kowal", "j.k@cc.pl", "typoweHasło"));

        Map<String, Object> variables = new HashMap<>();

        try {
            codecooler = codecoolerController.getCodecoolerById(id);
        } catch (DaoException e) {
            e.printStackTrace();
        }

        variables.put("user", loggedUser);
        variables.put("student", codecooler);

        templateProcessor.setVariables(variables);
        String page = templateProcessor.ProcessTemplateToPage("mentor/delete-mentor");
        return page;
    }

    private String deleteMentor(Integer id) {

        try {
            codecoolerController.deleteCodecooler(id);
        } catch (DaoException e) {
            e.printStackTrace();
        }

        String page = templateProcessor.ProcessTemplateToPage("mentor/delete-confirmation");
        return page;
    }
}
