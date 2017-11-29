package com.codecool_mjs.controller.webAccessController.adminActionsController;

import com.codecool_mjs.controller.applicationActionsController.SessionController;
import com.codecool_mjs.controller.webAccessController.Sessionable;
import com.codecool_mjs.controller.webAccessController.WebActionController;
import com.codecool_mjs.dataaccess.dao.DaoException;
import com.codecool_mjs.model.User;
import com.codecool_mjs.view.webView.TemplatesProcessor;
import com.sun.net.httpserver.HttpExchange;
import com.sun.net.httpserver.HttpHandler;

import java.io.IOException;
import java.io.OutputStream;
import java.util.HashMap;
import java.util.Map;

public class AdminHomeController extends WebActionController implements Sessionable{

    private static String TEMPLATE_URL = "/admin/home";

    public AdminHomeController(){
        super();
    }

    @Override
    public void sendPageForPopperAccess(HttpExchange httpExchange) throws IOException, DaoException{
        String responseBody;
        int responseCode;

        responseBody = processTemplate(TEMPLATE_URL);
        responseCode = 200;

        httpExchange.sendResponseHeaders(responseCode, responseBody.getBytes().length);
        OutputStream os = httpExchange.getResponseBody();
        os.write(responseBody.getBytes());
        os.close();
    }

    @Override
    public String getAccessType() {
        return "Admin";
    }
}
