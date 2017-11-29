package com.codecool_mjs.controller.webAccessController.mentorActionController;

import com.codecool_mjs.controller.applicationActionsController.CodecoolerController;
import com.codecool_mjs.controller.webAccessController.Sessionable;
import com.codecool_mjs.controller.webAccessController.WebActionController;
import com.codecool_mjs.dataaccess.dao.DaoException;
import com.codecool_mjs.model.Codecooler;
import com.codecool_mjs.model.Mentor;
import com.codecool_mjs.utilities.UriResolver;
import com.sun.net.httpserver.HttpExchange;

import java.io.IOException;
import java.io.OutputStream;

public class DeleteStudentActions extends WebActionController implements Sessionable {

    private static String CONFIRMATION_TEMPLATE_URL = "mentor/delete-confirmation";
    private static String DATA_TEMPLATE_URL = "mentor/delete-student";
    private CodecoolerController codecoolerController;

    public DeleteStudentActions(){
        super();
        codecoolerController = CodecoolerController.getInstance();
    }


    private String showStudentToDeleteAction(Integer id) throws DaoException {

        Codecooler codecooler = codecoolerController.getCodecoolerById(id);
        setVariable("student", codecooler);

        return processTemplate(DATA_TEMPLATE_URL);
    }

    private String deleteMentorAction(Integer id) throws DaoException {

        codecoolerController.deleteCodecooler(id);

        String page = processTemplate(CONFIRMATION_TEMPLATE_URL);
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
        String idStr = UriResolver.getUserIdFromURI(httpExchange);

        if(method.equals("GET")) {

            Integer id = Integer.parseInt(idStr);

            responseBody = showStudentToDeleteAction(id);
        }

        if(method.equals("POST")) {

            Integer id = Integer.parseInt(idStr);

            responseBody = deleteMentorAction(id);
        }

        httpExchange.sendResponseHeaders(responseCode, responseBody.getBytes().length);
        OutputStream os = httpExchange.getResponseBody();
        os.write(responseBody.getBytes());
        os.close();
    }
}
