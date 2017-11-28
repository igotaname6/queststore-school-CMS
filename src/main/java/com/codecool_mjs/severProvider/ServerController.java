package com.codecool_mjs.severProvider;

import com.codecool_mjs.controller.webAccessController.adminActionsController.*;
import com.codecool_mjs.controller.webAccessController.logIn.HomeController;
import com.codecool_mjs.controller.webAccessController.logIn.LogOutController;
import com.codecool_mjs.controller.webAccessController.mentorActionController.*;
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
        server.createContext("/classes/edit" , new EditClassActions());
        server.createContext("/classes/delete", new DeleteClassActions());
        server.createContext("/mentor-home", new MentorHomeController());
        server.createContext("/students", new MenageStudentsActions());
        server.createContext("/students/add", new AddStudentController());
        server.createContext("/students/edit", new EditStudentsActions());
        server.createContext("/students/delete", new DeleteStudentActions());
        server.createContext("/student-home", new StudentHomeController());
        server.createContext("/quests", new MenageQuestsActions());
        server.createContext("/quests/add", new AddQuestController());
        server.createContext("/quests/edit", new EditQuestActions());
        server.createContext("/quests/delete" , new DeleteQuestActions());
        server.createContext("/artifacts", new MenageArtifactsActions());
        server.createContext("/artifacts/add", new AddArtifactController());
        server.createContext("/artifacts/edit", new EditArtifactActions());
        server.createContext("/artifacts/delete", new DeleteArtifactActions());
        server.createContext("/static", new StaticController());
        server.createContext("/logout", new LogOutController());
        server.setExecutor(null);
        server.start();
    }
}
