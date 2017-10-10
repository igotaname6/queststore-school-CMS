package com.codecool_mjs.dataaccess.dao;


import com.codecool_mjs.model.Quest;
import com.codecool_mjs.model.User;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class QuestDao extends Dao<Quest> {

    @Override
    Quest createObject(ResultSet results) throws SQLException {

        Integer id = results.getInt("id");
        String name = results.getString("name");
        String description = results.getString("description");
        Integer reward = results.getInt("reward");
        Boolean isGroup = results.getBoolean("is_group");

        return new Quest(id, name, description, reward, isGroup);
    }

    @Override
    String getQueryForGetAll() {

        String query = "SELECT * FROM quests WHERE type = 'single';";

        return query;
    }

    String getQueryForSearchBy(String category, String arg) {

        String query = String.format("SELECT * FROM quests WHERE %s LIKE '%s' AND type = 'single'", category, arg);

        return query;
    }

    @Override
    String getInsertationStatement() {
        return null;
    }

    @Override
    Integer executeInsertation(Quest quest) throws SQLException {
        return null;
    }

    @Override
    Integer executeUpdateStatements(Quest quest) throws SQLException {
        return null;
    }

    @Override
    Integer executeDeletion(Quest quest) throws SQLException {
        Connection conn = getConnection();

        PreparedStatement statement = conn.prepareStatement(getDeletionStatement());
        statement.setInt(1, quest.getId());

        Integer rowAffected = statement.executeUpdate();
        return rowAffected;
    }

    private String getDeletionStatement() {
        return "DELETE FROM quests WHERE id = ?;";
    }
}