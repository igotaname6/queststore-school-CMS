package com.codecool_mjs.dataaccess.dao;

import com.codecool_mjs.model.Mentor;
import com.codecool_mjs.model.User;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;


public class MentorDao extends Dao<User> {

    @Override
    User createObject(ResultSet results) throws SQLException {

        Integer id = results.getInt("id");
        String name = results.getString("name");
        String surname = results.getString("surname");
        String email = results.getString("email");
        String password = results.getString("password");

        User mentor = new Mentor(id, name, surname, email, password);

        return mentor;
    }

    @Override
    String getQueryGetAll() {

        String query = "SELECT * FROM users WHERE profession = 'mentor'";

        return query;
    }

    @Override
    String getQuerySearchBy(String category, String arg) {

        String query = String.format("SELECT * FROM users WHERE %s LIKE '%s' AND profession = 'mentor'", category, arg);

        return query;
    }

    @Override
    Integer executeInsertation(User user) throws SQLException {
        return null;
    }

    @Override
    Integer executeDeletion(User user) throws SQLException {
        Connection conn = getConnection();

        PreparedStatement statement = conn.prepareStatement(getDeletionStatement());
        statement.setInt(1, user.getId());

        Integer rowAffected = statement.executeUpdate();
        return rowAffected;
    }

    private String getDeletionStatement() {
        return "";
    }
}
