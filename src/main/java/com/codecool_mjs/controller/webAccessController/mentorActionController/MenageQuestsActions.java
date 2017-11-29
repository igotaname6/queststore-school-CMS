package com.codecool_mjs.controller.webAccessController.mentorActionController;

import com.codecool_mjs.controller.applicationActionsController.QuestController;
import com.codecool_mjs.controller.webAccessController.Sessionable;
import com.codecool_mjs.controller.webAccessController.WebActionController;
import com.codecool_mjs.dataaccess.dao.DaoException;
import com.codecool_mjs.model.Quest;
import com.sun.net.httpserver.HttpExchange;

import java.io.IOException;
import java.io.OutputStream;
import java.util.List;

public class MenageQuestsActions extends WebActionController implements Sessionable {

    private static String CONFIRMATION_TEMPLATE_URL = "mentor/edit-confirmation";
    private static String DATA_TEMPLATE_URL = "mentor/menage-quests";
    private QuestController questController;

    public MenageQuestsActions(){
        super();
        questController = QuestController.getInstance();
    }

    public String menageQuestsAction() throws DaoException {

        List<Quest> allQuests = questController.getAllQuests();
        setVariable("questsList", allQuests);

        return processTemplate(DATA_TEMPLATE_URL);
    }

    @Override
    public String getAccessType() {
        return "Mentor";
    }

    @Override
    public void sendPageForProperAccess(HttpExchange httpExchange) throws IOException, DaoException {
        String responseBody;
        int responseCode = 200;

        responseBody = menageQuestsAction();

        httpExchange.sendResponseHeaders(responseCode, responseBody.getBytes().length);
        OutputStream os = httpExchange.getResponseBody();
        os.write(responseBody.getBytes());
        os.close();
    }
}
