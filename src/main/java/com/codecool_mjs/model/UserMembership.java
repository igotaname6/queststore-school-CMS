package com.codecool_mjs.model;

import java.util.List;

public class UserMembership {

    private Mentor mentor;
    private Codecooler codecooler;
    private Group group;

    public UserMembership(Mentor mentor, Codecooler codecooler, Group group) {
        this.mentor = mentor;
        this.codecooler = codecooler;
        this.group = group;
    }
}
