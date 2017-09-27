package com.codecool_mjs.dataaccess.dao;


import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

abstract public class Dao<T> implements DaoInterface<T> {
    private final Connection connection;

    public Dao(Connection connection){
        this.connection = connection;
    }

    abstract T createObject(ResultSet results) throws SQLException;
//    abstract List<T> prepareList(ResultSet results) throws SQLException;
    abstract String getQuery();
    abstract String getIdQuery();

    @Override
    public List<T> getAll() {

        ArrayList<T> resultsList = null;

        Connection connection;
        Statement statement;
        ResultSet results;

        try {
            statement = this.connection.createStatement();
            results = statement.executeQuery(getQuery());

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
    public T getById(int id) {
        Statement statement;
        ResultSet result;
        T object = null;

        try{
            statement = connection.createStatement();
            result = statement.executeQuery(getIdQuery());

            object = createObject(result);
        } catch (SQLException e){
            e.printStackTrace();
        }
        return object;
    }

    @Override
    public boolean update(T t) {
        return false;
    }

    @Override
    public boolean delete(T t) {
        return false;
    }

    @Override
    public boolean insert(T t) {
        return false;
    }
}
