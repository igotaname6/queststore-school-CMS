package com.codecool_mjs.dataaccess.dao;


import com.codecool_mjs.model.Quest;

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

        Quest quest = new Quest(id, name, description, reward, isGroup);
        return quest;
    }

    @Override
    String getQueryForGetAll() {
        return "SELECT * FROM quests;";
    }

    @Override
    String getQueryForGetById() {
        return "SELECT * FROM quests WHERE id = ?;";
    }

    @Override
    String getUpdateQuery() {
        return "UPDATE quests" +
                " SET name = ?, description = ?, reward = ?, is_group = ?" +
                " WHERE id = ?;";
    }

    @Override
    void setUpdateStatement(PreparedStatement preparedStatement, Quest quest) throws SQLException {
        preparedStatement.setString(1, quest.getName());
        preparedStatement.setString(2, quest.getDescription());
        preparedStatement.setInt(3, quest.getCoinReward());
        preparedStatement.setBoolean(4, quest.getIsGroup());
        preparedStatement.setInt(5, quest.getId());
    }

    @Override
    String getDeleteQuery() {
        return "DELETE FROM quests WHERE id = ?;";
    }

    @Override
    void setDeleteStatement(PreparedStatement preparedStatement, Quest quest) throws SQLException {
        preparedStatement.setInt(1, quest.getId());
    }

    @Override
    String getInsertQuery() {
        return "INSERT INTO quests (name, description, reward, is_group) VALUES(?, ?, ?, ?);";
    }

    @Override
    void setInsertStatement(PreparedStatement preparedStatement, Quest quest) throws SQLException {
        preparedStatement.setString(1, quest.getName());
        preparedStatement.setString(2, quest.getDescription());
        preparedStatement.setInt(3, quest.getCoinReward());
        preparedStatement.setBoolean(4, quest.getIsGroup());

    }
    @Override
    String getQueryForGetLast() {return null;}
}