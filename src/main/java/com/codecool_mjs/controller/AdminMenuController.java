package com.codecool_mjs.controller;

import java.sql.SQLException;

public class AdminMenuController {

    private MentorController mentorController;

    public AdminMenuController() throws SQLException {
        this.mentorController = new MentorController();
    }

    public void showAllMentors() {
        this.mentorController.showMentorsAction();
    }
}
