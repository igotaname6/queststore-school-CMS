package com.codecool_mjs.dataaccess.dao;

import com.codecool_mjs.model.Artifact;
import com.codecool_mjs.model.User;

import java.sql.ResultSet;
import java.sql.SQLException;

public class ArtifactDao extends Dao<Artifact> {
    private static String QUARY = "SELECT * FROM artifacts";

    Artifact createObject(ResultSet results) throws SQLException {

        Integer id = results.getInt("id");
        String name = results.getString("name");
        String description = results.getString("description");
        Integer cost = results.getInt("cost");
        String type = results.getString("type");

        Artifact artifact = new Artifact(id, name, description, cost, type);

        return artifact;
    }

    String getQuery() {
        return QUARY;
    }




}
