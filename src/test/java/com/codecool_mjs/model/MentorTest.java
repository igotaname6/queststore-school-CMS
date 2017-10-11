package com.codecool_mjs.model;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class MentorTest {

    Mentor emptyMentor;
    Mentor parametrizedMentor;
    Mentor parametrizedMentor2;

    @BeforeEach
    public void setup() {
        this.emptyMentor = new Mentor();
        this.parametrizedMentor = new Mentor(1, "a", "b", "c", "d", 1);
        this.parametrizedMentor2 = new Mentor(1, "a", "b", "c", "d", 1);
    }

    @Test
    public void testMentorConstructorNegativeID() {
        assertThrows(IllegalArgumentException.class, () -> {
           Mentor mentor = new Mentor(-1, "a", "b", "c", "d", 1);
        });
    }

    @Test
    public void testMentorConstructorNegativeGroupId() {
        assertThrows(IllegalArgumentException.class, () -> {
           Mentor mentor = new Mentor(1, "a", "b", "c", "d", -1);
        });
    }

    @Test
    public void testMentorSetGetGroupID() {
        emptyMentor.setGroupId(1);
        assertEquals(1, (int) emptyMentor.getGroupId());
    }

    @Test
    public void testMentorSetGetGroupIDToNegative() {
        assertThrows(IllegalArgumentException.class, () -> {
           emptyMentor.setGroupId(-1);
        });
    }
}