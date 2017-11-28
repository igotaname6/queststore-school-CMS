package com.codecool_mjs.model;

import java.util.ArrayList;
import java.util.List;

public class GroupMembership {

    private List<Mentor> mentors;
    private List<Codecooler> codecoolers;
    private Group group;

    public GroupMembership(Group group) {
        this.group = group;
        this.mentors = new ArrayList<>();
        this.codecoolers = new ArrayList<>();
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

    public void addMentors(Mentor mentor) {
        this.mentors.add(mentor);
    }

    public void addCodecoolers(Codecooler codecooler) {
        this.codecoolers.add(codecooler);
    }
}
