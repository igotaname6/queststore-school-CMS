package com.codecool_mjs.controller.applicationActionsController;

import com.codecool_mjs.dataaccess.ConnectionProvider;
import com.codecool_mjs.dataaccess.dao.ArtifactDao;
import com.codecool_mjs.dataaccess.dao.Dao;
import com.codecool_mjs.dataaccess.dao.DaoException;
import com.codecool_mjs.model.Artifact;

import java.util.List;
import java.util.Map;

public class ArtifactController {

    private Dao<Artifact> dao;
    private static ArtifactController instance = null;

    public ArtifactController() {
        setDao();
    }

    private void setDao() {
        try {
            dao = new ArtifactDao();
            ConnectionProvider.getInstance().connectionRequest(dao);
        } catch (DaoException e) {
            e.printStackTrace();
        }
    }

    public static ArtifactController getInstance() {
        if (instance == null) {
            instance = new ArtifactController();
        }
        return instance;
    }

    public List<Artifact> getAllArtifacts() throws DaoException {
        return dao.getAll();
    }

    public void addArtifact(Map<String, String> artifactData) throws DaoException {
        String name = artifactData.get("name");
        String description = artifactData.get("description");
        String cost = artifactData.get("cost");
        Boolean isGroup = false;
        Boolean isUsed = false;

        if (artifactData.get("isGroup").equals("true")) {
            isGroup = true;
        }
        if (artifactData.get("isUsed").equals("true")) {
            isUsed = true;
        }

        Artifact artifact = new Artifact(name, description, cost, isGroup, isUsed);
        this.dao.insert(artifact);
    }

    public Artifact getArtifactById(Integer id) throws DaoException {
        Artifact artifact = this.dao.getById(id);
        return artifact;
    }


}

