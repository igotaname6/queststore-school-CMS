package com.codecool_mjs.model;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class ArtifactTest {

    @Test
    public void testArtifactEmptyConstructor() {
        Artifact artifact = new Artifact();
        assertNull(artifact.getDescription());
    }

    @Test
    public void testArtifactParametrizedConstructor() {
        Artifact artifact = new Artifact(1, "test", "test", 1, true);
        assertNotNull(artifact.getIsGroup());
    }

    @Test
    public void testArtifactParametrizedConstructor2() {
        Artifact artifact = new Artifact(1, "test", "test", 1, false, true);
        assertNotNull(artifact.getIsUsed());
    }

    @Test
    public void testArtifactSetGetID() {
        Artifact artifact = new Artifact();
        artifact.setId(1);
        assertEquals(1, (int)artifact.getId());
    }

    @Test
    public void testArtifactSetGetName() {
        Artifact artifact = new Artifact();
        artifact.setName("test");
        assertEquals("test", artifact.getName());
    }

    @Test
    public void testArtifactSetGetDescription() {
        Artifact artifact = new Artifact();
        artifact.setDescription("test");
        assertEquals("test", artifact.getDescription());
    }

    @Test
    public void testArtifactSetGetCost() {
        Artifact artifact = new Artifact();
        artifact.setCost(1);
        assertEquals(1, (int)artifact.getCost());
    }

    @Test
    public void testArtifactSetGetIsUsed() {
        Artifact artifact = new Artifact();
        artifact.setIsUsed(true);
        assertNotNull(artifact.getIsUsed());
    }

    @Test
    public void testArtifactSetGetIsGroup() {
        Artifact artifact = new Artifact();
        artifact.setIsGroup(true);
        assertNotNull(artifact.getIsGroup());
    }

}