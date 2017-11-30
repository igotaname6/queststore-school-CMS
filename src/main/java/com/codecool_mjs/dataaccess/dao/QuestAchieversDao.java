package com.codecool_mjs.dataaccess.dao;

import com.codecool_mjs.model.QuestAchievers;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class QuestAchieversDao {

    private Connection connection;

    private static final String URL = "jdbc:sqlite:src/main/resources/queststore.db";
    private static final String DRIVER_CLASS = "org.sqlite.JDBC";


    public QuestAchieversDao () throws DaoException {
        setConnection();
    }

    public void setConnection() throws DaoException {
        try {
            Class.forName(DRIVER_CLASS);
            this.connection = DriverManager.getConnection(URL);
        } catch (ClassNotFoundException | SQLException e) {
            throw new DaoException("Exception in setConnection in QuestAchieversDao");
        }
    }

    public void addQuestAchiever(QuestAchievers questAchievers) {
        PreparedStatement stmt;

        String update =  "INSERT INTO quest_achievers (quest_id, achiever_id) VALUES (?, ?);";

        try {
            stmt = this.connection.prepareStatement(update);

            stmt.setInt(1, questAchievers.getQuest().getId());
            stmt.setInt(2, questAchievers.getCodecooler().getId());

            stmt.executeUpdate();
            stmt.close();

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
