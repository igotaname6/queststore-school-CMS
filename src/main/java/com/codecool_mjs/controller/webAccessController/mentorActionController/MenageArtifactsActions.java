package com.codecool_mjs.controller.webAccessController.mentorActionController;

import com.codecool_mjs.controller.applicationActionsController.ArtifactController;
import com.codecool_mjs.controller.webAccessController.Sessionable;
import com.codecool_mjs.controller.webAccessController.WebActionController;
import com.codecool_mjs.dataaccess.dao.DaoException;
import com.codecool_mjs.model.Artifact;
import com.sun.net.httpserver.HttpExchange;

import java.io.IOException;
import java.io.OutputStream;
import java.util.List;

public class MenageArtifactsActions extends WebActionController implements Sessionable {

    private static String CONFIRMATION_TEMPLATE_URL = "mentor/edit-confirmation";
    private static String DATA_TEMPLATE_URL = "mentor/menage-artifacts";
    private ArtifactController artifactController;

    public MenageArtifactsActions(){
        super();
        artifactController = ArtifactController.getInstance();
    }


    public String menageArtifactsAction() throws DaoException {

        List<Artifact> allArtifacts = artifactController.getAllArtifacts();
        setVariable("artifactsList", allArtifacts);

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

        responseBody = menageArtifactsAction();

        httpExchange.sendResponseHeaders(responseCode, responseBody.getBytes().length);
        OutputStream os = httpExchange.getResponseBody();
        os.write(responseBody.getBytes());
        os.close();
    }
}
