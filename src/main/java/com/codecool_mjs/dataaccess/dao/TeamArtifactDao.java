package com.codecool_mjs.dataaccess.dao;

import com.codecool_mjs.model.Artifact;

import java.sql.ResultSet;
import java.sql.SQLException;

public class TeamArtifactDao extends Dao<Artifact> {

    Artifact createObject(ResultSet results) throws SQLException {

        String name = results.getString("name");
        String description = results.getString("description");
        Integer cost = results.getInt("cost");

        Artifact artifact = new Artifact(name, description, cost);

        return artifact;
    }

    String getQueryGetAll() {

        String query = "SELECT * FROM artifacts WHERE type = 'team'";

        return query;
    }

    String getQuerySearchBy(String category, String arg) {

        String query = "SELECT * FROM artifacts WHERE " + category + " LIKE '" + arg + "' AND type = 'team'";

        return query;
    }
}
