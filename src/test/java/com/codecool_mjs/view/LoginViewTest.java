package com.codecool_mjs.view;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class LoginViewTest extends ViewTest {

    private LoginView view = new LoginView();

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

}