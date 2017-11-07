package com.codecool_mjs.dataaccess;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConnectionProvider {

    private static ConnectionProvider instance = new ConnectionProvider();
    public static final String URL = "jdbc:sqlite:src/main/resources/queststore.db";
    public static final String DRIVER_CLASS = "org.sqlite.JDBC";


    private ConnectionProvider() {

        try {
            Class.forName(DRIVER_CLASS);
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }

    public Connection createConnection() {
        Connection connection = null;
        try {
            if (connection == null) {
                connection = DriverManager.getConnection(URL);
            }

        } catch (SQLException e) {
            System.out.println("ERROR: Unable to create connection!");
        }
        return connection;
    }

    public static Connection getConnection() {
        return instance.createConnection();
    }
}