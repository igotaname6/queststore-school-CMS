package com.codecool_mjs.model;

import java.util.ArrayList;
import java.util.List;

public class Group {

    private Integer id;
    private String name;
    private List<Mentor> mentors;

    public Group(String name) {
        this.name = name;
        this.mentors = new ArrayList<>();

    }

    public Group() {

        this.id = null;
        this.name = null;
    }

    public Group(Integer id, String name) {

        this.id = id;
        this.name = name;
        this.mentors = new ArrayList<>();
    }

    public List<Mentor> getMentors() {
        return mentors;
    }

    public void addToMentors(Mentor mentor) {
        this.mentors.add(mentor);
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
