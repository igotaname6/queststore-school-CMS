package com.codecool_mjs.controller;

import com.codecool_mjs.dataaccess.dao.Dao;
import com.codecool_mjs.dataaccess.dao.MentorDao;
import com.codecool_mjs.model.Mentor;
import com.codecool_mjs.model.User;

public class MentorController {

    private Dao<User> dao = new MentorDao(new Dao.getConnection());

    public Mentor showMentorsAction() {
    }
}
