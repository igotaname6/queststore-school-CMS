package com.codecool_mjs.dataaccess.dao;

import com.codecool_mjs.model.Artifact;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class ArtifactDao extends Dao<Artifact> {

    Artifact createObject(ResultSet results) throws SQLException {

        Integer id = results.getInt("id");
        String name = results.getString("name");
        String description = results.getString("description");
        Integer cost = results.getInt("cost");
        Boolean isGroup = results.getBoolean("is_group");

        Artifact artifact = new Artifact(id, name, description, cost, isGroup);

        return artifact;
    }

    String getQueryForGetAll() {

        String query = "SELECT * FROM artifacts";

        return query;
    }

    String getQueryForSearchBy(String category, String arg) {

        String query = String.format("SELECT * FROM artifacts WHERE %s LIKE '%s'", category, arg);

        return query;
    }

    @Override
    String getInsertationStatement() {
        return "INSERT INTO artifacts (" +
                "name, description, cost, isGroup)" +
                "VALUES (?, ?, ?, ?)";
    }

    @Override
    Integer executeInsertation(Artifact artifact) throws SQLException {
        Connection connection = getConnection();

        PreparedStatement statement = connection.prepareStatement(getInsertationStatement());
        statement.setString(1, artifact.getName());
        statement.setString(2, artifact.getDescription());
        statement.setInt(3, artifact.getCost());
        statement.setBoolean(4, artifact.getIsGroup());



        Integer rowAffected = statement.executeUpdate();
        return rowAffected;
    }

    @Override
    Integer executeUpdateStatements(Artifact artifact) throws SQLException {
        return null;
    }

    @Override
    Integer executeDeletion(Artifact artifact) throws SQLException {
        Connection conn = getConnection();

        PreparedStatement statement = conn.prepareStatement(getDeletionStatement());
        statement.setInt(1, artifact.getId());

        Integer rowAffected = statement.executeUpdate();
        return rowAffected;
    }

    private String getDeletionStatement() {
        return "DELETE FROM artifacts WHERE id = ?;";
    }
}
