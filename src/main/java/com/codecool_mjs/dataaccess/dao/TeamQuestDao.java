package com.codecool_mjs.dataaccess.dao;

import com.codecool_mjs.model.Quest;
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

        String query = String.format("SELECT * FROM quests WHERE %s LIKE '%s' AND type = 'team'", category, arg);

        return query;
    }

    @Override
    Integer executeInsertation(TeamQuest teamQuest) throws SQLException {
        return null;
    }

    @Override
    Integer executeDeletion(TeamQuest teamQuest) throws SQLException {
        return null;
    }
}