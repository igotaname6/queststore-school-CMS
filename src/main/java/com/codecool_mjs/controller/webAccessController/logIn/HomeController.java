package com.codecool_mjs.controller.webAccessController.logIn;

import com.codecool_mjs.view.webView.TemplatesProcessor;
import com.sun.net.httpserver.HttpExchange;
import com.sun.net.httpserver.HttpHandler;

import java.io.*;
import java.util.HashMap;
import java.util.Map;

public class HomeController implements HttpHandler {

    private TemplatesProcessor templatesProcessor;

    public HomeController() {
        this.templatesProcessor = new TemplatesProcessor();
    }

    @Override
    public void handle(HttpExchange httpExchange) throws IOException {

        String responseBody = templatesProcessor.ProcessTemplateToPage("index");

        httpExchange.sendResponseHeaders(200, responseBody.getBytes().length);
        OutputStream os = httpExchange.getResponseBody();
        os.write(responseBody.getBytes());
        os.close();
    }

    private Map<String, String> parseForm(HttpExchange httpExchange) throws IOException {

        InputStreamReader isr = new InputStreamReader(httpExchange.getRequestBody(), "utf-8");
        BufferedReader br = new BufferedReader(isr);
        String formData = br.readLine();

        String[] pairsArray = formData.split("&");

        Map<String, String> formMap = new HashMap<>();
        for(String pair: pairsArray){
            String[] keyValue = pair.split("=");
            formMap.put(keyValue[0], keyValue[1]);
        }
        return formMap;
    }


}
