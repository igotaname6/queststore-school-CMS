package com.codecool_mjs.controller.webAccessController.mentorActionController;

import com.codecool_mjs.controller.applicationActionsController.CodecoolerController;
import com.codecool_mjs.controller.applicationActionsController.QuestController;
import com.codecool_mjs.controller.webAccessController.Sessionable;
import com.codecool_mjs.controller.webAccessController.WebActionController;
import com.codecool_mjs.dataaccess.dao.DaoException;
import com.codecool_mjs.model.Codecooler;
import com.codecool_mjs.model.Quest;
import com.codecool_mjs.utilities.FormResolver;
import com.sun.net.httpserver.HttpExchange;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.util.List;
import java.util.Map;

public class AddAchieverActions extends WebActionController implements Sessionable {

    private static String DATA_TEMPLATE_URL = "mentor/add-achiever";
    private CodecoolerController codecoolerController;
    private QuestController questController;

    public AddAchieverActions(){
        super();
        codecoolerController = CodecoolerController.getInstance();
        questController = QuestController.getInstance();
    }

    private String addAchieverAction() throws DaoException {

        List<Codecooler> allCodecoolers = codecoolerController.getAllCodecoolers();
        List<Quest> allQuests = questController.getAllQuests();

        setVariable("studentsList", allCodecoolers);
        setVariable("questsList", allQuests);

        return processTemplate(DATA_TEMPLATE_URL);
    }

    @Override
    public String getAccessType() {
        return "Mentor";
    }

    @Override
    public void sendPageForProperAccess(HttpExchange httpExchange) throws IOException, DaoException {

        String responseBody = "";
        int responseCode = 200;
        String method = httpExchange.getRequestMethod().toString();

        if(method.equals("GET")) {

            responseBody = addAchieverAction();
        }

        if(method.equals("POST")) {

            Map<String, String> records;

            InputStreamReader isr = new InputStreamReader(httpExchange.getRequestBody());
            BufferedReader br = new BufferedReader(isr);
            String formData = br.readLine();

            records = FormResolver.parseDataForm(formData);
            System.out.println(records);
        }



        httpExchange.sendResponseHeaders(responseCode, responseBody.getBytes().length);
        OutputStream os = httpExchange.getResponseBody();
        os.write(responseBody.getBytes());
        os.close();
    }
}
