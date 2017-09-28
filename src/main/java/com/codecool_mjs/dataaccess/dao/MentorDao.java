package com.codecool_mjs.dataaccess.dao;

import com.codecool_mjs.model.Mentor;
import com.codecool_mjs.model.User;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;


public class MentorDao extends Dao<User> {

    public MentorDao() throws SQLException {}

    @Override
    User createObject(ResultSet results) throws SQLException {

        Integer id = results.getInt("id");
        String name = results.getString("name");
        String surname = results.getString("surname");
        String email = results.getString("email");
        String password = results.getString("password");

        User mentor = new Mentor(id, name, surname, email, password);

        return mentor;
    }

    @Override
    String getQueryGetAll() {

        String query = "SELECT * FROM users WHERE profession = 'mentor'";

        return query;
    }

    @Override
    String getQuerySearchBy(String category, String arg) {

        String query = "SELECT * FROM users WHERE " + category + " LIKE '" + arg + "' AND profession = 'mentor'";

        return query;
    }
}
