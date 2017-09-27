package com.codecool_mjs.dataaccess.dao;

import com.codecool_mjs.model.Mentor;
import com.codecool_mjs.model.User;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

public class MentorDao extends Dao<User> {
    private static String QUERY = "SELECT * FROM users WHERE profession = 'mentor'";

    @Override
    User createObject(ResultSet results) throws SQLException {

<<<<<<< HEAD
        Integer id = results.getInt("id");
        String name = results.getString("name");
        String surname = results.getString("surname");
        String email = results.getString("email");
        String password = results.getString("password");

        User mentor = new Mentor(id, name, surname, email, password);

        return mentor;

    }

    @Override
    String getQuery() {
        return QUERY;
    }
}
