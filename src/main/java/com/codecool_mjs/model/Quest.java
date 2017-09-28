package com.codecool_mjs.model;

public class Quest {

    private String name;
    private String description;
    private Integer coinReward;

    public Quest(String name) {

        this.name = null;
        this.description = null;
        this.coinReward = null;
    }

    public Quest(String name, String description, Integer coinReward) {
        
        this.name = name;
        this.description = description;
        this.coinReward = coinReward;
    }

    public String getName() {
        return this.name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return this.description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Integer getCoinReward() {
        return this.coinReward;
    }

    public void setCoinReward(Integer amount) {
        this.coinReward = amount;
    } 
}