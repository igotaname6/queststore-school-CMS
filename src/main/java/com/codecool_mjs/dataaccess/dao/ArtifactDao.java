package com.codecool_mjs.dataaccess.dao;

import com.codecool_mjs.model.Artifact;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class ArtifactDao extends Dao<Artifact> {

    public ArtifactDao(Connection connection) {
        super(connection);
    }

    Artifact createObject(ResultSet results) throws SQLException {

        int id = results.getInt("id");
        String name = results.getString("name");
        String description = results.getString("description");
        int cost = results.getInt("cost");
        Boolean isGroup = results.getBoolean("is_group");

        return new Artifact(id, name, description, cost, isGroup);
    }

    @Override
    String getQueryForGetAll() {
        return "SELECT * FROM artifacts";
    }

    @Override
    String getQueryForGetById() {
        return "SELECT * FROM artifacts where id = %d";
    }

    @Override
    String getUpdateQuery() {
        return null;
    }

    @Override
    void setUpdateStatement(PreparedStatement preparedStatement, Artifact artifact) throws SQLException {

    }

    @Override
    String getDeleteQuery() {
        return null;
    }

    @Override
    void setDeleteStatement(PreparedStatement preparedStatement, Artifact artifact) throws SQLException {

    }

    @Override
    String getInsertQuery() {
        return null;
    }

    @Override
    void setInsertStatement(PreparedStatement preparedStatement, Artifact artifact) throws SQLException {

    }
}
