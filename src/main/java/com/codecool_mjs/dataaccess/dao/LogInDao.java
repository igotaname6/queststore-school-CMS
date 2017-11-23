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


    public User getUserById(int id) throws DaoException {
        String query = "SELECT * from users WHERE id = ?";
        try {
            Class.forName(DRIVER_CLASS);
            this.connection = DriverManager.getConnection(URL);

            PreparedStatement preStatement = connection.prepareStatement(query);
            preStatement.setInt(1, id);
            ResultSet rs = preStatement.executeQuery();

            User user;

            if(rs.isClosed()){
                return null;
            }

            String name = rs.getString("name");
            String surname = rs.getString("surname");
            String email = rs.getString("email");
            String password = rs.getString("password");
            String profession = rs.getString("profession");

            switch(profession){
                case "codecooler": user = new Codecooler(id, name, surname, email, password);
                    break;
                case "mentor": user = new Mentor(id, name, surname, email, password);
                    break;
                case "admin": user = new Admin(id, name, surname, email, password);
                    break;
                default: user = null;
                    break;
            }
            connection.close();
            return user;
        } catch (SQLException | ClassNotFoundException e) {
            throw new DaoException("Exception in loginDao", e);
        }
    }
}
