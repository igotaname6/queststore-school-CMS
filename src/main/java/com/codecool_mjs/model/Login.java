package com.codecool_mjs.model;

public class Login {

    private Integer id;
    private String profession;

    public Login(Integer id, String profession) {
        this.id = id;
        this.profession = profession;
    }

    public Integer getId() {
        return id;
    }

    public String getProfession() {
        return profession;
    }
}
