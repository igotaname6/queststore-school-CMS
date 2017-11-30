package com.codecool_mjs.controller.applicationActionsController;

import com.codecool_mjs.dataaccess.dao.ArtifactOwnerDao;
import com.codecool_mjs.model.Artifact;
import com.codecool_mjs.model.ArtifactOwner;
import com.codecool_mjs.model.Codecooler;

public class ArtifactOwnerController {

    private ArtifactOwnerDao dao = new ArtifactOwnerDao();

    public ArtifactOwnerDao getDao() {
        return dao;
    }

    public void addArtifactOwner(Integer userId, Integer artifactId) {
        Codecooler codecooler = new Codecooler(userId);
        Artifact artifact = new Artifact(artifactId);
        ArtifactOwner artifactOwner = new ArtifactOwner(codecooler, artifact);

        dao.addArtifactOwner(artifactOwner);
    }
}
