package com.codecool_mjs.dataaccess.dao;

import com.codecool_mjs.model.Group;
import com.codecool_mjs.model.Quest;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class GroupDao extends Dao<Group> {

    public GroupDao() {}

    @Override
    Group createObject(ResultSet results) throws SQLException {
        Integer id = results.getInt("id");
        String name = results.getString("name");
        return new Group(id, name);
    }

    @Override
    String getQueryForGetAll() {
        return String.format("SELECT * FROM groups;");
    }

    @Override
    String getQueryForGetById() {
        return  String.format("SELECT * FROM groups WHERE id = ?");
    }

    @Override
    String getUpdateQuery() {
        return "UPDATE groups" +
                " SET name = ?" +
                " WHERE id = ?;";
    }

    @Override
    void setUpdateStatement(PreparedStatement preparedStatement, Group group) throws SQLException {
        preparedStatement.setString(1, group.getName());
        preparedStatement.setInt(2, group.getId());
    }

    @Override
    String getDeleteQuery() {
        return null;
    }

    @Override
    void setDeleteStatement(PreparedStatement preparedStatement, Group group) throws SQLException {

    }

    @Override
    String getInsertQuery(){
        return "INSERT INTO groups (name) VALUES(?);";
    }

    @Override
    void setInsertStatement(PreparedStatement preparedStatement, Group group) throws SQLException {
        preparedStatement.setString(1, group.getName());
    }

    @Override
    String getQueryForGetLast() {
        return "SELECT * FROM groups\n" +
                "WHERE id = (\n" +
                "SELECT MAX(id) FROM groups);";
    }
}
