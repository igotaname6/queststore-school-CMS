package com.codecool_mjs.model;

public class Team {

    private Integer id;
    private String name;

    public Team() {

        this.id = null;
        this.name = null;
    }

    public Team(Integer id, String name) {

        this.id = id;
        this.name = name;
    }

    public Team(Integer id) {
        this.id = id;
    }

    public Team(String name) {
        this.name = name;
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
}
