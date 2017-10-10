package com.codecool_mjs.dataaccess.dao;

import com.codecool_mjs.model.Admin;

import java.sql.ResultSet;
import java.sql.SQLException;

public class AdminDao extends UserDao<Admin> {

    private static String PROFESSION = "admin";

    @Override
    Admin createObject(ResultSet results) throws SQLException {

        Admin admin;

        Integer id = results.getInt("id");
        String name = results.getString("name");
        String surname = results.getString("surename");
        String email = results.getString("email");
        String password = results.getString("password");

        admin = new Admin(id, name, surname, email, password);

        return admin;
    }

    @Override
    String getProfession() {
        return PROFESSION;
    }
}