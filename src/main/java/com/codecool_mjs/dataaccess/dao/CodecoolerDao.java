package com.codecool_mjs.dataaccess.dao;

import com.codecool_mjs.model.Codecooler;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;

public class CodecoolerDao extends UserDao<Codecooler>{

    public CodecoolerDao() {
        super();
    }

    @Override
    String getProfession() {
        return "codecooler";
    }

    @Override
    Codecooler createObject(ResultSet results) throws SQLException {

        Integer id = results.getInt("id");
        String name = results.getString("name");
        String surname = results.getString("surname");
        String email = results.getString("email");
        String password = results.getString("password");

        Codecooler codecooler = new Codecooler(id, name, surname, email, password);
        return codecooler;
    }
}
