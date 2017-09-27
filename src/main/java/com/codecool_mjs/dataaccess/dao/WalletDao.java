package com.codecool_mjs.dataaccess.dao;

import com.codecool_mjs.model.Wallet;

import java.sql.ResultSet;
import java.sql.SQLException;

public class WalletDao {

    private static String QUARY = "SELECT * FROM wallets";

    Wallet createWallet(ResultSet results) throws SQLException {

        Integer totalEarnedCoins = results.getInt("total_earned_coins");
        Integer availableCoins = results.getInt("available_coins");

        Wallet wallet = new Wallet(totalEarnedCoins, availableCoins);

        return wallet;
    }

    String getQUARY() {return QUARY; }

    String getQuerySearchBy(String category, String arg) {

        String query = "SELECT * FROM wallets WHERE " + category + " LIKE '" + arg + "' AND type = 'single";

        return query;
}
