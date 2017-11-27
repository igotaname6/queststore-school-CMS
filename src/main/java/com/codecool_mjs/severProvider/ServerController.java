package com.codecool_mjs.severProvider;

import com.codecool_mjs.controller.webAccessController.adminActionsController.*;
import com.codecool_mjs.controller.webAccessController.logIn.HomeController;
import com.codecool_mjs.controller.webAccessController.mentorActionController.MentorHomeController;
import com.codecool_mjs.controller.webAccessController.studentActionController.StudentHomeController;
import com.codecool_mjs.controller.webAccessController.utilController.StaticController;
import com.sun.net.httpserver.HttpServer;

import java.io.IOException;
import java.net.InetSocketAddress;

public class ServerController {

    public void createAndStartSever() throws IOException {

            HttpServer server = HttpServer.create(new InetSocketAddress(8000), 0);
            server.createContext("/home", new HomeController());
            server.createContext("/admin-home", new AdminHomeController());
            server.createContext("/mentors", new MenageMentorsActions());
            server.createContext("/mentors/add",new AddMentorController());
            server.createContext("/mentors/edit", new EditMentorsActions());
            server.createContext("/mentors/delete", new DeleteMentorsActions());
            server.createContext("/classes", new MenageClassesActions());
            server.createContext("/classes/add", new AddClassController());
            server.createContext("/mentor-home", new MentorHomeController());
            server.createContext("/student-home", new StudentHomeController());
            server.createContext("/static", new StaticController());
            server.setExecutor(null);
            server.start();
    }
}
