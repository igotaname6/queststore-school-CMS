package com.codecool_mjs.severProvider;

import com.codecool_mjs.controller.webAccessController.adminActionsController.AdminHomeController;
import com.codecool_mjs.controller.webAccessController.adminActionsController.ShowMentorsActions;
import com.codecool_mjs.controller.webAccessController.logIn.HomeController;
import com.codecool_mjs.controller.webAccessController.utilController.StaticController;
import com.sun.net.httpserver.HttpServer;

import java.io.IOException;
import java.net.InetSocketAddress;

public class ServerController {

    public void createAndStartSever() throws IOException {

            HttpServer server = HttpServer.create(new InetSocketAddress(8000), 0);
            server.createContext("/home", new HomeController());
            server.createContext("/admin-show-mentors", new ShowMentorsActions());
            server.createContext("/admin-home", new AdminHomeController());
            server.createContext("/static", new StaticController());
            server.setExecutor(null);
            server.start();
    }
}
