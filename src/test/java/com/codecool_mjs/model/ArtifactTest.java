package com.codecool_mjs.model;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class ArtifactTest {

    Artifact emptyArtifact;
    Artifact parametrizedArtifact;
    Artifact parametrizedArtifact2;

    @BeforeEach
    public void setup() {

        this.emptyArtifact = new Artifact();
        this.parametrizedArtifact = new Artifact(1, "test",
                                                 "test", 1,
                                                 false);
        this.parametrizedArtifact2 = new Artifact(1, "test",
                                                  "test", 1,
                                                  false, true);
    }

    @Test
    public void testArtifactEmptyConstructor() {
        assertNull(emptyArtifact.getDescription());
    }

    @Test
    public void testArtifactParametrizedConstructor() {
        assertNotNull(parametrizedArtifact.getIsGroup());
    }

    @Test
    public void testArtifactParametrizedConstructor2() {
        assertNotNull(parametrizedArtifact2.getIsUsed());
    }

    @Test
    public void testArtifactSetGetID() {
        emptyArtifact.setId(1);
        assertEquals(1, (int)emptyArtifact.getId());
    }

    @Test
    public void testArtifactSetGetName() {
        emptyArtifact.setName("test");
        assertEquals("test", emptyArtifact.getName());
    }

    @Test
    public void testArtifactSetGetDescription() {
        emptyArtifact.setDescription("test");
        assertEquals("test", emptyArtifact.getDescription());
    }

    @Test
    public void testArtifactSetGetCost() {
        emptyArtifact.setCost(1);
        assertEquals(1, (int)emptyArtifact.getCost());
    }

    @Test
    public void testArtifactSetGetIsUsed() {
        emptyArtifact.setIsUsed(true);
        assertNotNull(emptyArtifact.getIsUsed());
    }

    @Test
    public void testArtifactSetGetIsGroup() {
        emptyArtifact.setIsGroup(true);
        assertNotNull(emptyArtifact.getIsGroup());
    }

    @Test
    public void testArtifactCostSetToNegative() {
        assertThrows(IllegalArgumentException.class, () -> {
            emptyArtifact.setCost(-1);
        });
    }

    @Test
    public void testArtifactIDSetToNegative() {
        assertThrows(IllegalArgumentException.class, () -> {
            emptyArtifact.setId(-1);
        });
    }
}