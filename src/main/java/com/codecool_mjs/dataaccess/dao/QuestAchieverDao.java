package com.codecool_mjs.dataaccess.dao;

import com.codecool_mjs.model.QuestAchiever;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class QuestAchieverDao {

    private Connection connection;

    private static final String URL = "jdbc:sqlite:src/main/resources/queststore.db";
    private static final String DRIVER_CLASS = "org.sqlite.JDBC";


    public QuestAchieverDao() {
        try {
            setConnection();
        } catch (DaoException e) {
            e.printStackTrace();
        }
    }

    public void setConnection() throws DaoException {
        try {
            Class.forName(DRIVER_CLASS);
            this.connection = DriverManager.getConnection(URL);
        } catch (ClassNotFoundException | SQLException e) {
            throw new DaoException("Exception in setConnection in QuestAchieverDao");
        }
    }

    public void addQuestAchiever(QuestAchiever questAchiever) {
        PreparedStatement stmt;

        String update =  "INSERT INTO quest_achievers (quest_id, achiever_id) VALUES (?, ?);";

        try {
            stmt = this.connection.prepareStatement(update);

            stmt.setInt(1, questAchiever.getQuest().getId());
            stmt.setInt(2, questAchiever.getCodecooler().getId());

            stmt.executeUpdate();
            stmt.close();

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
