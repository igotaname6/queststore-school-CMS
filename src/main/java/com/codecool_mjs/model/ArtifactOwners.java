package com.codecool_mjs.model;

public class ArtifactOwners {

    private Codecooler codecooler;
    private Artifact artifact;

    public ArtifactOwners(Codecooler codecooler, Artifact artifact) {
        this.codecooler = codecooler;
        this.artifact = artifact;
    }

    public Codecooler getCodecooler() {
        return codecooler;
    }

    public Artifact getArtifact() {
        return artifact;
    }
}
