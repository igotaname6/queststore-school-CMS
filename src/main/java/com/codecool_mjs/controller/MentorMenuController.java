package com.codecool_mjs.controller;

import org.omg.CORBA.PRIVATE_MEMBER;

import java.sql.SQLException;

public class MentorMenuController {

    private CodecoolerController codecoolerController;
    private boolean isRunning;

    public MentorMenuController() throws SQLException{
        this.codecoolerController = new CodecoolerController();
        this.isRunning = true;
    }
}
