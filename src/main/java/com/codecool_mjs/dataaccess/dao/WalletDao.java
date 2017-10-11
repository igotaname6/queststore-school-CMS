package com.codecool_mjs.dataaccess.dao;

import com.codecool_mjs.model.Quest;
import com.codecool_mjs.model.Wallet;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class WalletDao extends Dao<Wallet>{

    @Override
    Wallet createObject(ResultSet results) throws SQLException {

        Integer codecoolerId = results.getInt("codecooler_id");
        Integer totalEarnedCoins = results.getInt("total_earned_coins");
        Integer availableCoins = results.getInt("available_coins");

        Wallet wallet = new Wallet(codecoolerId ,totalEarnedCoins, availableCoins);

        return wallet;
    }

    @Override
    String getQueryForGetAll() {

        String query = "SELECT * FROM wallets";

        return query;
    }

    @Override
    String getQueryForSearchBy(String category, String arg) {

        String query = String.format("SELECT * FROM wallets WHERE %s LIKE '%s' AND type = 'single", category, arg);

        return query;
    }

    @Override
    String getInsertationStatement() {
        return null;
    }

    @Override
    Integer executeInsertation(Wallet wallet) throws SQLException {
        return null;
    }

    @Override
    Integer executeUpdateStatements(Wallet wallet) throws SQLException {
        return null;
    }

    @Override
    Integer executeDeletion(Wallet wallet) throws SQLException {
        Connection conn = getConnection();

        PreparedStatement statement = conn.prepareStatement(getDeletionStatement());
        statement.setInt(1, wallet.getId());

        Integer rowAffected = statement.executeUpdate();
        return rowAffected;
    }

    private String getDeletionStatement() {
        return "DELETE FROM wallets WHERE id = ?;";
    }
}
