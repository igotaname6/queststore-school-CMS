package com.codecool_mjs.controller.applicationActionsController;

import com.codecool_mjs.dataaccess.ConnectionProvider;
import com.codecool_mjs.dataaccess.dao.Dao;
import com.codecool_mjs.dataaccess.dao.DaoException;
import com.codecool_mjs.dataaccess.dao.TeamDao;
import com.codecool_mjs.model.Team;

import java.util.List;

public class TeamController {
    private Dao<Team> dao;
    private static TeamController instance = null;

    public TeamController() {
        setDao();
    }

    private void setDao() {
        try {
            dao = new TeamDao();
            ConnectionProvider.getInstance().connectionRequest(dao);
        } catch (DaoException e) {
            e.printStackTrace();
        }
    }

    public static TeamController getInstance() {
        if (instance == null) {
            instance = new TeamController();
        }
        return instance;
    }

    public List<Team> getAllTeams() throws DaoException {
        return dao.getAll();
    }
}
