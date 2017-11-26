package com.codecool_mjs.model;

import java.util.List;

public class UserMembership {

    private User user;
    private Group group;

    public UserMembership(User user, Group group) {
        this.user = user;
        this.group = group;
    }

    public User getUser() {
        return user;
    }

    public Group getGroup() {
        return group;
    }
}
