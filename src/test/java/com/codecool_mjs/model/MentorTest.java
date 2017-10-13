package com.codecool_mjs.model;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class MentorTest {

    private Mentor emptyMentor;
    private Mentor parametrizedMentor;
    private Mentor parametrizedMentor2;

    @BeforeEach
    void setup() {

        this.emptyMentor = new Mentor();
        this.parametrizedMentor = new Mentor(1, "a", "b", "c", "d");
        this.parametrizedMentor = new Mentor(1, "a", "b", "c", "d", 1);
    }

    @Test
    void testEmptyConstructor() {
        assertNull(emptyMentor.getGroupId(),
                "Parametrized constructor sets fields to incorrect values.");
    }

    @Test
    void testParametrizedMentorConstructor() {
        assertNotNull(parametrizedMentor.getGroupId(),
                "Parametrized constructor sets fields to incorrect values.");
    }

    @Test
    void testParametrizedMentor2Constructor() {
        assertNotNull(parametrizedMentor2.getGroupId(),
                "Parametrized constructor sets fields to incorrect values.");
    }

    @Test
    void testMentorSetGetGroupID() {
        emptyMentor.setGroupId(1);
        assertEquals(1, (int) emptyMentor.getGroupId(),
                "Method sets field to an incorrect value.");
    }

    @Test
    void testMentorSetGetID() {
        emptyMentor.setId(1);
        assertEquals(1, (int) emptyMentor.getId(),
                "Method sets field to an incorrect value.");
    }

    @Test
    void testMentorSetGetGroupIDToNegative() {
        assertThrows(IllegalArgumentException.class, () -> {
           emptyMentor.setGroupId(-1);
        }, "Group Id can be set to negative value.");
    }

    @Test
    void testMentorSetGetIDToNegative() {
        assertThrows(IllegalArgumentException.class, () -> {
           emptyMentor.setId(-1);
        }, "Id can be set to a negative value.");
    }
}
