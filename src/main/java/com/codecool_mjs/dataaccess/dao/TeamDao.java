package com.codecool_mjs.dataaccess.dao;

import com.codecool_mjs.model.Quest;
import com.codecool_mjs.model.Team;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class TeamDao extends Dao<Team> {

    @Override
    Team createObject(ResultSet results) throws SQLException {
        Integer id = results.getInt("id");
        String name = results.getString("name");
        return new Team(id, name);
    }

    @Override
    String getQueryForGetAll() {
        return String.format("SELECT * FROM teams ORDER BY name;");
    }

    @Override
    String getQueryForGetById() {
        return  String.format("SELECT * FROM teams WHERE id = ?");
    }

    @Override
    String getUpdateQuery() {
        return "UPDATE groups" +
                " SET name = ?" +
                " WHERE id = ?;";
    }

    @Override
    void setUpdateStatement(PreparedStatement preparedStatement, Team team) throws SQLException {
        preparedStatement.setString(1, team.getName());
        preparedStatement.setInt(2, team.getId());
    }

    @Override
    String getDeleteQuery() {
        return "DELETE FROM teams WHERE id=?;";
    }

    @Override
    void setDeleteStatement(PreparedStatement preparedStatement, Team team) throws SQLException {
        preparedStatement.setInt(1, team.getId());
    }

    @Override
    String getInsertQuery() {
        return "INSERT INTO teams (name) VALUES(?);";
    }
    @Override
    String getQueryForGetLast() {return null;}

    @Override
    void setInsertStatement(PreparedStatement preparedStatement, Team team) throws SQLException {
        preparedStatement.setString(1, team.getName());
    }
}
