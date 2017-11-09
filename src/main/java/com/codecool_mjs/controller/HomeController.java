package com.codecool_mjs.controller;

import com.sun.net.httpserver.HttpExchange;
import com.sun.net.httpserver.HttpHandler;

import java.io.IOException;
import java.io.OutputStream;

public class HomeController implements HttpHandler {

    private TemplatesEngine templatesEngine;

    public HomeController() {
        this.templatesEngine = new TemplatesEngine();
    }

    @Override
    public void handle(HttpExchange httpExchange) throws IOException {


        String responseBody = templatesEngine.ProcessTemplateToPage("index");

        httpExchange.sendResponseHeaders(200, responseBody.getBytes().length);
        OutputStream os = httpExchange.getResponseBody();
        os.write(responseBody.getBytes());
        os.close();
    }
}
