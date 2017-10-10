package com.codecool_mjs.dataaccess.dao;

import com.codecool_mjs.model.User;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public abstract class UserDao<T extends User> extends Dao <T> {

    @Override
    Integer executeDeletion(T t) throws SQLException {
        Connection conn = getConnection();

        PreparedStatement statement = conn.prepareStatement(getDeletionStatement());
        statement.setInt(1, t.getId());


        Integer rowAffected = statement.executeUpdate();
        return rowAffected;
    }

    Integer executeInsertation(T t) throws SQLException {
        Connection connection = getConnection();

        PreparedStatement statement = connection.prepareStatement(getInsertationStatement());
        statement.setString(1, t.getName());
        statement.setString(2, t.getSurname());
        statement.setString(3, t.getEmail());
        statement.setString(4, t.getPassword());
        statement.setString(5, getProfession());

        Integer rowAffected = statement.executeUpdate();
        return rowAffected;
    }

    protected Integer executeUpdateStatements(T t) throws SQLException {
        Connection connection = getConnection();

        PreparedStatement statement = connection.
                prepareStatement(getUpdateStatement());

        statement.setString(1, t.getName());
        statement.setString(2, t.getSurname());
        statement.setString(3, t.getEmail());
        statement.setString(4, t.getPassword());
        statement.setInt(5, t.getId());

        Integer rowAffected = statement.executeUpdate();
        return rowAffected;
    }

    @Override
    String getQueryForGetAll() {

        String query = String.format("SELECT * FROM users WHERE profession = '%s'", getProfession());

        return query;
    }
    String getQueryForSearchBy(String category, String arg) {

        String query = String.format("SELECT * FROM artifacts WHERE %s LIKE '%s' AND profession = '%s'", category, arg, getProfession());

        return query;
    }

     String getInsertationStatement() {
        return "INSERT INTO users (" +
                "name, surname, email, password, profession)" +
                "VALUES (?, ?, ?, ?, ?)";
    }

    private String getDeletionStatement() {
        return "DELETE FROM users WHERE id = ?;";
    }

    private String getUpdateStatement() {
        return "UPDATE users " +
                "set name = ?, surname = ?, email = ?, password = ?" +
                "WHERE id = ?";
    }

    abstract String getProfession();

}
