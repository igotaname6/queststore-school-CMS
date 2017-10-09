package com.codecool_mjs.model;

public class Wallet {

    private Integer id;
    private Integer totalEarnedCoins;
    private Integer availableCoins;

    public Wallet() {

        this.id = null;
        this.totalEarnedCoins = 0;
        this.availableCoins = 0;
    }

    public Wallet(Integer id, Integer totalEarnedCoins, Integer availableCoins) {

        this.id = id;
        this.totalEarnedCoins = totalEarnedCoins;
        this.availableCoins = availableCoins;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
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