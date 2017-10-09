package com.codecool_mjs.model;

public class Quest {

    private Integer id;
    private String name;
    private String description;
    private Integer coinReward;

    public Quest() {

        this.id = null;
        this.name = null;
        this.description = null;
        this.coinReward = null;
    }

    public Quest(Integer id, String name, String description, Integer coinReward) {

        this.id = id;
        this.name = name;
        this.description = description;
        this.coinReward = coinReward;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Integer getCoinReward() {
        return coinReward;
    }

    public void setCoinReward(Integer coinReward) {
        this.coinReward = coinReward;
    }
}
