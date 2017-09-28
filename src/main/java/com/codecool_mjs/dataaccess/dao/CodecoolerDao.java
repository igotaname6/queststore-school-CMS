package com.codecool_mjs.dataaccess.dao;

import com.codecool_mjs.model.Codecooler;
import com.codecool_mjs.model.User;

import java.sql.ResultSet;
import java.sql.SQLException;

public class CodecoolerDao extends Dao<User> {

        private static String QUERY = "SELECT * FROM users WHERE profession = \"codecooler\";";

        @Override
        User createObject(ResultSet results) throws SQLException {

            User codecooler = null;

            Integer id = results.getInt("id");
            String name = results.getString("name");
            String surename = results.getString("surename");
            String email = results.getString("email");
            String password = results.getString("password");

            codecooler = new Codecooler(id, name, surename, email, password);

            return codecooler;
        }

        @Override
        String getQuery() {
            return QUERY;
        }

    String getQuerySearchBy(String category, String arg) {

        String query = "SELECT * FROM artifacts WHERE " + category + " LIKE '" + arg + "' AND profession = 'codelooler'";

        return query;
    }
    }


