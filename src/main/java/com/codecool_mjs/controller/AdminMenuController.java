package com.codecool_mjs.controller;

import com.codecool_mjs.view.AdminMenuView;

import java.sql.SQLException;

public class AdminMenuController {

    private MentorController mentorController;

    public AdminMenuController() throws SQLException {
        this.mentorController = new MentorController();
    }

    private void showAllMentors() {
        this.mentorController.showMentorsAction();
    }

    private void redirect() {

        AdminMenuView.printAdminMenu();
        String pickedMenuOption = AdminMenuView.getAdminMenuInput();

        if (pickedMenuOption.equals("1")) {
            showAllMentors();
        }
    }


}
