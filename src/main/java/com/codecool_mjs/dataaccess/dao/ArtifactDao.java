package com.codecool_mjs.dataaccess.dao;

import com.codecool_mjs.model.Artifact;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class ArtifactDao extends Dao<Artifact> {

    Artifact createObject(ResultSet results) throws SQLException {

        int id = results.getInt("id");
        String name = results.getString("name");
        String description = results.getString("description");
        int cost = results.getInt("cost");
        Boolean isGroup = results.getBoolean("is_group");
        Boolean isUsed = results.getBoolean("is_used");

        return new Artifact(id, name, description, cost, isGroup, isUsed);
    }

    @Override
    String getQueryForGetAll() {
        return "SELECT * FROM artifacts;";
    }

    @Override
    String getQueryForGetById() {
        return "SELECT * FROM artifacts where id = ?;";
    }

    @Override
    String getUpdateQuery() {
        return "UPDATE artifacts" +
                " SET name = ?," +
                " description = ?," +
                " cost = ?," +
                " is_group = ?," +
                " is_used  = ?" +
                " WHERE id = ?;";
    }

    @Override
    void setUpdateStatement(PreparedStatement preparedStatement, Artifact artifact) throws SQLException {
        preparedStatement.setString(1, artifact.getName());
        preparedStatement.setString(2, artifact.getDescription());
        preparedStatement.setInt(3, artifact.getCost());
        preparedStatement.setBoolean(4, artifact.getIsGroup());
        preparedStatement.setBoolean(5, artifact.getIsUsed());
        preparedStatement.setInt(6, artifact.getId());
    }

    @Override
    String getDeleteQuery() {
        return "DELETE FROM artifacts WHERE id = ?;";
    }

    @Override
    void setDeleteStatement(PreparedStatement preparedStatement, Artifact artifact) throws SQLException {
        preparedStatement.setInt(1, artifact.getId());
    }

    @Override
    String getInsertQuery() {
        return "INSERT INTO artifacts (name, description, cost, is_group, is_used)" +
                "VALUES(?, ?, ?, ?, ?);";
    }

    @Override
    void setInsertStatement(PreparedStatement preparedStatement, Artifact artifact) throws SQLException {
        preparedStatement.setString(1, artifact.getName());
        preparedStatement.setString(2, artifact.getDescription());
        preparedStatement.setInt(3, artifact.getCost());
        preparedStatement.setBoolean(4, artifact.getIsGroup());
        preparedStatement.setBoolean(5, artifact.getIsUsed());
    }
    @Override
    String getQueryForGetLast() {return null;}
}
