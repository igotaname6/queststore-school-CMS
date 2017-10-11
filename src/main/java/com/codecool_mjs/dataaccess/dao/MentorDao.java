package com.codecool_mjs.dataaccess.dao;

import com.codecool_mjs.model.Mentor;
import com.codecool_mjs.model.User;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;


public class MentorDao extends UserDao<Mentor> {

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

    @Override
    String getQueryForGetAll() {

        String query = "SELECT * FROM users WHERE profession = 'mentor'";

        return query;
    }

    @Override
    String getQueryForSearchBy(String category, String arg) {

        String query = String.format("SELECT * FROM users WHERE %s LIKE '%s' AND profession = 'mentor'", category, arg);

        return query;
    }

    @Override
    String getProfession() {
        return null;
    }
}
