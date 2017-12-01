package com.codecool_mjs.dataaccess.dao;

import com.codecool_mjs.model.ArtifactOwner;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class ArtifactOwnerDao {

    private Connection connection;

    private static final String URL = "jdbc:sqlite:src/main/resources/queststore.db";
    private static final String DRIVER_CLASS = "org.sqlite.JDBC";


    public ArtifactOwnerDao() {

    }

    public void setConnection() throws DaoException {
        try {
            Class.forName(DRIVER_CLASS);
            this.connection = DriverManager.getConnection(URL);
        } catch (ClassNotFoundException | SQLException e) {
            throw new DaoException("Exception in setConnection in QuestAchieverDao");
        }
    }

    public void addArtifactOwner(ArtifactOwner artifactOwner) throws DaoException{
        PreparedStatement stmt;

        String update =  "INSERT INTO artifact_owners (artifact_id, owner_id) VALUES (?, ?);";

        try {
            stmt = this.connection.prepareStatement(update);
            stmt.setInt(1, artifactOwner.getArtifact().getId());
            stmt.setInt(2, artifactOwner.getCodecooler().getId());

            stmt.executeUpdate();
            stmt.close();

        } catch (SQLException e) {
            throw new DaoException("Exception in addartifactOwner");
        }
    }
}
