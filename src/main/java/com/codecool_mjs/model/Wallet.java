package com.codecool_mjs.model;

public class Wallet {

    private Integer totalEarnedCoins;
    private Integer availableCoins;

    public Wallet(Integer totalEarnedCoins, Integer availableCoins) {
        this.totalEarnedCoins = totalEarnedCoins;
        this.availableCoins = availableCoins;
    }

    public void addCoins(Integer amount) {

        this.totalEarnedCoins = this.totalEarnedCoins + amount;
        this.availableCoins = this.availableCoins + amount;
    }

    public void removeCoins(Integer amount) {

        this.availableCoins = this.availableCoins - amount;
    }

    public Integer getTotalEarnedCoins() {

        return this.totalEarnedCoins;
    }

    public Integer getAvailableCoins() {

        return this.availableCoins;

    }

    public void setTotalEarnedCoins(Integer amount) {
        
        this.totalEarnedCoins = amount;
    }

    public void setAvailableCoins(Integer amount) {

        this.availableCoins = amount;
    }
}