package com.codecool_mjs.model;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class AdminTest {

    @Test
    void testAdminConstructor() {
        Admin admin = new Admin(1, "Test", "Name", "dont@pay.at", "tention");
        String expectedPassword = "tention";
        assertEquals(expectedPassword, admin.getPassword());
    }

    @Test
    void testAdminConstructorIDNegative() {
        assertThrows(IllegalArgumentException.class, () -> {
            Admin admin = new Admin(-1, "Test", "Name", "dont@pay.at", "tention");
        });
    }
}