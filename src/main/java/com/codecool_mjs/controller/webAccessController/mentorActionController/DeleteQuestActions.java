package com.codecool_mjs.controller.webAccessController.mentorActionController;

import com.codecool_mjs.controller.applicationActionsController.QuestController;
import com.codecool_mjs.controller.webAccessController.Sessionable;
import com.codecool_mjs.controller.webAccessController.WebActionController;
import com.codecool_mjs.dataaccess.dao.DaoException;
import com.codecool_mjs.model.Quest;
import com.codecool_mjs.utilities.UriResolver;
import com.sun.net.httpserver.HttpExchange;

import java.io.IOException;
import java.io.OutputStream;

public class DeleteQuestActions extends WebActionController implements Sessionable {

    private static String CONFIRMATION_TEMPLATE_URL = "mentor/delete-confirmation";
    private static String DATA_TEMPLATE_URL = "mentor/delete-quest";
    private QuestController questController;


    public DeleteQuestActions(){
        super();
        questController = QuestController.getInstance();
    }


    private String showQuestToDeleteAction(Integer id) throws DaoException {

        Quest quest = questController.getQuestById(id);

        setVariable("quest", quest);

        String page = processTemplate(DATA_TEMPLATE_URL);
        return page;
    }

    private String deleteMentorAction(Integer id) throws DaoException {

        questController.deleteQuest(id);

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

            responseBody = showQuestToDeleteAction(id);
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
