package com.codecool_mjs.controller.mentorController;

import com.codecool_mjs.dataaccess.dao.Dao;
import com.codecool_mjs.dataaccess.dao.MentorDao;
import com.codecool_mjs.model.Mentor;
import com.codecool_mjs.model.User;
import com.codecool_mjs.view.MentorView;

import java.sql.SQLException;
import java.util.List;

public class MentorController {

    private Dao<Mentor> dao;

    public MentorController() {
        this.dao = new MentorDao();
    }

    public void showMentorsAction() {

        List<Mentor> mentors;
        mentors = this.dao.getAll();

        MentorView.printAllMentors(mentors);
    }
}
