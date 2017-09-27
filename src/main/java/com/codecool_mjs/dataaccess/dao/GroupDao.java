package com.codecool_mjs.dataaccess.dao;

import com.codecool_mjs.model.Quest;

import java.sql.ResultSet;
import java.sql.SQLException;

public class GroupDao extends Dao<Quest> {

    private static String QUERY = "SELECT * FROM groups";

    @Override
    Quest createObject(ResultSet results) throws SQLException {

        String name = results.getString("name");

        Quest quest = new Quest(name);

        return quest;
    }

    @Override
    String getQuery() { return QUERY; }

    @Override
    String getIdQuery() {
        return null;
    }
}
