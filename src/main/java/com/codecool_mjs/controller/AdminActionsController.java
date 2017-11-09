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

    private String processTemplateToPage() {
        ClassLoaderTemplateResolver templateResolver = new ClassLoaderTemplateResolver();
        templateResolver.setPrefix("web/templates/");
        templateResolver.setSuffix(".html");
        templateResolver.setTemplateMode("HTML5");

        TemplateEngine templateEngine = new TemplateEngine();
        templateEngine.setTemplateResolver(templateResolver);

        StringWriter writer = new StringWriter();
        Context context = new Context();
        context.setVariable();

        templateEngine.process("admin-show-mentors", context, writer);
        return writer.toString();
    }
}
