package com.codecool_mjs.dataaccess.dao;

import com.codecool_mjs.model.Codecooler;
import com.codecool_mjs.model.Group;
import com.codecool_mjs.model.GroupMembership;
import com.codecool_mjs.model.Mentor;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

abstract public class MembershipDao<T> {

    private Connection connection;

    private static final String URL = "jdbc:sqlite:src/main/resources/queststore.db";
    private static final String DRIVER_CLASS = "org.sqlite.JDBC";


    public MembershipDao() {
        try {
            setConnection();
        } catch (DaoException e) {
            e.printStackTrace();
        }
    }

    public void setConnection() throws DaoException {
        try {
            Class.forName(DRIVER_CLASS);
            this.connection = DriverManager.getConnection(URL);
        } catch (ClassNotFoundException | SQLException e) {
            throw new DaoException("Exception in setConnection in MembershipDao");
        }
    }

    public List<T> getAll() throws DaoException{

        String query = getQueryForGetAll();
        try {
            PreparedStatement preparedStatement = connection.prepareStatement(query);
            return get(preparedStatement);
        } catch (SQLException e) {
            throw new DaoException("getAll exception", e);
        }
    }

    protected List<T> get(PreparedStatement preparedStatement) throws DaoException{
        ArrayList<T> resultsList;

        ResultSet results;

        try {
            results = preparedStatement.executeQuery();

            resultsList = new ArrayList<>();

            while (results.next()) {
                Mentor mentor = null;
                Codecooler codecooler = null;
                T membership;

               if (results.getString(9).equals("mentor")) {
                   mentor = createMentor(results);
               } else if ((results.getString(9).equals("codecooler"))) {
                   codecooler = createCodecooler(results);
               }

                if (resultsList.isEmpty() || getRelevantMembership(resultsList, results.getInt(10)) == null) {
                    membership = createMembership(results);
                    resultsList.add(membership);
                } else {
                   membership = getRelevantMembership(resultsList, results.getInt(10));
                }

                if (mentor != null) {
                   addMentorToMembership(membership, mentor);

                } else if (codecooler != null) {
                   addCodecoolerToMembership(membership, codecooler);
                }

            }
            preparedStatement.close();
        } catch (SQLException e) {
            String message = "Exception in get method";
            throw new DaoException(message, e);
        }

        return resultsList;
    }

    //TO DO: FIX BUG - adding to many Memberships
    abstract String getQueryForGetAll();
    abstract Codecooler createCodecooler(ResultSet results) throws SQLException;
    abstract Mentor createMentor(ResultSet results) throws SQLException;
    abstract T createMembership(ResultSet results) throws SQLException;
    abstract T getRelevantMembership(List<T> memberships, Integer id);
    abstract void addMentorToMembership(T membership, Mentor mentor);
    abstract void addCodecoolerToMembership(T membership, Codecooler codecooler);
}
