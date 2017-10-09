package com.codecool_mjs.dataaccess.dao;

import com.codecool_mjs.model.TeamQuest;
import java.sql.ResultSet;
import java.sql.SQLException;

public class TeamQuestDao extends Dao<TeamQuest>{

    @Override
    TeamQuest createObject(ResultSet results) throws SQLException {

        Integer id = results.getInt("id");
        String name = results.getString("name");
        String description = results.getString("description");
        Integer reward = results.getInt("reward");

        return new TeamQuest(id, name, description, reward);
    }

    @Override
    String getQueryGetAll() {

        String query = "SELECT * FROM quests WHERE type = 'team';";

        return query;
    }

    String getQuerySearchBy(String category, String arg) {

        String query = "SELECT * FROM quests WHERE " + category + " LIKE '" + arg + "' AND type = 'team'";

        return query;
    }
}