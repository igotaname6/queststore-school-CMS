package com.codecool_mjs.dataaccess.dao;

import com.codecool_mjs.model.Codecooler;
import com.codecool_mjs.model.User;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class CodecoolerDao extends Dao<User> {

    private static String PROFESSION = "codecooler";

    @Override
    User createObject(ResultSet results) throws SQLException {

        User codecooler = null;

        Integer id = results.getInt("id");
        String name = results.getString("name");
        String surename = results.getString("surname");
        String email = results.getString("email");
        String password = results.getString("password");

        codecooler = new Codecooler(id, name, surename, email, password);

        return codecooler;
    }

    @Override
    Integer executeDeletion(User user) throws SQLException {
        Connection conn = getConnection();

        PreparedStatement statement = conn.prepareStatement(getDeletionStatement());
        statement.setInt(1, user.getId());


        Integer rowAffected = statement.executeUpdate();
        return rowAffected;
    }

    @Override
    String getQueryGetAll() {

        String query = "SELECT * FROM users WHERE profession = 'codecooler'";

        return query;
    }

    String getQuerySearchBy(String category, String arg) {

        String query = String.format("SELECT * FROM artifacts WHERE %s LIKE '%s' AND profession = 'codelooler'", category, arg);

        return query;
    }

    Integer executeInsertation(User user) throws SQLException {
        Connection conn = getConnection();

        PreparedStatement statement1 = conn.prepareStatement(getInsertationStatement());
        statement1.setString(1, user.getName());
        statement1.setString(2, user.getSurname());
        statement1.setString(3, user.getEmail());
        statement1.setString(4, user.getPassword());
        statement1.setString(5, PROFESSION);

        Integer rowAffected = statement1.executeUpdate();
        return rowAffected;
    }

    private String getInsertationStatement(){
        return "INSERT INTO users (" +
                            "name, surname, email, password, profession)" +
                             "VALUES (?, ?, ?, ?, ?)";
    }

    private String getDeletionStatement() {
        return "DELETE FROM users WHERE id = ?;";
    }
}


