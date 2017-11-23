package com.codecool_mjs.dataaccess.dao;

import com.codecool_mjs.model.UserMembership;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class UserMembershipDao extends Dao<UserMembership>{
    @Override
    UserMembership createObject(ResultSet results) throws SQLException {
        return null;
    }

    @Override
    String getQueryForGetAll() {
        return null;
    }

    @Override
    String getQueryForGetById() {
        return null;
    }

    @Override
    String getUpdateQuery() {
        return null;
    }

    @Override
    void setUpdateStatement(PreparedStatement preparedStatement, UserMembership userMembership) throws SQLException {
    }

    @Override
    String getDeleteQuery() {
        return null;
    }

    @Override
    void setDeleteStatement(PreparedStatement preparedStatement, UserMembership userMembership) throws SQLException {

    }

    @Override
    String getInsertQuery() {
        return "INSERT INTO user_membership (user_id, group_id) VALUES(?, ?);";
    }

    @Override
    void setInsertStatement(PreparedStatement preparedStatement, UserMembership userMembership) throws SQLException {
        preparedStatement.setInt(1, userMembership.getUser().getId());
        preparedStatement.setInt(1, userMembership.getGroup().getId());
    }
    @Override
    String getQueryForGetLast() {return null;}
}
