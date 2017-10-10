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

    @Override
    public List<T> getAll() {

        ArrayList<T> resultsList = null;

        Statement statement;
        ResultSet results;

        try {
            statement = this.connection.createStatement();
            results = statement.executeQuery(getQueryForGetAll());

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
            results = statement.executeQuery(getQueryForSearchBy(category, arg));

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


    @Override
    public Integer delete(T t) {

        Integer result = null;

        try{
            connection.setAutoCommit(false);
            result = executeDeletion(t);

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

    @Override
    public Integer update(T t){

        Integer result = null;

        try{
            connection.setAutoCommit(false);
            result = executeUpdateStatements(t);

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

    public Connection getConnection() {
        return this.connection;
    }

    abstract Integer executeInsertation(T t) throws SQLException;
    abstract Integer executeUpdateStatements(T t) throws SQLException;
    abstract Integer executeDeletion(T t) throws SQLException;
    abstract T createObject(ResultSet results) throws SQLException;
    abstract String getQueryForGetAll();
    abstract String getQueryForSearchBy(String category, String arg);
    abstract String getInsertationStatement();




}
