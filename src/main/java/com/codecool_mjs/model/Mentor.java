package com.codecool_mjs.model;

public class Mentor extends User {

    private Integer groupId;

    public Mentor(Integer id, String name, String surname, String email, String password, Integer groupId) {

        super(id, name, surname, email, password);
        this.groupId = groupId;
    }

    public Mentor(Integer id, String name, String surname, String email, String password) {

        super(id, name, surname, email, password);
        this.groupId = null;
    }

    public Mentor(String name, String surname, String email, String password) {
        super(name, surname, email, password);
    }

    public Mentor(Integer id) {super(id);}

    public Integer getGroupId() {
        return groupId;
    }

    public void setGroupId(Integer groupId) {
        this.groupId = groupId;
    }
}