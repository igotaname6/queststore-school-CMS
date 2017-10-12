package com.codecool_mjs.model;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class GroupTest {
    @Test
    void testGetId() {
        Group testGroup = new Group();
        testGroup.setId(12);
        assertEquals(12, (int) testGroup.getId());
    }

    @Test
    void testSetId() {
        Group testGroup = new Group();
        testGroup.setId(12);
        assertEquals(12, (int) testGroup.getId());
    }

    @Test
    void testGetName() {
        Group testGroup = new Group();
        testGroup.setName("Janusz");
        assertEquals("Janusz", testGroup.getName());
    }

    @Test
    void testSetName() {
        Group testGroup = new Group();
        testGroup.setName("Janusz");
        assertEquals("Janusz", testGroup.getName());
    }

    @Test
    void testEmptyConstructorSetIdNull() {
        Group testGroup = new Group();
        assertNull(testGroup.getId());
    }

    @Test
    void testEmptyConstructorSetNameNull() {
        Group testGroup = new Group();
        assertNull(testGroup.getName());
    }

    @Test
    void testParametrizedConstructorSetId() {
        Group testGroup = new Group(12, "Janusz");
        assertEquals(12, (int) testGroup.getId());
    }

    @Test
    void testParametrizedConstructorSetName() {
        Group testGroup = new Group(12, "Janusz");
        assertEquals("Janusz", testGroup.getName());
    }

}