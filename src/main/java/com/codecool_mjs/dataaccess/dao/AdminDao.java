package com.codecool_mjs.dataaccess.dao;

import com.codecool_mjs.model.Admin;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;

public class AdminDao extends UserDao<Admin> {


    public AdminDao(Connection connection) {
        super(connection);
    }

    @Override
    String getPofession() {
        return "admin";
    }

    @Override
    Admin createObject(ResultSet results) throws SQLException {

        Integer id = results.getInt("id");
        String name = results.getString("name");
        String surname = results.getString("surname");
        String email = results.getString("email");
        String password = results.getString("password");

        Admin admin = new Admin(id, name, surname, email, password);

        return admin;
    }
}