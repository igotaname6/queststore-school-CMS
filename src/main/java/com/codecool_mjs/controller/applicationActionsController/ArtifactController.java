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


}

