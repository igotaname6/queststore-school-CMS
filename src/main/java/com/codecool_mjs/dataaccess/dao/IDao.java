
package com.codecool_mjs.dataaccess.dao;

import java.sql.Connection;
import java.util.List;

public interface IDao<T> {
    public List<T> getAll() throws DaoException;
    public T getById(int id) throws DaoException;
    public int update(T t) throws DaoException;
    public int delete(T t) throws DaoException;
    public int insert(T t) throws DaoException;
    public void setConnection(Connection connection);
}