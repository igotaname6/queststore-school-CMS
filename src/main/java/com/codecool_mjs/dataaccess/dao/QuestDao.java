package com.codecool_mjs.dataaccess.dao;


import com.codecool_mjs.model.Quest;
import java.sql.ResultSet;
import java.sql.SQLException;

public class QuestDao extends Dao<Quest>{

    private static String QUERY = "SELECT * FROM quests WHERE type = \"single\";";

    @Override
    Quest createObject(ResultSet results) throws SQLException {

        String name = results.getString("name");
        String description = results.getString("description");
        String reward = results.getString("reward");

        return Quest(name, description, reward);
    }

    @Override
    String getQuery() {
        return QUERY;
    }
}