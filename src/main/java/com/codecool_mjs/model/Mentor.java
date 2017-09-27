package com.codecool_mjs.model;

import java.util.ArrayList;

public class Mentor extends User {

    private ArrayList<Group> teachedGroups;

    public Mentor(int id, String name, String surname, String email, String password) {
        super(id, name, surname, email, password);
        this.teachedGroups = new ArrayList<>();
    }

    public void addClass(Group teachedGroup) {
        this.teachedGroups.add(teachedGroup);
    }

    public void removeClass(Group teachedGroup) {
        this.teachedGroups.remove(teachedGroup);
    }

    public ArrayList<Group> getTeachedClasses() {
        return this.teachedGroups;
    }
}