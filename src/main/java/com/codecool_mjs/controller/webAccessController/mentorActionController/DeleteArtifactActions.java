package com.codecool_mjs.controller.webAccessController.mentorActionController;

import com.codecool_mjs.controller.applicationActionsController.ArtifactController;
import com.codecool_mjs.controller.webAccessController.Sessionable;
import com.codecool_mjs.controller.webAccessController.WebActionController;
import com.codecool_mjs.dataaccess.dao.DaoException;
import com.codecool_mjs.model.Mentor;
import com.codecool_mjs.model.Artifact;
import com.codecool_mjs.utilities.UriResolver;
import com.sun.net.httpserver.HttpExchange;

import java.io.IOException;
import java.io.OutputStream;
import java.util.HashMap;
import java.util.Map;

public class DeleteArtifactActions extends WebActionController implements Sessionable {

    private static String CONFIRMATION_TEMPLATE_URL = "mentor/delete-confirmation";
    private static String DATA_TEMPLATE_URL = "mentor/delete-artifact";
    private ArtifactController artifactController;

    public DeleteArtifactActions(){
        super();
        artifactController = ArtifactController.getInstance();
    }

    private String showArtifactToDelete(Integer id) throws DaoException {

        Artifact artifact = artifactController.getArtifactById(id);
        setVariable("artifact", artifact);

        return processTemplate(DATA_TEMPLATE_URL);
    }

    private String deleteArtifactAction(Integer id) throws DaoException {

        artifactController.deleteArtifact(id);
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
            responseBody = showArtifactToDelete(id);
        }

        if(method.equals("POST")) {

            Integer id = Integer.parseInt(idStr);
            responseBody = deleteArtifactAction(id);
        }

        httpExchange.sendResponseHeaders(responseCode, responseBody.getBytes().length);
        OutputStream os = httpExchange.getResponseBody();
        os.write(responseBody.getBytes());
        os.close();
    }
}
