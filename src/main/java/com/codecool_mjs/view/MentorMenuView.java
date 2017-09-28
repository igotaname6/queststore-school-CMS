package com.codecool_mjs.view;

import java.util.*;

import static java.lang.System.out;

public class MentorMenuView {

    private static Scanner userInput = new Scanner(System.in).useDelimiter("\\n");

    public static void printMentorMenu() {

        final List<String> MENU = new ArrayList<String>(Arrays.asList("show all students", "log out\n"));

        ListIterator<String> iterator = MENU.listIterator();

        out.println("\nMENTOR MENU: ");
        while (iterator.hasNext()) {
            out.println((iterator.nextIndex() + 1) + ". " + iterator.next());
        }
    }

    public static String getMentorMenuInput() {

        userInput = new Scanner(System.in).useDelimiter("\\n");
        List<String> menuOptions = new ArrayList<String>();

        for(Integer i = 1; i <= 2; i++){
            menuOptions.add(i.toString());
        }

        System.out.println("\n" + "What do you want to do? Pick an option [by option's number]!");

        String pickedOption = null;
        do {
            pickedOption = userInput.next();
        } while (!menuOptions.contains(pickedOption));

        return pickedOption;
    }
}
