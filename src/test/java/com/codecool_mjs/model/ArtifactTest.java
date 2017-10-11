package com.codecool_mjs.model;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class ArtifactTest {

    @Test
    public void testArtifactEmptyConstructor() {
        Artifact artifact = new Artifact();
        assertSame(new Artifact(), artifact);
    }

    @Test
    public void testArtifactParametrizedConstructor() {

    }

}