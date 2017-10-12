package com.codecool_mjs.view;

import org.junit.After;
import org.junit.Before;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.io.*;

import static org.junit.jupiter.api.Assertions.*;

class LoginViewTest {

    private LoginView view = new LoginView();
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

    @Before
    private void setupInput(String data) {

        stdin = System.in;
        System.setIn(new ByteArrayInputStream(data.getBytes()));
    }

    @Test
    void testReadCorrectEmail() {

        String testEmail = "test@test.com";
        setupInput(testEmail);

        assertEquals(testEmail, LoginView.getEmail());

        cleanInput();
    }

    @Test
    void testReadPassword() {

        String testPassword = "testPassword";
        setupInput(testPassword);

        assertEquals(testPassword, LoginView.getPassword());

        cleanInput();
    }

    @Test
    void testPrintMessage() {

        String testMessage = "testMessage";
        String expected = "testMessage\n";

        LoginView.print(testMessage);
        assertEquals(expected, outputStream.toString());
    }

    @After
    private void cleanInput() {

        System.setIn(stdin);
    }

}