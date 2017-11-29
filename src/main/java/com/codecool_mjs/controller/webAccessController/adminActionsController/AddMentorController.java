package com.codecool_mjs.controller.webAccessController.adminActionsController;

import com.codecool_mjs.controller.applicationActionsController.MentorController;
import com.codecool_mjs.controller.webAccessController.Sessionable;
import com.codecool_mjs.controller.webAccessController.WebActionController;
import com.codecool_mjs.dataaccess.dao.DaoException;
import com.codecool_mjs.utilities.FormResolver;
import com.sun.net.httpserver.HttpExchange;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.util.Map;

public class AddMentorController extends WebActionController implements Sessionable{

    private MentorController mentorController;
    private static String CONFIRMATION_TEMPLATE_URL = "admin/add-confirmation";
    private static String DATA_TEMPLATE_URL = "admin/create-mentor";

    public AddMentorController(){
        super();
        this.mentorController = new MentorController();
    }

    @Override
    public String getAccessType() {
        return "Admin";
    }

    @Override
    public void sendPageForProperAccess(HttpExchange httpExchange) throws IOException, DaoException{
        String responseBody = "";
        int responseCode = 200;

        String method = httpExchange.getRequestMethod();

        if(method.equals("GET")) {
            responseBody = processTemplate(DATA_TEMPLATE_URL);
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
            responseBody = processTemplate(CONFIRMATION_TEMPLATE_URL);
        }

        httpExchange.sendResponseHeaders(responseCode, responseBody.getBytes().length);
        OutputStream os = httpExchange.getResponseBody();
        os.write(responseBody.getBytes());
        os.close();
    }
}
