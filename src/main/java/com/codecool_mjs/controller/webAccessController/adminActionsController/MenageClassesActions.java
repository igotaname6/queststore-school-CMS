package com.codecool_mjs.controller.webAccessController.adminActionsController;

import com.codecool_mjs.controller.applicationActionsController.GroupController;
import com.codecool_mjs.controller.applicationActionsController.MentorController;
import com.codecool_mjs.dataaccess.dao.DaoException;
import com.codecool_mjs.model.Admin;
import com.codecool_mjs.model.Group;
import com.codecool_mjs.model.Mentor;
import com.codecool_mjs.view.webView.TemplatesProcessor;
import com.sun.net.httpserver.HttpExchange;
import com.sun.net.httpserver.HttpHandler;

import java.io.IOException;
import java.io.OutputStream;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class MenageClassesActions implements HttpHandler{

    private TemplatesProcessor templateProcessor;
    private Admin loggedUser;
    private GroupController groupController = GroupController.getInstance();


    public MenageClassesActions(){
        this.templateProcessor = new TemplatesProcessor();
    }

    public void setLoggedUser(Admin loggedUser) {
        this.loggedUser = loggedUser;
    }

    @Override
    public void handle(HttpExchange httpExchange) throws IOException {

        String responseBody;

        responseBody = menageClasses();
        int responseCode = 200;


        httpExchange.sendResponseHeaders(responseCode, responseBody.getBytes().length);
        OutputStream os = httpExchange.getResponseBody();
        os.write(responseBody.getBytes());
        os.close();
    }

    private String menageClasses() {

        //temporary example of logged user. To remove when sessions will be implemented
        setLoggedUser(new Admin(15,"Janusz", "Kowal", "j.k@cc.pl", "typoweHasło"));

        Map<String, Object> variables = new HashMap<>();
        System.out.println("tutaj");
        List<Group> allGroups = null;

        try {
            allGroups = groupController.getAllGroups();
        } catch (DaoException e) {
            e.printStackTrace();
        }

        variables.put("user", loggedUser);
        variables.put("classesList", allGroups);

        System.out.println(variables);

        templateProcessor.setVariables(variables);

        String page = templateProcessor.ProcessTemplateToPage("admin/menage-classes");
        return page;
    }
}
