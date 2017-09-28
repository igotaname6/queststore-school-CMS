package com.codecool_mjs.view;

import java.util.*;

import static java.lang.System.out;

public class AdminMenuView {

    private static Scanner userInput = new Scanner(System.in).useDelimiter("\\n");

    public static void printAdminMenu() {

        final List<String> MENU = new ArrayList<String>(Arrays.asList("show all mentors", "exit\n"));

        ListIterator<String> iterator = MENU.listIterator();

        out.println("\nADMIN MENU: ");
        while (iterator.hasNext()) {
            out.println((iterator.nextIndex() + 1) + ". " + iterator.next());
        }
    }

}
