package com.codecool_mjs.controller.webAccessController.studentActionController;

import com.codecool_mjs.controller.applicationActionsController.ArtifactController;
import com.codecool_mjs.controller.applicationActionsController.ArtifactOwnerController;
import com.codecool_mjs.controller.applicationActionsController.CodecoolerController;
import com.codecool_mjs.controller.webAccessController.Sessionable;
import com.codecool_mjs.controller.webAccessController.WebActionController;
import com.codecool_mjs.dataaccess.dao.DaoException;
import com.codecool_mjs.model.Artifact;
import com.codecool_mjs.model.Codecooler;
import com.codecool_mjs.utilities.UriResolver;
import com.sun.net.httpserver.HttpExchange;

import java.io.IOException;
import java.io.OutputStream;
import java.util.List;

public class BuyArtifactsActions extends WebActionController implements Sessionable {

    private static String SHOW_ARTIFACTS_LIST_TEMPLATE_URL = "student/buy-artifacts";
    private static String SHOW_ARTIFACT_TEMPLATE_URL = "student/buy-artifact";
    private static String CONFIRMATION_TEMPLATE_URL = "student/buy-confirmation";
    private ArtifactController artifactController;
    private ArtifactOwnerController artifactOwnerController;
    private CodecoolerController codecoolerController;

    public BuyArtifactsActions(){
        super();
        codecoolerController = CodecoolerController.getInstance();
        artifactController = ArtifactController.getInstance();
        artifactOwnerController =  new ArtifactOwnerController();
    }


    private String shopArtifacts() throws DaoException {

        List<Artifact> allArtifacts = artifactController.getAllArtifacts();
        setVariable("artifactsList", allArtifacts);

        return processTemplate(SHOW_ARTIFACTS_LIST_TEMPLATE_URL);
    }

    private String buyArtifact(Integer id) throws DaoException {

        Artifact artifact = artifactController.getArtifactById(id);
        setVariable("artifact", artifact);

        return processTemplate(SHOW_ARTIFACT_TEMPLATE_URL);
    }

    private String showConfirmation() throws DaoException {

        return processTemplate(CONFIRMATION_TEMPLATE_URL);
    }

    @Override
    public String getAccessType() {
        return "Codecooler";
    }

    @Override
    public void sendPageForProperAccess(HttpExchange httpExchange) throws IOException, DaoException {

        String responseBody = "";
        int responseCode = 200;
        String method;
        String strId = UriResolver.getUserIdFromURI(httpExchange);
        method = httpExchange.getRequestMethod();

        if(method.equals("GET")){

            if(strId == null) {
                responseBody = shopArtifacts();

            } else {

                Integer id = Integer.parseInt(strId);
                responseBody = buyArtifact(id);
            }
        }

        if(method.equals("POST")){

            Codecooler codecooler = (Codecooler) getLoggedUser();
            Integer userId = getLoggedUser().getId();
            Integer artifactId = Integer.parseInt(strId);
            artifactOwnerController.addArtifactOwner(userId, artifactId);

            Artifact artifact = artifactController.getArtifactById(artifactId);
            codecooler.substractCoolCoins(artifact.getCost());
            codecoolerController.updateCodecoolerWallet((Codecooler) getLoggedUser());

            responseBody = showConfirmation();
        }


        httpExchange.sendResponseHeaders(responseCode, responseBody.getBytes().length);
        OutputStream os = httpExchange.getResponseBody();
        os.write(responseBody.getBytes());
        os.close();
    }
}
