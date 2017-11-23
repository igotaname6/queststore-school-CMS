package com.codecool_mjs.model;

import java.util.List;

public class UserMembership {

    private List<Mentor> mentors;
    private List<Codecooler> codecoolers;

    public List<Mentor> getMentors() {
        return mentors;
    }

    public List<Codecooler> getCodecoolers() {
        return codecoolers;
    }

    public UserMembership(List<Mentor> mentors, List<Codecooler> codecoolers) {
        this.mentors = mentors;
        this.codecoolers = codecoolers;
    }
}
