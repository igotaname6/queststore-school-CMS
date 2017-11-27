package com.codecool_mjs.controller.webAccessController.mentorActionController;

import com.codecool_mjs.controller.applicationActionsController.CodecoolerController;
import com.codecool_mjs.controller.applicationActionsController.MentorController;
import com.codecool_mjs.dataaccess.dao.DaoException;
import com.codecool_mjs.model.Admin;
import com.codecool_mjs.model.Codecooler;
import com.codecool_mjs.model.Mentor;
import com.codecool_mjs.view.webView.TemplatesProcessor;
import com.sun.net.httpserver.HttpExchange;
import com.sun.net.httpserver.HttpHandler;

import java.io.IOException;
import java.io.OutputStream;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class MenageStudentsActions implements HttpHandler{

    private TemplatesProcessor templateProcessor;
    private Mentor loggedUser;
    private CodecoolerController codecoolerController = CodecoolerController.getInstance();

    public MenageStudentsActions(){
        this.templateProcessor = new TemplatesProcessor();
    }

    public void setLoggedUser(Mentor loggedUser) {
        this.loggedUser = loggedUser;
    }

    @Override
    public void handle(HttpExchange httpExchange) throws IOException {

        String responseBody;
        int responseCode = 200;

        responseBody = menageStudents();

        httpExchange.sendResponseHeaders(responseCode, responseBody.getBytes().length);
        OutputStream os = httpExchange.getResponseBody();
        os.write(responseBody.getBytes());
        os.close();
    }

    public String menageStudents(){
        //temporary example of logged user. To remove when sessions will be implemented
        setLoggedUser(new Mentor(15,"Janusz", "Kowal", "j.k@cc.pl", "typoweHasło"));

        Map<String, Object> variables = new HashMap<>();

        List<Codecooler> allCodecoolers = codecoolerController.getAllCodecoolers();

        variables.put("user", loggedUser);
        variables.put("studentsList", allCodecoolers);

        templateProcessor.setVariables(variables);

        String page = templateProcessor.ProcessTemplateToPage("mentor/menage-students");
        return page;
    }
}
