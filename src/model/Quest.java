package model;

public class Quest {

    String name;
    String description;
    Integer coinReward;

    public Quest() {

        this.name = null;
        this.description = null;
        this.coinReward = null;
    }

    public Quest(String name, String description, Integer coinReward) {
        
        this.name = name;
        this.description = description;
        this.coinReward = coinReward;
    }
}