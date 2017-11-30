package com.codecool_mjs.dataaccess.dao;

import com.codecool_mjs.model.Wallet;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class WalletDao extends Dao<Wallet>{

    @Override
    Wallet createObject(ResultSet results) throws SQLException {
        int wallet_id = results.getInt("wallet_id");
        int user_id = results.getInt("user_id");
        int totalEarnedCoins = results.getInt("total_earned_coins");
        int availableCoins = results.getInt("available_coins");

        Wallet wallet = new Wallet(wallet_id, user_id, totalEarnedCoins, availableCoins);
        return wallet;
    }

    @Override
    String getQueryForGetAll() {
        return null;
    }

    @Override
    String getQueryForGetById() {
        return "SELECT * form wallets WHERE id = ?";
    }

    @Override
    String getUpdateQuery() {
        return "UPDATE wallets" +
                " SET total_earned_coins = ?," +
                " available_coins = ?," +
                " WHERE id = ?;";
    }

    @Override
    void setUpdateStatement(PreparedStatement preparedStatement, Wallet wallet) throws SQLException {
        preparedStatement.setInt(1, wallet.getTotalEarnedCoins());
        preparedStatement.setInt(2, wallet.getAvailableCoins());
        preparedStatement.setInt(3,wallet.getId());
    }

    @Override
    String getDeleteQuery() {
        return "DELETE FROM WALLETS WHERE id = ?";
    }

    @Override
    void setDeleteStatement(PreparedStatement preparedStatement, Wallet wallet) throws SQLException {
        preparedStatement.setInt(1, wallet.getId());
    }

    @Override
    String getQueryForGetLast() {return null;}

    @Override
    String getInsertQuery() {
        return "INSERT INTO wallets (user_id, total_earned_coins, available_coins)" +
                " VALUES(?, ?, ?);";
    }

    @Override
    void setInsertStatement(PreparedStatement preparedStatement, Wallet wallet) throws SQLException {
        preparedStatement.setInt(1, wallet.getUserId());
        preparedStatement.setInt(1, wallet.getTotalEarnedCoins());
        preparedStatement.setInt(1, wallet.getAvailableCoins());
    }
}
