package com.codecool_mjs.controller.webAccessController.adminActionsController;

import com.codecool_mjs.controller.applicationActionsController.MentorController;
import com.codecool_mjs.controller.webAccessController.Sessionable;
import com.codecool_mjs.controller.webAccessController.WebActionController;
import com.codecool_mjs.dataaccess.dao.DaoException;
import com.codecool_mjs.model.Mentor;
import com.codecool_mjs.utilities.FormResolver;
import com.codecool_mjs.utilities.UriResolver;
import com.sun.net.httpserver.HttpExchange;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.util.Map;

public class EditMentorsActions extends WebActionController implements Sessionable {

    private static String CONFIRMATION_TEMPLATE_URL = "admin/edit-confirmation";
    private static String DATA_TEMPLATE_URL = "admin/edit-mentor";
    private MentorController mentorController;

    public EditMentorsActions() {
        super();
        mentorController = new MentorController();
    }

    @Override
    public String getAccessType() {
        return "Admin";
    }

    @Override
    public void sendPageForProperAccess(HttpExchange httpExchange) throws IOException, DaoException {
        String responseBody = "";
        int responseCode = 200;

        String method = httpExchange.getRequestMethod();
        String idStr = UriResolver.getUserIdFromURI(httpExchange);

        if (method.equals("GET")) {
            Integer id = Integer.parseInt(idStr);
            responseBody = editMentor(id);
        }

        if (method.equals("POST")) {

            Map<String, String> records;

            InputStreamReader isr = new InputStreamReader(httpExchange.getRequestBody(), "UTF-8");
            BufferedReader br = new BufferedReader(isr);
            String dataForm = br.readLine();

            records = FormResolver.parseDataForm(dataForm);
            records.put("id", idStr);

            mentorController.editMentor(records);
            responseBody = processTemplate(CONFIRMATION_TEMPLATE_URL);
        }

        httpExchange.sendResponseHeaders(responseCode, responseBody.getBytes().length);
        OutputStream os = httpExchange.getResponseBody();
        os.write(responseBody.getBytes());
        os.close();
    }

    private String editMentor(Integer id) throws DaoException {

        Mentor mentor = mentorController.getMentorById(id);
        setVariable("mentor", mentor);

        return processTemplate(DATA_TEMPLATE_URL);
    }
}
