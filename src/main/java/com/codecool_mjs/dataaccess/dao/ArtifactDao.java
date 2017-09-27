package com.codecool_mjs.dataaccess.dao;

import com.codecool_mjs.model.Artifact;

import java.sql.ResultSet;
import java.sql.SQLException;

public class ArtifactDao extends Dao<Artifact> {
    private static String QUARY = "SELECT * FROM artifacts WHERE type = 'single'";

    Artifact createObject(ResultSet results) throws SQLException {

        String name = results.getString("name");
        String description = results.getString("description");
        Integer cost = results.getInt("cost");

        Artifact artifact = new Artifact(name, description, cost);

        return artifact;
    }

    String getQuery() {
        return QUARY;
    }




}
