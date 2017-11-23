package com.codecool_mjs.dataaccess;

import com.codecool_mjs.dataaccess.dao.DaoException;
import com.codecool_mjs.dataaccess.dao.IDao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.Map;

public class ConnectionProvider {

    private static ConnectionProvider instance = null;
    private static final String URL = "jdbc:sqlite:src/main/resources/queststore.db";
    private static final String DRIVER_CLASS = "org.sqlite.JDBC";
    private Map<String, Connection> connections;


    private ConnectionProvider(){
        connections = new HashMap<>();
    }

    public static ConnectionProvider getInstance() {
        if(instance==null){
            instance = new ConnectionProvider();
        }
        return instance;
    }

    public void connectionRequest(IDao dao) throws DaoException{
        String daoName = dao.getClass().getName();

        try{
            Class.forName(DRIVER_CLASS);
            Connection connection = DriverManager.getConnection(URL);
            dao.setConnection(connection);
            connections.put(daoName, connection);
        } catch (ClassNotFoundException | SQLException e) {
            String message = "exception in Connection provider";
            throw new DaoException(message, e);
        }
    }
}