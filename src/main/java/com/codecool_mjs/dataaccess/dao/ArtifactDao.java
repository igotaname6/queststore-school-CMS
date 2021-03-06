package com.codecool_mjs.dataaccess.dao;

import com.codecool_mjs.model.Artifact;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

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

    public List<Artifact> getArtifactsByUserId(int userId) throws DaoException {
        String query = "SELECT * FROM artifacts " +
                "  JOIN artifact_owners ON artifact_owners.artifact_id = artifacts.id " +
                "  WHERE artifact_owners.owner_id = ?;";

        Connection connection = getConnection();

        List<Artifact> artifactList =  new ArrayList<>();
        try {
            PreparedStatement preparedStatement = connection.prepareStatement(query);
            preparedStatement.setInt(1, userId);
            ResultSet resultSet = preparedStatement.executeQuery();
            while(resultSet.next()) {
                Artifact artifact = createObject(resultSet);
                artifactList.add(artifact);
            }
            return artifactList;
        } catch (SQLException e) {
            throw new DaoException("Exception in getArtifactsByUserId", e);
        }
    }

    @Override
    String getQueryForGetAll() {
        return "SELECT * FROM artifacts ORDER BY cost;";
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
