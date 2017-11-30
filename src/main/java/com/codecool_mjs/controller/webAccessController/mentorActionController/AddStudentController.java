package com.codecool_mjs.controller.webAccessController.mentorActionController;

import com.codecool_mjs.controller.applicationActionsController.CodecoolerController;
import com.codecool_mjs.controller.applicationActionsController.MentorController;
import com.codecool_mjs.controller.webAccessController.Sessionable;
import com.codecool_mjs.controller.webAccessController.WebActionController;
import com.codecool_mjs.dataaccess.dao.DaoException;
import com.codecool_mjs.model.Admin;
import com.codecool_mjs.model.Mentor;
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

public class AddStudentController extends WebActionController implements Sessionable {

    private static String CONFIRMATION_TEMPLATE_URL = "mentor/add-confirmation";
    private static String DATA_TEMPLATE_URL = "mentor/create-student";
    private CodecoolerController codecoolerController;

    public AddStudentController(){
        super();
        this.codecoolerController = CodecoolerController.getInstance();
    }


    private String addStudent() throws DaoException {

        String page = processTemplate(DATA_TEMPLATE_URL);
        return page;
    }

    @Override
    public String getAccessType() {
        return "Mentor";
    }

    @Override
    public void sendPageForProperAccess(HttpExchange httpExchange) throws IOException, DaoException {
        String responseBody = "";
        int responseCode = 200;

        String method = httpExchange.getRequestMethod();

        if(method.equals("GET")) {
            responseBody = addStudent();
        }

        if(method.equals("POST")) {

            Map<String, String> records;
            InputStreamReader isr = new InputStreamReader(httpExchange.getRequestBody());
            BufferedReader br = new BufferedReader(isr);
            String formData = br.readLine();
            records = FormResolver.parseDataForm(formData);
            codecoolerController.addCodecooler(records);

            responseBody = processTemplate(CONFIRMATION_TEMPLATE_URL);
        }

        httpExchange.sendResponseHeaders(responseCode, responseBody.getBytes().length);
        OutputStream os = httpExchange.getResponseBody();
        os.write(responseBody.getBytes());
        os.close();
    }
}
