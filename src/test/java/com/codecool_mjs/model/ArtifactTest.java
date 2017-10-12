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
        assertNull(emptyArtifact.getDescription());
    }

    @Test
    void testArtifactParametrizedConstructor() {
        assertNotNull(parametrizedArtifact.getIsGroup());
    }

    @Test
    void testArtifactParametrizedConstructor2() {
        assertNotNull(parametrizedArtifact2.getIsUsed());
    }

    @Test
    void testArtifactSetGetID() {
        emptyArtifact.setId(1);
        assertEquals(1, (int)emptyArtifact.getId());
    }

    @Test
    void testArtifactSetGetName() {
        emptyArtifact.setName("test");
        assertEquals("test", emptyArtifact.getName());
    }

    @Test
    void testArtifactSetGetDescription() {
        emptyArtifact.setDescription("test");
        assertEquals("test", emptyArtifact.getDescription());
    }

    @Test
    void testArtifactSetGetCost() {
        emptyArtifact.setCost(1);
        assertEquals(1, (int)emptyArtifact.getCost());
    }

    @Test
    void testArtifactSetGetIsUsed() {
        emptyArtifact.setIsUsed(true);
        assertNotNull(emptyArtifact.getIsUsed());
    }

    @Test
    void testArtifactSetGetIsGroup() {
        emptyArtifact.setIsGroup(true);
        assertNotNull(emptyArtifact.getIsGroup());
    }

    @Test
    void testArtifactCostSetToNegative() {
        assertThrows(IllegalArgumentException.class, () -> {
            emptyArtifact.setCost(-1);
        });
    }

    @Test
    void testArtifactIDSetToNegative() {
        assertThrows(IllegalArgumentException.class, () -> {
            emptyArtifact.setId(-1);
        });
    }
}