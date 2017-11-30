package com.codecool_mjs.controller.webAccessController.studentActionController;

import com.codecool_mjs.controller.applicationActionsController.QuestController;
import com.codecool_mjs.controller.webAccessController.Sessionable;
import com.codecool_mjs.controller.webAccessController.WebActionController;
import com.codecool_mjs.dataaccess.dao.DaoException;
import com.codecool_mjs.model.Quest;
import com.sun.net.httpserver.HttpExchange;

import java.io.IOException;
import java.io.OutputStream;
import java.util.List;

public class ShowAchievedQuestsActions extends WebActionController implements Sessionable {

    private static String DATA_TEMPLATE_URL = "student/show-quests";
    private QuestController questController;

    public ShowAchievedQuestsActions(){
        super();
        questController = QuestController.getInstance();
    }

    public String showAchievedQuestsAction() throws DaoException {

        List<Quest> achievedQuests = questController.getUserAchievedQuests(getLoggedUser().getId());
        setVariable("questsList", achievedQuests);

        return processTemplate(DATA_TEMPLATE_URL);
    }

    @Override
    public String getAccessType() {
        return "Codecooler";
    }

    @Override
    public void sendPageForProperAccess(HttpExchange httpExchange) throws IOException, DaoException {

        String responseBody;
        int responseCode = 200;

        responseBody = showAchievedQuestsAction();

        httpExchange.sendResponseHeaders(responseCode, responseBody.getBytes().length);
        OutputStream os = httpExchange.getResponseBody();
        os.write(responseBody.getBytes());
        os.close();
    }
}
