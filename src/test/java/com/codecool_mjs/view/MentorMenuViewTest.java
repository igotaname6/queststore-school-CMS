package com.codecool_mjs.view;

import org.junit.After;
import org.junit.Before;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.io.*;

import static org.junit.jupiter.api.Assertions.*;

class MentorMenuViewTest {

    private MentorMenuView view = new MentorMenuView();
    private PrintStream originalOutput;
    private OutputStream outputStream;
    private InputStream stdin;

    @BeforeEach
    void setupOutput() {

        this.originalOutput = System.out;
        outputStream = new ByteArrayOutputStream();
        PrintStream ps = new PrintStream(outputStream);
        System.setOut(ps);
    }

    @AfterEach
    void cleanOutput() {

        System.setOut(originalOutput);
    }

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

    @Before
    private void setupInput(String data) {

        stdin = System.in;
        System.setIn(new ByteArrayInputStream(data.getBytes()));
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

    @After
    private void cleanInput() {

        System.setIn(stdin);
    }
}