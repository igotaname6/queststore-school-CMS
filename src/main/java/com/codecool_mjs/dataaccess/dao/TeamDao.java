package com.codecool_mjs.dataaccess.dao;

import com.codecool_mjs.model.Team;

import java.sql.ResultSet;
import java.sql.SQLException;

public class TeamDao extends Dao<Team> {

    private static String QUERY = "SELECT * FROM teams";

    @Override
    Team createObject(ResultSet results) throws SQLException {

        String name = results.getString("name");

        Team team = new Team(name);

        return team;
    }

    @Override
    String getQuery() { return QUERY;}

    @Override
    String getIdQuery() {
        return null;
    }
}
