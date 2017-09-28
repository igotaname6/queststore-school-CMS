package com.codecool_mjs.controller;

public class CodecoolerController {

    private Dao<User> dao;

    public CodecoolerController() throws SQLException {
        this.dao = new CodecoolerDao();
    }

    public void showCodecoolersAction() {

        List<User> codecoolers;
        codecoolers = this.dao.getAll();

        MentorView.printAllMentors(mentors);
    }
}

