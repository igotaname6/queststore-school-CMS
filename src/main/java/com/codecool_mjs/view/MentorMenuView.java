package com.codecool_mjs.view;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.ListIterator;

import static java.lang.System.out;

public class MentorMenuView {

    public static void printMentorMenu() {

        final List<String> MENU = new ArrayList<String>(Arrays.asList("show all students", "log out\n"));

        ListIterator<String> iterator = MENU.listIterator();

        out.println("\nMENTOR MENU: ");
        while (iterator.hasNext()) {
            out.println((iterator.nextIndex() + 1) + ". " + iterator.next());
        }
    }
}
