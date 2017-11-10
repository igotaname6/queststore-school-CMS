package com.codecool_mjs.controller;

import com.codecool_mjs.view.webView.TemplatesProcessor;
import com.sun.net.httpserver.HttpExchange;
import com.sun.net.httpserver.HttpHandler;

import java.io.IOException;
import java.io.OutputStream;

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
}
