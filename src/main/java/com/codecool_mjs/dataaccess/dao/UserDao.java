package com.codecool_mjs.dataaccess.dao;

import com.codecool_mjs.model.User;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public abstract class UserDao<T extends User> extends Dao<T> {

    public UserDao(Connection connection) {
        super(connection);
    }

    public UserDao(){};

    @Override
    String getQueryForGetAll() {

        return String.format("SELECT * FROM users WHERE profession = '%s';", getProfession());
    }

    @Override
    String getQueryForGetById(){

        return String.format("Select * FROM users WHERE profession = '%s' AND id = ?", getProfession());
    }
    @Override
    String getQueryForGetLast() {
        String query = "SELECT * FROM users " +
                        "WHERE id = ( " +
                        "SELECT MAX(id) FROM users;";
        return query;
    }

    @Override
    String getUpdateQuery() {
        return "UPDATE users" +
                " SET name = ?," +
                " surname = ?," +
                " email = ?," +
                " password = ?" +
                " WHERE id = ?;";
    }

    @Override
    void setUpdateStatement(PreparedStatement preparedStatement, T t) throws SQLException{
        preparedStatement.setString(1, t.getName());
        preparedStatement.setString(2, t.getSurname());
        preparedStatement.setString(3, t.getEmail());
        preparedStatement.setString(4, t.getPassword());
        preparedStatement.setInt(5, t.getId());
    }

    @Override
    String getDeleteQuery() {
        return "DELETE from users where id=?;";
    }

    @Override
    void setDeleteStatement(PreparedStatement preparedStatement, T t) throws SQLException{
        preparedStatement.setInt(1, t.getId());

    }

    @Override
    String getInsertQuery(){
        return "INSERT INTO users (name, surname, email, password, profession)" +
                " VALUES(?, ?, ?, ?, ?);";
    }

    @Override
    void setInsertStatement(PreparedStatement preparedStatement, T t) throws SQLException{
        preparedStatement.setString(1, t.getName());
        preparedStatement.setString(2, t.getSurname());
        preparedStatement.setString(3, t.getEmail());
        preparedStatement.setString(4, t.getPassword());
        preparedStatement.setString(5, getProfession());
    }

    abstract String getProfession();

    @Override
    abstract T createObject(ResultSet results) throws SQLException;
}
