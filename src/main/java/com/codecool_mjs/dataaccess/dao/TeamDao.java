package com.codecool_mjs.dataaccess.dao;

import com.codecool_mjs.model.Team;

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
    String getQueryGetAll() {

        String query = "SELECT * FROM teams";

        return query;
    }

    String getQuerySearchBy(String category, String arg) {

        String query = String.format("SELECT * FROM teams WHERE %s LIKE '%s'", category, arg);

        return query;
    }
}
