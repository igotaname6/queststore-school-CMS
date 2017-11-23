package com.codecool_mjs.dataaccess.dao;

import com.codecool_mjs.model.Admin;
import com.codecool_mjs.model.Codecooler;
import com.codecool_mjs.model.Mentor;
import com.codecool_mjs.model.User;

import java.sql.*;

public class LogInDao {

    private Connection connection;

    private static final String URL = "jdbc:sqlite:src/main/resources/queststore.db";
    private static final String DRIVER_CLASS = "org.sqlite.JDBC";


    public User checkLogin(String email, String password) throws DaoException {
        String query = "SELECT * FROM users WHERE email = ? AND password = ?";
        try {
            Class.forName(DRIVER_CLASS);
            this.connection = DriverManager.getConnection(URL);

            PreparedStatement preStatement = connection.prepareStatement(query);
            preStatement.setString(1, email);
            preStatement.setString(2, password);
            ResultSet rs = preStatement.executeQuery();

            User user;

            if (rs.isClosed()) {
                return null;
            }

            user = createUser(rs, email, password);

            connection.close();
            return user;
        } catch (SQLException | ClassNotFoundException e) {
            throw new DaoException("Exception in loginDao", e);
        }
    }

    private User createUser(ResultSet rs, String email, String password) throws SQLException {
        int id = rs.getInt("id");
        String name = rs.getString("name");
        String surname = rs.getString("surname");
        String profession = rs.getString("profession");

        User user = null;

        if (profession.equals("codecooler")) {
            user = new Codecooler(id, name, surname, email, password);
        } else if (profession.equals("mentor")) {
            user = new Mentor(id, name, surname, email, password);
        } else if (profession.equals("admin")) {
            user = new Admin(id, name, surname, email, password);
        }
        return user;
    }

    public boolean addSession(String uuid, int userId) throws DaoException {
        String query = "INSERT INTO sessions (session_id, user_id) VALUES(? , ?)";
        try {
            Class.forName(DRIVER_CLASS);
            this.connection = DriverManager.getConnection(URL);

            PreparedStatement preparedStatement = connection.prepareStatement(query);
            preparedStatement.setString(1, uuid);
            preparedStatement.setInt(2, userId);
            int result = preparedStatement.executeUpdate();
            if (result == 1) {
                return true;
            } else {
                return false;
            }

        } catch (ClassNotFoundException | SQLException e) {
            throw new DaoException("Exception in addSession", e);

        }
    }

    public boolean checkSessionStatus(String session_id) throws DaoException {
        String query = "SELECT * FROM sessions WHERE session_id = ?";

        try {
            Class.forName(DRIVER_CLASS);
            this.connection = DriverManager.getConnection(URL);

            PreparedStatement preparedStatement = connection.prepareStatement(query);
            preparedStatement.setString(1,  session_id);
            ResultSet rs = preparedStatement.executeQuery();
            if(rs.isClosed()){
                return false;
            } else {
                return true;
            }

        } catch (ClassNotFoundException | SQLException e) {
            throw new DaoException("exception in checkSessionStatus", e);
        }
    }
}