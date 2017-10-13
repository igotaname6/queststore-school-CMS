package com.codecool_mjs.model;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class ArtifactTest {

    private Artifact emptyArtifact;
    private Artifact parametrizedArtifact;
    private Artifact parametrizedArtifact2;

    @BeforeEach
    void setup() {

        this.emptyArtifact = new Artifact();
        this.parametrizedArtifact = new Artifact(1, "a", "b", 1, false);
        this.parametrizedArtifact2 = new Artifact(1, "a", "b", 1, false, true);
    }

    @Test
    void testArtifactEmptyConstructor() {
        assertNull(emptyArtifact.getDescription(),
                "Empty constructor does not set all fields to null.");
    }

    @Test
    void testArtifactParametrizedConstructor() {
        assertNotNull(parametrizedArtifact.getIsGroup(),
                "Parametrized constructor sets values to null.");
    }

    @Test
    void testArtifactParametrizedConstructor2() {
        assertNotNull(parametrizedArtifact2.getIsUsed(),
                "Parametrized constructor sets values to null.");
    }

    @Test
    void testArtifactSetGetID() {
        emptyArtifact.setId(1);
        assertEquals(1, (int)emptyArtifact.getId(),
                "Method sets field to an incorrect value.");
    }

    @Test
    void testArtifactSetGetName() {
        emptyArtifact.setName("test");
        assertEquals("test", emptyArtifact.getName(),
                "Method sets field to an incorrect value.");
    }

    @Test
    void testArtifactSetGetDescription() {
        emptyArtifact.setDescription("test");
        assertEquals("test", emptyArtifact.getDescription(),
                "Method sets field to an incorrect value.");
    }

    @Test
    void testArtifactSetGetCost() {
        emptyArtifact.setCost(1);
        assertEquals(1, (int)emptyArtifact.getCost(),
                "Method sets field to an incorrect value.");
    }

    @Test
    void testArtifactSetGetIsUsed() {
        emptyArtifact.setIsUsed(true);
        assertNotNull(emptyArtifact.getIsUsed(),
                "Method sets field to an incorrect value.");
    }

    @Test
    void testArtifactSetGetIsGroup() {
        emptyArtifact.setIsGroup(true);
        assertNotNull(emptyArtifact.getIsGroup(),
                "Method sets field to an incorrect value.");
    }

    @Test
    void testArtifactCostSetToNegative() {
        assertThrows(IllegalArgumentException.class, () -> {
            emptyArtifact.setCost(-1);
        }, "Cost field can be set to a negative value");
    }

    @Test
    void testArtifactIDSetToNegative() {
        assertThrows(IllegalArgumentException.class, () -> {
            emptyArtifact.setId(-1);
        }, "Id field can be set to a negative value");
    }
}