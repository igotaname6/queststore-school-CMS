package com.codecool_mjs.dataaccess.dao;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

abstract public class Dao<T> implements IDao<T> {

    private Connection connection;

    public Dao(Connection connection){
        this.connection = connection;
    }

    public Dao(){
    }

    public Connection getConnection() {
        return connection;
    }

    @Override
    public List<T> getAll() throws DaoException{

        String query = getQueryForGetAll();
        try {
            PreparedStatement preparedStatement = connection.prepareStatement(query);
            return get(preparedStatement);
        } catch (SQLException e) {
           throw new DaoException("getAll exception", e);
        }
    }

    @Override
    public T getById(int id) throws DaoException{

        String query = getQueryForGetById();
        try {
            PreparedStatement statement = connection.prepareStatement(query);
            statement.setInt(1, id);
            return get(statement).get(0);
        } catch (SQLException e) {
            throw new DaoException("GetById exception", e);
        }
    }

    @Override
    public int update(T t) throws DaoException{

        int rowsAffected;

        try{
            PreparedStatement preparedStatement = this.connection.prepareStatement(getUpdateQuery());
            setUpdateStatement(preparedStatement, t);

            rowsAffected = preparedStatement.executeUpdate();
        }catch (SQLException e){
            String message = "Exception in update metgod";
            throw new DaoException(message, e);
        }
        return rowsAffected;
    }

    @Override
    public int delete(T t) throws DaoException{
        int rowsAffected;

        try{
            PreparedStatement preparedStatement = this.connection.prepareStatement(getDeleteQuery());
            setDeleteStatement(preparedStatement, t);

            rowsAffected = preparedStatement.executeUpdate();
        }catch (SQLException e){
            String message = "Exception in delete method";
            throw new DaoException(message, e);
        }
        return rowsAffected;
    }

    @Override
    public int insert(T t) throws DaoException{
        int rowsAffected;

        try{
            PreparedStatement preparedStatement = this.connection.prepareStatement(getInsertQuery());
            setInsertStatement(preparedStatement, t);

            rowsAffected = preparedStatement.executeUpdate();
        }catch (SQLException e){
            String message = "Exception in insert method";
            throw new DaoException(message, e);
        }
        return rowsAffected;
    }

    public void closeConnection() throws DaoException{
        try {
            this.connection.close();
        } catch (SQLException e) {
            String message = "Exception in close method";
            throw new DaoException(message, e);
        }
    }

    private List<T> get(PreparedStatement preparedStatement) throws DaoException{
        ArrayList<T> resultsList;

        ResultSet results;

        try {
            results = preparedStatement.executeQuery();

            resultsList = new ArrayList<>();

            while (results.next()) {
                T object = createObject(results);
                resultsList.add(object);
            }
            preparedStatement.close();
        } catch (SQLException e) {
            String message = "Exception in get method";
            throw new DaoException(message, e);
        }

        return resultsList;
    }

    public void setConnection(Connection connection){
        this.connection = connection;
    }

    abstract T createObject(ResultSet results) throws SQLException;
    abstract String getQueryForGetAll();
    abstract String getQueryForGetById();
    abstract String getUpdateQuery();
    abstract void setUpdateStatement(PreparedStatement preparedStatement, T t) throws SQLException;
    abstract String getDeleteQuery();
    abstract void setDeleteStatement(PreparedStatement preparedStatement, T t) throws SQLException;
    abstract String getInsertQuery();
    abstract void setInsertStatement(PreparedStatement preparedStatement, T t) throws SQLException;
}
