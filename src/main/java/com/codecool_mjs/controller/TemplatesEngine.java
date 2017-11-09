package com.codecool_mjs.controller;

import org.thymeleaf.TemplateEngine;
import org.thymeleaf.templateresolver.ClassLoaderTemplateResolver;

import java.util.Map;

public class TemplatesEngine {
    private TemplateEngine engine;
    private ClassLoaderTemplateResolver resolver;

    private Map<String, Object> templatesVariables;

    public TemplatesEngine(){
        // Creates new templateEngine
        this.engine = new TemplateEngine();
        // Creates resolver
        this.resolver = new ClassLoaderTemplateResolver();
        //Sets up engine by resolver
        resolver.setPrefix("web/templates/");
        resolver.setSuffix(".html");
        resolver.setTemplateMode("HTML5");
        engine.setTemplateResolver(resolver);

    }



}
