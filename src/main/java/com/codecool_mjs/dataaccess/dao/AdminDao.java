package com.codecool_mjs.dataaccess.dao;

import com.codecool_mjs.model.Admin;
import com.codecool_mjs.model.User;

import java.sql.ResultSet;
import java.sql.SQLException;

public class AdminDao extends Dao<User> {

    public AdminDao() throws SQLException {}

    @Override
    User createObject(ResultSet results) throws SQLException {

        User admin = null;

        Integer id = results.getInt("id");
        String name = results.getString("name");
        String surname = results.getString("surename");
        String email = results.getString("email");
        String password = results.getString("password");

        admin = new Admin(id, name, surname, email, password);

        return admin;
    }

    @Override
    String getQueryGetAll() {

        String query = "SELECT * FROM users WHERE profession = 'admin'";

        return query;
    }

    @Override
    String getQuerySearchBy(String category, String arg) {

        String query = "SELECT * FROM users WHERE " + category + " LIKE '" + arg + "' WHERE profession = 'admin'";

        return query;
    }
}

