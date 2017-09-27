package com.codecool_mjs.dataaccess.dao;

import com.codecool_mjs.model.Quest;

public class QuestDao extends Dao<Quest>{

    private static String QUERY = "SELECT * FROM quests WHERE type = \"single\";";

}


