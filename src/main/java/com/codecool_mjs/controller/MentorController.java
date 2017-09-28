package com.codecool_mjs.controller;

import com.codecool_mjs.dataaccess.dao.Dao;
import com.codecool_mjs.dataaccess.dao.MentorDao;
import com.codecool_mjs.model.Mentor;
import com.codecool_mjs.model.User;

import java.sql.SQLException;

public class MentorController {

    private Dao<User> dao;

    public MentorController() throws SQLException {
        this.dao = new MentorDao();
    }

    public Mentor showMentorsAction() {
    }
}
