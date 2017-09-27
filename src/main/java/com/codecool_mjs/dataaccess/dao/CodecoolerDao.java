package com.codecool_mjs.dataaccess.dao;

import com.codecool_mjs.model.User;

import java.sql.ResultSet;
import java.sql.SQLException;

public class CodecoolerDao extends Dao<User> {
        private static String QUERY = "SELECT * FROM users WHERE profession = \"codecooler\";";

        @Override
        User createObject(ResultSet results) throws SQLException {
            return null;
        }

        @Override
        String getQuery() {
            return QUERY;
        }
    }


