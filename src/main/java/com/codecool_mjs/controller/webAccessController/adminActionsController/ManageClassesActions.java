package com.codecool_mjs.controller.webAccessController.adminActionsController;

import com.codecool_mjs.controller.applicationActionsController.GroupController;
import com.codecool_mjs.controller.webAccessController.Sessionable;
import com.codecool_mjs.controller.webAccessController.WebActionController;
import com.codecool_mjs.dataaccess.dao.DaoException;
import com.codecool_mjs.model.Group;
import com.sun.net.httpserver.HttpExchange;

import java.io.IOException;
import java.io.OutputStream;
import java.util.List;

public class MenageClassesActions extends WebActionController implements Sessionable {

    private static String CONFIRMATION_TEMPLATE_URL = "admin/edit-confirmation";
    private static String DATA_TEMPLATE_URL = "admin/edit-mentor";
    private GroupController groupController;


    public MenageClassesActions(){
        this.groupController = GroupController.getInstance();
    }

    @Override
    public void handle(HttpExchange httpExchange) throws IOException {

        String responseBody;

        responseBody = manageClasses();
        int responseCode = 200;


        httpExchange.sendResponseHeaders(responseCode, responseBody.getBytes().length);
        OutputStream os = httpExchange.getResponseBody();
        os.write(responseBody.getBytes());
        os.close();
    }

    private String manageClasses() throws DaoException {

        List<Group> allGroups = groupController.getAllGroups();

        variables.put("user", loggedUser);
        variables.put("classesList", allGroups);

        System.out.println(variables);

        templateProcessor.setVariables(variables);

        String page = templateProcessor.ProcessTemplateToPage("admin/menage-classes");
        return page;
    }
}
