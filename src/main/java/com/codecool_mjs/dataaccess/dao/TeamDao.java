package com.codecool_mjs.dataaccess.dao;

import com.codecool_mjs.model.Quest;
import com.codecool_mjs.model.Team;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class TeamDao extends Dao<Team> {


    public TeamDao(Connection connection) {
        super(connection);
    }

    @Override
    Team createObject(ResultSet results) throws SQLException {
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
    void setUpdateStatement(PreparedStatement preparedStatement, Team team) throws SQLException {

    }

    @Override
    String getDeleteQuery() {
        return null;
    }

    @Override
    void setDeleteStatement(PreparedStatement preparedStatement, Team team) throws SQLException {

    }

    @Override
    String getInsertQuery() {
        return null;
    }
    @Override
    String getQueryForGetLast() {return null;}

    @Override
    void setInsertStatement(PreparedStatement preparedStatement, Team team) throws SQLException {

    }
}
