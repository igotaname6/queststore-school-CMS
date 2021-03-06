package com.codecool_mjs.controller.applicationActionsController;

import com.codecool_mjs.dataaccess.ConnectionProvider;
import com.codecool_mjs.dataaccess.dao.ArtifactDao;
import com.codecool_mjs.dataaccess.dao.ArtifactOwnerDao;
import com.codecool_mjs.dataaccess.dao.Dao;
import com.codecool_mjs.dataaccess.dao.DaoException;
import com.codecool_mjs.model.Artifact;
import com.codecool_mjs.model.ArtifactOwner;

import java.util.List;
import java.util.Map;

public class ArtifactController {

    private ArtifactDao dao;
    private ArtifactOwnerDao artifactOwnerDao;
    private static ArtifactController instance = null;


    public ArtifactController() {
        setDao();
    }

    private void setDao() {
        try {
            dao = new ArtifactDao();
            artifactOwnerDao = new ArtifactOwnerDao();
            artifactOwnerDao.setConnection();
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
        Integer cost = Integer.parseInt(artifactData.get("cost"));
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
    public void deleteArtifact(Integer id) throws DaoException {
        Artifact artifact = new Artifact(id);
        this.dao.delete(artifact);
    }

    public void editArtifact(Map<String, String> artifactData) throws DaoException {

        Integer id = Integer.parseInt(artifactData.get("id"));
        String name = artifactData.get("name");
        String description = artifactData.get("description");
        Integer cost = Integer.parseInt(artifactData.get("cost"));
        Boolean isGroup = false;
        Boolean isUsed = false;

        if (artifactData.get("isGroup").equals("true")) {
            isGroup = true;
        }
        if (artifactData.get("isUsed").equals("true")) {
            isUsed = true;
        }

        Artifact artifact = new Artifact(id, name, description, cost, isGroup, isUsed);

        this.dao.update(artifact);
    }

    public List<Artifact> getArtifactsOwnedByUser(int user_id) throws DaoException {
        return dao.getArtifactsByUserId(user_id);
    }
}

