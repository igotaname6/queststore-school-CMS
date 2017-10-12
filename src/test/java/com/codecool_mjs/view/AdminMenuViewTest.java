package com.codecool_mjs.view;

import org.junit.After;
import org.junit.Before;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import java.io.*;
import java.util.Scanner;

import static org.junit.jupiter.api.Assertions.*;

class AdminMenuViewTest {

    private AdminMenuView view = new AdminMenuView();
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

        String menu = "\nADMIN MENU:\n1. show all mentors\n" +
                      "2. search mentor\n3. update mentor\n" +
                      "4. add new mentor\n5. add new group\n" +
                      "6. add level\n7. show account info\n" +
                      "8. edit account info\n9. log out\n\n";

        AdminMenuView.printAdminMenu();
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

        assertEquals(AdminMenuView.getAdminMenuInput(), "1");

        cleanInput();
    }

    @Test
    void testReturningIncorrectMenuChoice() {

        setupInput("incorrectInput1\nincorrectInput2\n3\n4");

        assertEquals(AdminMenuView.getAdminMenuInput(), "3");

        cleanInput();
    }

    @After
    private void cleanInput() {

        System.setIn(stdin);
    }

}