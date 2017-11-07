package com.codecool_mjs.dataaccess.dao;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

abstract public class Dao<T> implements IDao<T> {

    private final Connection connection;

    public Dao(Connection connection){
        this.connection = connection;
    }

    @Override
    public List<T> getAll() throws DaoException{

        String query = getQueryForGetAll();

        return get(query);
    }

    @Override
    public T getById(int id) throws DaoException{

        String query = getQueryForGetById();

        List<T> resultList = get(query);
        //Method returns first element, becouse in this case list always has only one element.
        return resultList.get(0);
    }




    private List<T> get(String query) throws DaoException{
        ArrayList<T> resultsList;

        Statement statement;
        ResultSet results;

        try {
            statement = this.connection.createStatement();
            results = statement.executeQuery(query);

            resultsList = new ArrayList<>();

            while (results.next()) {

                T object = createObject(results);
                resultsList.add(object);
            }
            statement.close();
        } catch (SQLException e) {
            String message = "Exception in get method";
            throw new DaoException(message, e);
        }

        return resultsList;

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
