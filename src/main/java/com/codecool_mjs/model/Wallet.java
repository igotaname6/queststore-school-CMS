package com.codecool_mjs.model;

public class Wallet {

    private Integer id;
    private Integer userId;
    private Integer totalEarnedCoins;
    private Integer availableCoins;

    public Wallet() {

        this.id = null;
        this.totalEarnedCoins = 0;
        this.availableCoins = 0;
    }

    public Wallet(Integer id, Integer totalEarnedCoins, Integer availableCoins) {

        this.id = id;
        setAvailableCoins(availableCoins);
        setTotalEarnedCoins(totalEarnedCoins);
    }

    public Wallet(Integer id, Integer userId, Integer totalEarnedCoins, Integer availableCoins) {
        this.id = id;
        this.userId = userId;
        setAvailableCoins(availableCoins);
        setTotalEarnedCoins(totalEarnedCoins);
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
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
        if(amount<0){
            this.totalEarnedCoins = 0;
        }else {
            this.totalEarnedCoins = amount;
        }
    }

    public void setAvailableCoins(Integer amount) {
        if(amount<0){
            this.totalEarnedCoins = 0;
        }else {
            this.availableCoins = amount;
        }
    }
}