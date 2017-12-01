package com.codecool_mjs.dataaccess.dao;

import com.codecool_mjs.model.Codecooler;
import com.codecool_mjs.model.Wallet;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class CodecoolerDao extends UserDao<Codecooler>{

    public CodecoolerDao() {
        super();
    }

//    public Codecooler getCodecoolerWithWalltet(int id) throws DaoException{
//
//
//        String query = "SELECT users.id as codecooler_id, name, surname, email, password, profession, " +
//                       "wallets.id as wallet_id, wallets.total_earned_coins, wallets.available_coins " +
//                       "FROM users " +
//                       "LEFT JOIN wallets ON codecooler_id = wallets.user_id " +
//                       "WHERE profession = 'codecooler' AND codecooler_id = ?;";
//
//        try(PreparedStatement preStatement = getConnection().prepareStatement(query)){
//            preStatement.setInt(1, id);
//            ResultSet results = preStatement.executeQuery();
//            Codecooler codecooler = createCodecoolerWithWallet(results);
//            return codecooler;
//        } catch (SQLException e) {
//            throw new DaoException("Exception in getCodecoolerWithWalltet", e);
//        }
//
//    }

    @Override
    String getQueryForGetById(){
        String query = "SELECT users.id as codecooler_id, name, surname, email, password, profession, " +
                "wallets.id as wallet_id, wallets.user_id, wallets.total_earned_coins, wallets.available_coins " +
                "FROM users " +
                "LEFT JOIN wallets ON codecooler_id = wallets.user_id " +
                "WHERE profession = 'codecooler' AND codecooler_id = ?;";
        return query;
    }

    @Override
    String getQueryForGetAll() {
        String query = "SELECT users.id as codecooler_id, name, surname, email, password, profession, " +
                "wallets.id as wallet_id, wallets.user_id, wallets.total_earned_coins, wallets.available_coins " +
                "FROM users " +
                "LEFT JOIN wallets ON codecooler_id = wallets.user_id " +
                "WHERE profession = 'codecooler'" +
                "ORDER BY users.surname ASC;";
        return query;
    }

    public Codecooler getLast() throws DaoException{

        String query = getQueryForGetLast();
        try {
            PreparedStatement statement = getConnection().prepareStatement(query);
            return prepareLast(statement).get(0);
        } catch (SQLException e) {
            throw new DaoException("GetLast exception", e);
        }
    }

    protected List<Codecooler> prepareLast(PreparedStatement preparedStatement) throws DaoException{
        ArrayList<Codecooler> resultsList;

        ResultSet results;

        try {
            results = preparedStatement.executeQuery();

            resultsList = new ArrayList<>();

            while (results.next()) {
                Codecooler object = createObjectWithoutWallet(results);
                resultsList.add(object);
            }
            preparedStatement.close();
        } catch (SQLException e) {
            String message = "Exception in get method";
            throw new DaoException(message, e);
        }

        return resultsList;
    }


    @Override
    String getProfession() {
        return "codecooler";
    }

    private Codecooler createObjectWithoutWallet(ResultSet results) throws SQLException{
        Integer id = results.getInt("id");
        String name = results.getString("name");
        String surname = results.getString("surname");
        String email = results.getString("email");
        String password = results.getString("password");

        Codecooler codecooler = new Codecooler(id, name, surname, email, password);
        return codecooler;
    }

    @Override
    Codecooler createObject(ResultSet results) throws SQLException {
        //user data
        Integer id = results.getInt("codecooler_id");
        String name = results.getString("name");
        String surname = results.getString("surname");
        String email = results.getString("email");
        String password = results.getString("password");

        //wallet data
        int wallet_id = results.getInt("wallet_id");
        int user_id = results.getInt("user_id");
        int totalEarnedCoins = results.getInt("total_earned_coins");
        int availableCoins = results.getInt("available_coins");

        Wallet wallet = new Wallet(wallet_id, user_id, totalEarnedCoins, availableCoins);
        Codecooler codecooler = new Codecooler(id, name, surname, email, password, wallet);
        return codecooler;

    }
////    Codecooler createCodecoolerWithWallet(ResultSet r codecooler;
//}
//esults) throws SQLException{
////        //user data
////        Integer id = results.getInt("codecooler_id");
////        String name = results.getString("name");
////        String surname = results.getString("surname");
////        String email = results.getString("email");
////        String password = results.getString("password");
////
////        //wallet data
////        Integer wallet_id = results.getInt("wallet_id");
////        int totalEarnedCoins = results.getInt("total_earned_coins");
////        int availableCoins = results.getInt("available_coins");
////
////        Wallet wallet = new Wallet(wallet_id, totalEarnedCoins, availableCoins);
////        Codecooler codecooler = new Codecooler(id, name, surname, email, password, wallet);
////        return codecooler;
////    }
}
