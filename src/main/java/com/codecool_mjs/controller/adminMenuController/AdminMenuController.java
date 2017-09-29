package com.codecool_mjs.controller.adminMenuController;

import com.codecool_mjs.controller.mentorController.MentorController;
import com.codecool_mjs.view.AdminMenuView;

import java.sql.SQLException;

public class AdminMenuController {

    private MentorController mentorController;
    private boolean isRunning;

    public AdminMenuController() {
        this.mentorController = new MentorController();
        this.isRunning = true;
    }

    private void showAllMentors() {
        this.mentorController.showMentorsAction();
    }

    private void redirect() {

        AdminMenuView.printAdminMenu();
        String pickedMenuOption = AdminMenuView.getAdminMenuInput();

        if (pickedMenuOption.equals("1")) {
            showAllMentors();
        } else if (pickedMenuOption.equals("9")) {
            this.isRunning = false;
        }
    }

    public void startController() {
        while (this.isRunning) {
            redirect();
        }
    }

}
