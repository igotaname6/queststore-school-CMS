package com.codecool_mjs.model;

public class Quest {

    private Integer id;
    private String name;
    private String description;
    private Integer coinReward;
    private Boolean isGroup;

    public Quest() {

        this.id = null;
        this.name = null;
        this.description = null;
        this.coinReward = null;
        this.isGroup = null;
    }

    public Boolean getIsGroup() {
        return isGroup;
    }

    public void setGroup(Boolean Isgroup) {
        isGroup = Isgroup;
    }

    public Quest(Integer id, String name, String description, Integer coinReward, Boolean isGroup) {

        this.id = id;
        this.name = name;
        this.description = description;
        this.coinReward = coinReward;
        this.isGroup = isGroup;
    }

    public Quest(Integer id) {
        this.id = id;
    }

    public Quest(String name, String description, Integer coinReward, Boolean isGroup) {
        this.name = name;
        this.description = description;
        this.coinReward = coinReward;
        this.isGroup = isGroup;
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
