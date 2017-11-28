package com.codecool_mjs.controller.webAccessController.adminActionsController;

import com.codecool_mjs.controller.applicationActionsController.GroupController;
import com.codecool_mjs.controller.webAccessController.Sessionable;
import com.codecool_mjs.controller.webAccessController.WebActionController;
import com.codecool_mjs.dataaccess.dao.DaoException;
import com.codecool_mjs.model.Admin;
import com.codecool_mjs.model.Group;
import com.codecool_mjs.utilities.UriResolver;
import com.codecool_mjs.view.webView.TemplatesProcessor;
import com.sun.net.httpserver.HttpExchange;
import com.sun.net.httpserver.HttpHandler;

import java.io.IOException;
import java.io.OutputStream;
import java.util.HashMap;
import java.util.Map;

public class DeleteClassActions extends WebActionController implements Sessionable{

    private GroupController groupController;

    public DeleteClassActions(){
        super();
        this.groupController = GroupController.getInstance();
    }

    private String showClassToDelete(Integer id) throws DaoException{

        Group group;
        group = groupController.getGroup(id);
        setVariable("class", group);

        String page = processTemplate("admin/delete-class");
        return page;
    }

    private String deleteClass(Integer id) throws DaoException{

        groupController.deleteGroup(id);

        String page = processTemplate("admin/delete-confirmation");
        return page;
    }

    @Override
    public String getAccessType() {
        return "Admin";
    }

    @Override
    public void sendPageForPopperAccess(HttpExchange httpExchange) throws IOException, DaoException {
        String responseBody = "";
        int responseCode = 200;

        String method = httpExchange.getRequestMethod();
        String idStr = UriResolver.getUserIdFromURI(httpExchange);

        if(method.equals("GET")) {

            Integer id = Integer.parseInt(idStr);
            responseBody = showClassToDelete(id);
        }
        if(method.equals("POST")) {

            Integer id = Integer.parseInt(idStr);
            responseBody = deleteClass(id);
        }

        httpExchange.sendResponseHeaders(responseCode, responseBody.getBytes().length);
        OutputStream os = httpExchange.getResponseBody();
        os.write(responseBody.getBytes());
        os.close();
    }
}
