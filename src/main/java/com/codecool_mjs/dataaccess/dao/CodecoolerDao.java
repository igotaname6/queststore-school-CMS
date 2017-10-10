package com.codecool_mjs.dataaccess.dao;

import com.codecool_mjs.model.Codecooler;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class CodecoolerDao extends Dao<Codecooler> {

    private static String PROFESSION = "codecooler";

    @Override
    Codecooler createObject(ResultSet results) throws SQLException {

        Codecooler codecooler = null;

        Integer id = results.getInt("id");
        String name = results.getString("name");
        String surename = results.getString("surname");
        String email = results.getString("email");
        String password = results.getString("password");

        codecooler = new Codecooler(id, name, surename, email, password);

        return codecooler;
    }

    @Override
    Integer executeDeletion(Codecooler codecooler) throws SQLException {
        Connection conn = getConnection();

        PreparedStatement statement = conn.prepareStatement(getDeletionStatement());
        statement.setInt(1, codecooler.getId());


        Integer rowAffected = statement.executeUpdate();
        return rowAffected;
    }

    @Override
    String getQueryForGetAll() {

        String query = "SELECT * FROM users WHERE profession = 'codecooler'";

        return query;
    }

    String getQueryForSearchBy(String category, String arg) {

        String query = String.format("SELECT * FROM artifacts WHERE %s LIKE '%s' AND profession = 'codelooler'", category, arg);

        return query;
    }

    Integer executeInsertation(Codecooler codecooler) throws SQLException {
        Connection conn = getConnection();

        PreparedStatement statement1 = conn.prepareStatement(getInsertationStatement());
        statement1.setString(1, codecooler.getName());
        statement1.setString(2, codecooler.getSurname());
        statement1.setString(3, codecooler.getEmail());
        statement1.setString(4, codecooler.getPassword());
        statement1.setString(5, PROFESSION);

        Integer rowAffected = statement1.executeUpdate();
        return rowAffected;
    }

    protected Integer executeUpdateStatements(Codecooler codecooler) throws SQLException {
        Connection connection = getConnection();

        PreparedStatement statement = connection.
                prepareStatement(getUpdateStatement());

        statement.setString(1, codecooler.getName());
        statement.setString(2, codecooler.getSurname());
        statement.setString(3, codecooler.getEmail());
        statement.setString(4, codecooler.getPassword());

        Integer rowAffected =statement.executeUpdate();
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

    private String getUpdateStatement(){
        return "UPDATE users " +
                "set name = ?, surname = ?, email = ?, password = ?";
    }


}


