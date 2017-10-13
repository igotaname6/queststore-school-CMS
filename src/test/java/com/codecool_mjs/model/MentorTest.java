package com.codecool_mjs.model;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class MentorTest {

    private Mentor emptyMentor;
    private Mentor ungroupedMentor;

    @BeforeEach
    void setup() {

        this.emptyMentor = new Mentor();
        this.ungroupedMentor = new Mentor(1, "a", "b", "c", "d");
    }

    @Test
    void testUngroupedMentorConstructor() {
        assertNull(ungroupedMentor.getGroupId());
    }

    @Test
    void testMentorConstructorNegativeID() {
        assertThrows(IllegalArgumentException.class, () -> {
           Mentor mentor = new Mentor(-1, "a", "b", "c", "d", 1);
        });
    }

    @Test
    void testMentorConstructorNegativeGroupId() {
        assertThrows(IllegalArgumentException.class, () -> {
           Mentor mentor = new Mentor(1, "a", "b", "c", "d", -1);
        });
    }

    @Test
    void testMentorSetGetGroupID() {
        emptyMentor.setGroupId(1);
        assertEquals(1, (int) emptyMentor.getGroupId());
    }

    @Test
    void testMentorSetGetGroupIDToNegative() {
        assertThrows(IllegalArgumentException.class, () -> {
           emptyMentor.setGroupId(-1);
        });
    }
}
