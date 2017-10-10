package com.codecool_mjs.view;

import com.codecool_mjs.model.Mentor;
import com.codecool_mjs.model.User;

import java.util.List;

public class MentorView {

    public static void printAllMentors(List<Mentor> mentors) {

        for (Mentor mentor : mentors) {
            String data = String.format("%d. %s || %s", mentor.getId(), mentor.getName() + mentor.getSurname(), mentor.getEmail());
            System.out.println(data);
        }
    }
}

