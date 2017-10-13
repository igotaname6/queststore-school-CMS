package com.codecool_mjs.model;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class GroupTest {

    private Group group;
    private Group parametrizedGroup;

    @BeforeEach
    void setup() {
        this.group = new Group();
        this.parametrizedGroup = new Group(1, "a");
    }

    @Test
    void testEmptyConstructor() {
        assertNull(group.getId(),
                "Empty constructor does not set all fields to null");
    }

    @Test
    void testParametrizedConstructor() {
        assertEquals(1, (int) parametrizedGroup.getId(),
                "Parametrized constructor sets fields to incorrect values");
    }

    @Test
    void testSetGetId() {
        group.setId(1);
        assertEquals(1, (int) group.getId(),
                "Method sets field to an incorrect value.");
    }

    @Test
    void testSetGetName() {
        group.setName("test");
        assertEquals("test", group.getName(),
                "Method sets field to an incorrect value.");
    }

    @Test
    void testSetIDToNegativeValue() {
        assertThrows(IllegalArgumentException.class, () -> {
            group.setId(-1);
        }, "Id can be set to a negative value");
    }
}
