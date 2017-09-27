package com.codecool_mjs.dataaccess;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConnectionProvider {

    private static ConnectionProvider instance = new ConnectionProvider();
    public static final String URL = "jdbc:sqlite:src/main/resources/data.db";
    public static final String DRIVER_CLASS = "org.sqlite.JDBC";


    private ConnectionProvider() {

        try {
            Class.forName(DRIVER_CLASS);
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }

    private Connection createConnection() throws SQLException{
        Connection connection = null;
        try {
            if (connection == null) {
                connection = DriverManager.getConnection(URL);
            }
            return connection;
        } catch (SQLException e) {
            System.out.println("ERROR: Unable to Connect to Database.");
            throw new SQLException("ERROR: Unable to Connect to Database.");
        }
    }

    public static Connection getConnection() throws SQLException{
        return instance.createConnection();
    }
}