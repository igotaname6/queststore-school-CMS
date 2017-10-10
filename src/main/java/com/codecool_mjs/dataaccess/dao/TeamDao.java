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

        Team team = new Team(id, name);

        return team;
    }

    @Override
    String getQueryForGetAll() {

        String query = "SELECT * FROM teams";

        return query;
    }

    String getQueryForSearchBy(String category, String arg) {

        String query = String.format("SELECT * FROM teams WHERE %s LIKE '%s'", category, arg);

        return query;
    }

    @Override
    Integer executeInsertation(Team team) throws SQLException {
        return null;
    }

    @Override
    Integer executeDeletion(Team team) throws SQLException {
        Connection conn = getConnection();

        PreparedStatement statement = conn.prepareStatement(getDeletionStatement());
        statement.setInt(1, team.getId());

        Integer rowAffected = statement.executeUpdate();
        return rowAffected;
    }

    private String getDeletionStatement() {
        return "";
    }
}
