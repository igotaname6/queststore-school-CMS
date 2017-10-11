package com.codecool_mjs.model;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class LoginTest {

    Login login;

    @BeforeEach
    public void setup() {

        this.login = new Login(1, "test");
    }

    @Test
    public void testConstructorForNegativeID() {
        assertThrows(IllegalArgumentException.class, () -> {
           Login login = new Login(-1, "test");
        });
    }

    @Test
    public void testGetID() {
        assertEquals(1, (int) login.getId());
    }

    @Test
    public void testGetProffession() {
        assertEquals("test", login.getProfession());
    }
}