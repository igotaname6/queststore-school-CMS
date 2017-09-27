package com.codecool_mjs.dataaccess.dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

abstract public class Dao<T> implements DaoInterface<T> {

    abstract T createObject(ResultSet results) throws SQLException;
//    abstract List<T> prepareList(ResultSet results) throws SQLException;
    abstract String getQuery();

    @Override
    public List<T> getAll() {
        return null;
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
