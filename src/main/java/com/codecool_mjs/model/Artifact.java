package com.codecool_mjs.model;

public class Artifact {

    private Integer id;
    private String name;
    private String description;
    private Integer cost;
    private Boolean isUsed;

    public Artifact() {

        this.id = null;
        this.name = null;
        this.description = null;
        this.cost = null;
        this.isUsed = false;
    }

    public Artifact(Integer id, String name, String description, Integer cost, Boolean isUsed) {

        this.id = id;
        this.name = name;
        this.description = description;
        this.cost = cost;
        this.isUsed = isUsed;
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

    public Integer getCost() {
        return cost;
    }

    public void setCost(Integer cost) {
        this.cost = cost;
    }

    public Boolean getUsed() {
        return isUsed;
    }

    public void setUsed(Boolean used) {
        isUsed = used;
    }
}