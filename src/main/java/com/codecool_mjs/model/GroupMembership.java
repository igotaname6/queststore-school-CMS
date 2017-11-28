package com.codecool_mjs.model;

import java.util.List;

public class GroupMembership {

    private List<Mentor> mentors;
    private List<Codecooler> codecoolers;
    private Group group;

    public GroupMembership(Group group, List<Mentor> mentors, List<Codecooler> codecoolers) {
        this.group = group;
        this.mentors = mentors;
        this.codecoolers = codecoolers;
    }

    public List<Mentor> getMentors() {
        return mentors;
    }

    public List<Codecooler> getCodecoolers() {
        return codecoolers;
    }

    public Group getGroup() {
        return group;
    }
}
