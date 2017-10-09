package com.codecool_mjs.model;

public class TeamArtifact extends Artifact {

    public TeamArtifact() {
        
        super();
    }

    public TeamArtifact(Integer id, String name, String description, Integer cost, Boolean isUsed) {

        super(id, name, description, cost, isUsed);
    }

}
