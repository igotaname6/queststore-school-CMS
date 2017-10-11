package com.codecool_mjs.model;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class TeamTest {

    Team team;

    @BeforeEach
    void setup() {

        this.team = new Team(1, "testTeam");
    }

    @Test
    void testEmptyTeamConstructor() {

        Team emptyTeam = new Team();

        assertNull(emptyTeam.getName());
    }

    @Test
    void testSettingAndGettingId() {

        Integer testId = 1;

        team.setId(1);

        assertEquals(testId, team.getId());
    }

    @Test
    void testSettingAndGettingName() {

        String testName = "testName";

        team.setName(testName);

        assertEquals(testName, team.getName());
    }

}