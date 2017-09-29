package com.codecool_mjs.dataaccess.dao;

import com.codecool_mjs.model.Wallet;

import java.sql.ResultSet;
import java.sql.SQLException;

public class WalletDao extends Dao<Wallet>{

    @Override
    Wallet createObject(ResultSet results) throws SQLException {

        Integer totalEarnedCoins = results.getInt("total_earned_coins");
        Integer availableCoins = results.getInt("available_coins");

        Wallet wallet = new Wallet(totalEarnedCoins, availableCoins);

        return wallet;
    }

    @Override
    String getQueryGetAll() {

        String query = "SELECT * FROM wallets";

        return query;
    }

    @Override
    String getQuerySearchBy(String category, String arg) {

        String query = "SELECT * FROM wallets WHERE " + category + " LIKE '" + arg + "' AND type = 'single";

        return query;
    }
}
