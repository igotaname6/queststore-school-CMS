package com.codecool_mjs.controller.webAccessController.mentorActionController;

import com.codecool_mjs.controller.applicationActionsController.ArtifactController;
import com.codecool_mjs.dataaccess.dao.DaoException;
import com.codecool_mjs.model.Mentor;
import com.codecool_mjs.model.Artifact;
import com.codecool_mjs.utilities.UriResolver;
import com.codecool_mjs.view.webView.TemplatesProcessor;
import com.sun.net.httpserver.HttpExchange;
import com.sun.net.httpserver.HttpHandler;

import java.io.IOException;
import java.io.OutputStream;
import java.util.HashMap;
import java.util.Map;

public class DeleteArtifactActions implements HttpHandler{

    private TemplatesProcessor templateProcessor;
    private Mentor loggedUser;
    private ArtifactController artifactController = ArtifactController.getInstance();


    public DeleteArtifactActions(){
        this.templateProcessor = new TemplatesProcessor();
    }

    public void setLoggedUser(Mentor loggedUser) {
        this.loggedUser = loggedUser;
    }

    @Override
    public void handle(HttpExchange httpExchange) throws IOException {

        String responseBody = "";
        int responseCode = 200;

        String method = httpExchange.getRequestMethod();
        String idStr = UriResolver.getUserIdFromURI(httpExchange);

        setLoggedUser(new Mentor(15,"Janusz", "Kowal", "j.k@cc.pl", "typoweHasło"));

        if(method.equals("GET")) {

            Integer id = Integer.parseInt(idStr);

            responseBody = showArtifactToDelete(id);
        }

        if(method.equals("POST")) {

            Integer id = Integer.parseInt(idStr);

            responseBody = deleteMentor(id);
        }

        httpExchange.sendResponseHeaders(responseCode, responseBody.getBytes().length);
        OutputStream os = httpExchange.getResponseBody();
        os.write(responseBody.getBytes());
        os.close();
    }

    private String showArtifactToDelete(Integer id){

        Artifact artifact = null;

        Map<String, Object> variables = new HashMap<>();

        try {
            artifact = artifactController.getArtifactById(id);
        } catch (DaoException e) {
            e.printStackTrace();
        }

        variables.put("user", loggedUser);
        variables.put("artifact", artifact);

        templateProcessor.setVariables(variables);
        String page = templateProcessor.ProcessTemplateToPage("mentor/delete-artifact");
        return page;
    }

    private String deleteMentor(Integer id) {

        try {
            artifactController.deleteArtifact(id);
        } catch (DaoException e) {
            e.printStackTrace();
        }

        Map<String, Object> variables = new HashMap<>();

        variables.put("user", loggedUser);

        templateProcessor.setVariables(variables);

        String page = templateProcessor.ProcessTemplateToPage("mentor/delete-confirmation");
        return page;
    }
}
