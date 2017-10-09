package com.codecool_mjs.dataaccess.dao;

import com.codecool_mjs.model.Quest;

import java.sql.ResultSet;
import java.sql.SQLException;

public class GroupDao extends Dao<Quest> {

    @Override
    Quest createObject(ResultSet results) throws SQLException {

        String name = results.getString("name");

        Quest quest = new Quest(name);

        return quest;
    }

    @Override
    String getQueryGetAll() {

        String query = "SELECT * FROM groups";

        return query;
    }

    @Override
    String getQuerySearchBy(String category, String arg) {

        String query = String.format("SELECT * FROM groups WHERE %s LIKE '%s'", category, arg);

        return query;
    }

    @Override
    Integer executeInsertation(Quest quest) throws SQLException {
        return null;
    }
}
