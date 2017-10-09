package com.codecool_mjs.dataaccess.dao;

import com.codecool_mjs.model.Artifact;

import java.sql.ResultSet;
import java.sql.SQLException;

public class ArtifactDao extends Dao<Artifact> {

    Artifact createObject(ResultSet results) throws SQLException {

        Integer id = results.getInt("id");
        String name = results.getString("name");
        String description = results.getString("description");
        Integer cost = results.getInt("cost");

        Artifact artifact = new Artifact(id, name, description, cost);

        return artifact;
    }

    String getQueryGetAll() {

        String quary = "SELECT * FROM artifacts WHERE type = 'single'";

        return quary;
    }

    String getQuerySearchBy(String category, String arg) {

        String query = String.format("SELECT * FROM artifacts WHERE %s LIKE '%s' AND type = 'single'", category, arg);

        return query;
    }
}
