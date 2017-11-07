package com.codecool_mjs.dataaccess.dao;

import com.codecool_mjs.model.Mentor;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;


public class MentorDao extends UserDao<Mentor> {

    public MentorDao(Connection connection) {
        super(connection);
    }

    @Override
    String getPofession() {
        return "mentor";
    }

    @Override
    Mentor createObject(ResultSet results) throws SQLException {

        Integer id = results.getInt("id");
        String name = results.getString("name");
        String surname = results.getString("surname");
        String email = results.getString("email");
        String password = results.getString("password");

        Mentor mentor = new Mentor(id, name, surname, email, password);
        return mentor;
    }
}