package com.codecool_mjs.view;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class AdminMenuViewTest extends ViewTest {

    private AdminMenuView view = new AdminMenuView();

    @Test
    void testPrintAdminMenu() {

        String menu = "\nADMIN MENU:\n1. show all mentors\n" +
                      "2. search mentor\n3. update mentor\n" +
                      "4. add new mentor\n5. add new group\n" +
                      "6. add level\n7. show account info\n" +
                      "8. edit account info\n9. log out\n\n";

        AdminMenuView.printAdminMenu();
        assertEquals(menu, outputStream.toString(), "Redundant whitespaces in menu");
    }

    @Test
    void testReturningCorrectMenuChoice() {

        setupInput("1");

        assertEquals(AdminMenuView.getAdminMenuInput(), "1");

        cleanInput();
    }

    @Test
    void testReturningIncorrectMenuChoice() {

        setupInput("incorrectInput1\nincorrectInput2\n3\n4");

        assertEquals(AdminMenuView.getAdminMenuInput(), "3");

        cleanInput();
    }

}