package com.codecool_mjs.controller;

import com.codecool_mjs.view.MentorMenuView;

import java.sql.SQLException;

public class MentorMenuController {

    private CodecoolerController codecoolerController;
    private boolean isRunning;

    public MentorMenuController() {
        this.codecoolerController = new CodecoolerController();
        this.isRunning = true;
    }

    private void redirect() {

        MentorMenuView.printMentorMenu();
        String pickedMenuOption = MentorMenuView.getMentorMenuInput();

        if (pickedMenuOption.equals("1")) {
            showAllCodecoolers();
        } else if (pickedMenuOption.equals("2")) {
            this.isRunning = false;
        }
    }

    private void showAllCodecoolers() {
        this.codecoolerController.showCodecoolersAction();
    }

    public void startController() {
        while (this.isRunning) {
            redirect();
        }
    }
}
