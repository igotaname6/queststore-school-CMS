package com.codecool_mjs.model;

import java.util.ArrayList;

public class Class {

    private String name;
    private ArrayList<Codecooler> members;
    private ArrayList<Mentor> mentors;

    public Class(String name) {
        this.name = name;
        this.members = new ArrayList<>();
        this.mentors = new ArrayList<>();
    }

    public String getName() {
        return this.name;

    }
    public ArrayList<Codecooler> getMembers() {
        return this.members;
    }

    public ArrayList<Mentor> getMentors() {
        return this.mentors;
    }

    public void addMentor(Mentor mentor) {
        this.mentors.add(mentor);
    }

    public void addMember(Codecooler member) {
        this.members.add(member);
    }

    public void removeMentor(Mentor mentor) {
        this.mentors.remove(mentor);
    }

    public void removeMember(Codecooler member) {
        this.members.remove(member);
    }
}
