package com.codecool_mjs.view.oldConsoleView;

import java.util.*;

import static java.lang.System.out;

public class AdminMenuView {

    private static Scanner userInput = new Scanner(System.in).useDelimiter("\\n");

    public static void printAdminMenu() {

        final List<String> MENU = new ArrayList<String>(Arrays.asList("show all mentors", "search mentor",
                "update mentor", "add new mentor", "add new group", "add level",
                "show account info", " edit account info", "log out\n"));

        ListIterator<String> iterator = MENU.listIterator();

        out.println("\nADMIN MENU: ");
        while (iterator.hasNext()) {
            out.println((iterator.nextIndex() + 1) + ". " + iterator.next());
        }
    }

    public static String getAdminMenuInput() {

        userInput = new Scanner(System.in).useDelimiter("\\n");
        List<String> menuOptions = new ArrayList<String>();

        for(Integer i = 1; i <= 9; i++){
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
