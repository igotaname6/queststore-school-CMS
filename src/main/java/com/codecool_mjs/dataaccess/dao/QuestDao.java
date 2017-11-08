package com.codecool_mjs.dataaccess.dao;


import com.codecool_mjs.model.Quest;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class QuestDao extends Dao<Quest> {


    public QuestDao(Connection connection) {
        super(connection);
    }

    @Override
    Quest createObject(ResultSet results) throws SQLException {
        return null;
    }

    @Override
    String getQueryForGetAll() {
        return null;
    }

    @Override
    String getQueryForGetById() {
        return null;
    }

    @Override
    String getUpdateQuery() {
        return null;
    }

    @Override
    void setUpdateStatement(PreparedStatement preparedStatement, Quest quest) throws SQLException {

    }

    @Override
    String getDeleteQuery() {
        return null;
    }

    @Override
    void setDeleteStatement(PreparedStatement preparedStatement, Quest quest) throws SQLException {

    }

    @Override
    String getInsertQuery() {
        return null;
    }

    @Override
    void setInsertStatement(PreparedStatement preparedStatement, Quest quest) throws SQLException {

    }
}