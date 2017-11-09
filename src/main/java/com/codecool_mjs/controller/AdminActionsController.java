package com.codecool_mjs.controller;

import com.sun.net.httpserver.HttpExchange;
import com.sun.net.httpserver.HttpHandler;
import org.thymeleaf.TemplateEngine;
import org.thymeleaf.context.Context;
import org.thymeleaf.templateresolver.ClassLoaderTemplateResolver;

import java.io.IOException;
import java.io.StringWriter;

public class AdminActionsController implements HttpHandler{

    @Override
    public void handle(HttpExchange httpExchange) throws IOException {

    }

    public void showAllMentors(){

    }
}
