package com.codecool_mjs.model;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class UserTest {

    User user;

    @BeforeEach
    void setup() {

        this.user = new Codecooler();
    }

    @Test
    void testSetterAndGetterName() {

        String testName = "Stefan";

        user.setName(testName);
        String name = user.getName();

        assertEquals(testName, name,
                "Method sets field to an incorrect value.");
    }

    @Test
    void testSetterAndGetterSurname() {

        String testSurname = "Batory";

        user.setSurname(testSurname);
        String surname = user.getSurname();

        assertEquals(testSurname, surname,
                "Method sets field to an incorrect value.");
    }

    @Test
    void testSetterAndGetterEmail() {

        String testEmail = "test@test.test";

        user.setEmail(testEmail);
        String email = user.getEmail();

        assertEquals(testEmail, email,
                "Method sets field to an incorrect value.");
    }

    @Test
    void testSetterAndGetterID() {

        Integer testId = 111;

        user.setId(testId);
        Integer id = user.getId();

        assertEquals(testId, id,
                "Method sets field to an incorrect value.");
    }

    @Test
    void testSetterAndGetterPassword() {

        String testPassword = "abc123";

        user.setPassword(testPassword);
        String password = user.getPassword();

        assertEquals(testPassword, password,
                "Method sets field to an incorrect value.");
    }

}