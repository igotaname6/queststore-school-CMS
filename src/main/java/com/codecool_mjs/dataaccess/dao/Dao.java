package com.codecool_mjs.dataaccess.dao;


import com.codecool_mjs.dataaccess.ConnectionProvider;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

abstract public class Dao<T> implements DaoInterface<T> {
    private final Connection connection;

    public Dao() {

        this.connection = ConnectionProvider.getConnection();
    }

    abstract T createObject(ResultSet results) throws SQLException;
    abstract String getQueryGetAll();
    abstract String getQuerySearchBy(String category, String arg);
    abstract String getQueryDelete();
    abstract void executeDeletion(T t);

    public Connection getConnection() {
        return this.connection;
    }

    @Override
    public List<T> getAll() {

        ArrayList<T> resultsList = null;

        Statement statement;
        ResultSet results;

        try {
            statement = this.connection.createStatement();
            results = statement.executeQuery(getQueryGetAll());

            resultsList = new ArrayList<>();

            while (results.next()) {

                T object = createObject(results);
                resultsList.add(object);
            }
            statement.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return resultsList;
    }

    @Override
    public List<T> getBy(String category, String arg) {

        ArrayList<T> resultsList = null;

        Statement statement;
        ResultSet results;

        try {
            statement = this.connection.createStatement();
            results = statement.executeQuery(getQuerySearchBy(category, arg));

            resultsList = new ArrayList<>();

            while (results.next()) {

                T object = createObject(results);
                resultsList.add(object);
            }
            statement.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return resultsList;
    }


    @Override
    public boolean update(T t) {
        return false;
    }

    @Override
    public Integer delete(T t) {

        Integer deletedRows = null;

        try {
            executeDeletion(t);

        } catch ( SQLException e ) {
            e.printStackTrace();
        }
        return 1;
    }

    @Override
    public boolean insert(T t) {
        return false;
    }
}
