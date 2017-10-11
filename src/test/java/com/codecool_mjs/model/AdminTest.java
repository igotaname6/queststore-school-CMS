package com.codecool_mjs.model;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class AdminTest {

    @Test
    public void testAdminConstructorForCorrectValues() {
        Admin admin = new Admin(1, "Test", "Name", "dont@pay.at", "tention");
        String expectedPassword = "tention";
        Integer expectedID = 1;
        String expectedEmail = "dont@pay.at";
        assertEquals(expectedPassword, admin.getPassword());
        assertEquals(expectedID, admin.getId());
        assertEquals(expectedEmail, admin.getEmail());
    }
}