package com.codecool_mjs.dataaccess.dao;


import com.codecool_mjs.dataaccess.ConnectionProvider;

import java.sql.*;
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
    public Integer insert(T t) {

        Statement statement;
        Integer result = null;

        try{
            connection.setAutoCommit(false);
            result = executeInsertation(t);

            if (result==0){
                connection.rollback();
            }

            connection.commit();
            connection.setAutoCommit(true);

        } catch (SQLException e){
            e.printStackTrace();
        }
        return result;
    }

    abstract Integer executeInsertation(T t) throws SQLException;


    @Override
    public Integer update(T t) {
        return null;
    }

    @Override
    public Integer delete(T t) {
        return null;
    }
}
