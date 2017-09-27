package com.codecool_mjs.dataaccess.dao;

import com.codecool_mjs.dataaccess.ConnectionProvider;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

abstract public class Dao<T> implements DaoInterface<T> {

    abstract T createObject(ResultSet results) throws SQLException;
//    abstract List<T> prepareList(ResultSet results) throws SQLException;
    abstract String getQuery();

    @Override
    public List<T> getAll() {

        ArrayList<T> resultsList = null;

        try {
            Connection conn = ConnectionProvider.getConnection();
            Statement stnt = conn.createStatement();
            ResultSet results = stnt.executeQuery(getQuery());

            resultsList = new ArrayList<>();

            while (results.next()) {

                T object = createObject(results);
                resultsList.add(object);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return resultsList;
    }

    @Override
    public <U> List<T> getBy() {
        return null;
    }

    @Override
    public T getById(int id) {
        return null;
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
