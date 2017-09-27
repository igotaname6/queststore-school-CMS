package com.codecool_mjs.dataaccess.dao;

import com.codecool_mjs.model.TeamQuest;
import java.sql.ResultSet;
import java.sql.SQLException;

public class TeamQuestDao extends Dao<TeamQuest>{

    private static String QUERY = "SELECT * FROM quests WHERE type = \"team\";";


}