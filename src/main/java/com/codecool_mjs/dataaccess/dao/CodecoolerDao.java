package com.codecool_mjs.dataaccess.dao;

import com.codecool_mjs.model.Codecooler;

import java.sql.ResultSet;
import java.sql.SQLException;

public class CodecoolerDao extends UserDao<Codecooler> {

    private static String PROFESSION = "codecooler";

    @Override
    Codecooler createObject(ResultSet results) throws SQLException {

        Codecooler codecooler;

        Integer id = results.getInt("id");
        String name = results.getString("name");
        String surename = results.getString("surname");
        String email = results.getString("email");
        String password = results.getString("password");

        codecooler = new Codecooler(id, name, surename, email, password);

        return codecooler;
    }

    @Override
    String getProfession() {
        return PROFESSION;
    }
}


