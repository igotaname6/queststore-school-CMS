package model;

public class Artifact {

    private String name;
    private String description;
    private Integer cost;
    private Boolean isUsed;

    public Artifact() {

        this.name = null;
        this.description = null;
        this.cost = null;
        this.isUsed = false;
    }

    public Artifact(String name, String description, Integer cost) {

        this.name = name;
        this.description = description;
        this.cost = cost;
        this.isUsed = false;
    }
}