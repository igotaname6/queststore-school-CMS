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
        assertNull(emptyQuest.getId(),
                "Empty constructor does not set all fields to null.");
    }

    @Test
    void testParametrizedConstructor() {
        assertNotNull(parametrizedQuest.getId(),
                "Parametrized constructor does not set all fields.");
    }

    @Test
    void testSetGetIsGroup() {
        emptyQuest.setGroup(true);
        assertTrue(emptyQuest.getIsGroup(),
                "Method sets field to an incorrect value.");
    }

    @Test
    void testSetGetId() {
        emptyQuest.setId(1);
        assertEquals(1, (int) emptyQuest.getId(),
                "Method sets field to an incorrect value.");
    }

    @Test
    void testSetGetName() {
        emptyQuest.setName("a");
        assertEquals("a", emptyQuest.getName(),
                "Method sets field to an incorrect value.");
    }

    @Test
    void testSetGetDescription() {
        emptyQuest.setDescription("a");
        assertEquals("a", emptyQuest.getDescription(),
                "Method sets field to an incorrect value.");
    }

    @Test
    void testSetGetCoinReward() {
        emptyQuest.setCoinReward(1);
        assertEquals(1, (int) emptyQuest.getCoinReward(),
                "Method sets field to an incorrect value.");
    }

    @Test
    void testSetCoinRewardToNegative() {
        assertThrows(IllegalArgumentException.class, () -> {
           emptyQuest.setCoinReward(-1);
        }, "CoinReward can be set to a negative value.");
    }

    @Test
    void testSetIdToNegative() {
        assertThrows(IllegalArgumentException.class, () -> {
            emptyQuest.setId(-1);
        }, "CoinReward can be set to a negative value.");
    }
}