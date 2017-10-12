package com.codecool_mjs.model;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class LoginTest {

    private Login login;

    @BeforeEach
    void setup() {

        this.login = new Login(1, "test");
    }

    @Test
    void testConstructorForNegativeID() {
        assertThrows(IllegalArgumentException.class, () -> {
           Login login = new Login(-1, "test");
        });
    }

    @Test
    void testGetID() {
        assertEquals(1, (int) login.getId());
    }

    @Test
    void testGetProffession() {
        assertEquals("test", login.getProfession());
    }
}