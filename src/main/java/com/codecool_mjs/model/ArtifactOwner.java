package com.codecool_mjs.model;

public class ArtifactOwner {

    private Codecooler codecooler;
    private Artifact artifact;

    public ArtifactOwner(Codecooler codecooler, Artifact artifact) {
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
