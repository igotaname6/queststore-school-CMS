package com.codecool_mjs.dataaccess.dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

abstract public class Dao<T> implements DaoInterface<T> {

    abstract T createObject(ResultSet results) throws SQLException;
    abstract List<T> prepareList(ResultSet results) throws SQLException;
    abstract String getQuery();
}
