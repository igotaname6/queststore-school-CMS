package com.codecool_mjs.dataaccess;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConnectionProvider {

    private static Connection connection = createConnection();
    public static final String URL = "jdbc:sqlite:data.db";
    public static final String DRIVER_CLASS = "org.sqlite.JDBC";

    private ConnectionProvider() {

        try {
            Class.forName(DRIVER_CLASS);
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }
}
