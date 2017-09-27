package com.codecool_mjs.dataaccess.dao;

import com.codecool_mjs.model.User;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

public class MentorDao extends Dao<User> {
    private static String QUERY = "GET * FROM MENTORS";

    @Override
    User createObject(ResultSet results) throws SQLException {
        return null;
    }

    @Override
    String getQuery() {
        return null;
    }
}
