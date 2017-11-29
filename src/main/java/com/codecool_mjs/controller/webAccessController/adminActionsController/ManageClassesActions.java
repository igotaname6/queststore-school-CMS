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

public class ManageClassesActions extends WebActionController implements Sessionable {

    private static String DATA_TEMPLATE_URL = "admin/menage-classes";
    private GroupController groupController;


    public ManageClassesActions(){
        super();
        this.groupController = GroupController.getInstance();
    }

    @Override
    public String getAccessType() {
        return "Admin";
    }

    @Override
    public void sendPageForProperAccess(HttpExchange httpExchange) throws IOException, DaoException {
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
        setVariable("classesList", allGroups);

        return processTemplate(DATA_TEMPLATE_URL);
    }
}
