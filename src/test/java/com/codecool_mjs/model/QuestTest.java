package com.codecool_mjs.model;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class QuestTest {

    Quest emptyQuest;
    Quest parametrizedQuest;

    @BeforeEach
    void setup() {

        this.emptyQuest = new Quest();
        this.parametrizedQuest = new Quest(1, "a", "b", 1, false);
    }

    @Test
    void testEmptyConstructor() {
        assertNull(emptyQuest.getId());
    }

    @Test
    void testParametrizedConstructor() {
        assertNotNull(parametrizedQuest.getId());
    }

    @Test
    void testSetGetIsGroup() {
        emptyQuest.setGroup(true);
        assertTrue(emptyQuest.getIsGroup());
    }

    @Test
    void testSetGetId() {
        emptyQuest.setId(1);
        assertEquals(1, (int) emptyQuest.getId());
    }

    @Test
    void testSetIdToNegative() {
        assertThrows(IllegalArgumentException.class, () -> {
           emptyQuest.setId(-1);
        });
    }

    @Test
    void testSetGetName() {
        emptyQuest.setName("a");
        assertEquals("a", emptyQuest.getName());
    }

    @Test
    void testSetGetDescription() {
        emptyQuest.setDescription("a");
        assertEquals("a", emptyQuest.getDescription());
    }

    @Test
    void testSetGetCoinReward() {
        emptyQuest.setCoinReward(1);
        assertEquals(1, (int) emptyQuest.getCoinReward());
    }

    @Test
    void testSetCoinRewardToNegative() {
        assertThrows(IllegalArgumentException.class, () -> {
           emptyQuest.setCoinReward(-1);
        });
    }
}