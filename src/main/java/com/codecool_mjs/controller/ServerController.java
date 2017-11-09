package com.codecool_mjs.controller;

import com.sun.net.httpserver.HttpServer;

import java.io.IOException;
import java.net.InetSocketAddress;

public class ServerController {

    public void createAndStartSever() throws IOException {

            HttpServer server = HttpServer.create(new InetSocketAddress(8000), 0);
            server.createContext("/admin", new AdminActionsController());
            server.createContext("/static", new StaticController());
            server.setExecutor(null);
            server.start();
    }
}
