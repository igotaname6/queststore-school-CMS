package com.codecool_mjs.controller.webAccessController.studentActionController;

import com.codecool_mjs.controller.applicationActionsController.ArtifactController;
import com.codecool_mjs.controller.webAccessController.Sessionable;
import com.codecool_mjs.controller.webAccessController.WebActionController;
import com.codecool_mjs.dataaccess.dao.DaoException;
import com.codecool_mjs.model.Artifact;
import com.sun.net.httpserver.HttpExchange;

import java.io.IOException;
import java.io.OutputStream;
import java.util.List;

public class ShowArtifactsActions extends WebActionController implements Sessionable {

    private static String DATA_TEMPLATE_URL = "student/show-artifacts";
    private ArtifactController artifactController;

    public ShowArtifactsActions(){
        super();
        artifactController = ArtifactController.getInstance();
    }


    public String showArtifactsAction() throws DaoException {

        List<Artifact> allArtifacts = artifactController.getAllArtifacts();
        setVariable("artifactsList", allArtifacts);

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

        responseBody = showArtifactsAction();

        httpExchange.sendResponseHeaders(responseCode, responseBody.getBytes().length);
        OutputStream os = httpExchange.getResponseBody();
        os.write(responseBody.getBytes());
        os.close();
    }
}
