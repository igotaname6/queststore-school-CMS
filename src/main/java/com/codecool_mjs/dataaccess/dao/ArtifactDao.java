
package com.codecool_mjs.dataaccess.dao;

import com.codecool_mjs.model.Artifact;

import java.sql.ResultSet;
import java.sql.SQLException;

public class ArtifactDao extends Dao<Artifact> {

    Artifact createObject(ResultSet results) throws SQLException {

        String name = results.getString("name");
        String description = results.getString("description");
        Integer cost = results.getInt("cost");

        Artifact artifact = new Artifact(name, description, cost);
        return artifact;
    }

    String getQueryForGetAll() {
        return "SELECT * FROM artifacts WHERE type = 'single'";

    }

    String getQueryForSearchBy(String category, String arg) {

        String query = String.format("SELECT * FROM artifacts WHERE %s LIKE '%s'", category, arg);

        return query;
    }

}