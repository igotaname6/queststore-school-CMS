package com.codecool_mjs.view;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class MentorMenuViewTest extends ViewTest {

    private MentorMenuView view = new MentorMenuView();

    @Test
    void testPrintAdminMenu() {

        String menu = "\nMENTOR MENU:\n1. show all students\n" +
                      "2. search student\n3. add student\n" +
                      "4. add quest\n5. add artifact\n" +
                      "6. edit artifact\n7. mark codecooler's quest as achieved\n" +
                      "8. show account info\n9. edit account info\n" +
                      "10. log out\n\n";

        MentorMenuView.printMentorMenu();
        assertEquals(menu, outputStream.toString(), "Redundant whitespaces in menu");
    }

    @Test
    void testReturningCorrectMenuChoice() {

        setupInput("1");

        assertEquals(MentorMenuView.getMentorMenuInput(), "1");

        cleanInput();
    }

    @Test
    void testReturningIncorrectMenuChoice() {

        setupInput("incorrectInput1\nincorrectInput2\n3\n4");

        assertEquals(MentorMenuView.getMentorMenuInput(), "3");

        cleanInput();
    }

}