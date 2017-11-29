package com.codecool_mjs.controller.webAccessController.studentActionController;

import com.codecool_mjs.controller.applicationActionsController.CodecoolerController;
import com.codecool_mjs.controller.webAccessController.Sessionable;
import com.codecool_mjs.controller.webAccessController.WebActionController;
import com.codecool_mjs.dataaccess.dao.DaoException;
import com.codecool_mjs.model.Codecooler;
import com.codecool_mjs.utilities.FormResolver;
import com.codecool_mjs.utilities.UriResolver;
import com.sun.net.httpserver.HttpExchange;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.util.Map;

public class EditUserActions extends WebActionController implements Sessionable {

    private static String CONFIRMATION_TEMPLATE_URL = "student/edit-confirmation";
    private static String DATA_TEMPLATE_URL = "student/edit-user-data";
    private CodecoolerController codecoolerController;

    public EditUserActions(){
        super();
        codecoolerController = CodecoolerController.getInstance();
    }

    private String editUserDataAction() throws DaoException {

        return processTemplate(DATA_TEMPLATE_URL);
    }

    @Override
    public String getAccessType() {
        return "Codecooler";
    }

    @Override
    public void sendPageForProperAccess(HttpExchange httpExchange) throws IOException, DaoException {
        String responseBody = "";
        int responseCode = 200;

        String method = httpExchange.getRequestMethod();

        if(method.equals("GET")) {
            responseBody = editUserDataAction();
        }

        if(method.equals("POST")) {

            String idStr = getLoggedUser().getId().toString();

            Map<String, String> records;

            InputStreamReader isr = new InputStreamReader(httpExchange.getRequestBody(), "UTF-8");
            BufferedReader br = new BufferedReader(isr);
            String dataForm = br.readLine();

            records = FormResolver.parseDataForm(dataForm);
            records.put("id", idStr);

            codecoolerController.editCodecooler(records);

            responseBody = processTemplate(CONFIRMATION_TEMPLATE_URL);
        }

        httpExchange.sendResponseHeaders(responseCode, responseBody.getBytes().length);
        OutputStream os = httpExchange.getResponseBody();
        os.write(responseBody.getBytes());
        os.close();
    }
}
