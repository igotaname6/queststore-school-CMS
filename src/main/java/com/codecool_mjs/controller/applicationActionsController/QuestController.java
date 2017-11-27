package com.codecool_mjs.controller.applicationActionsController;

import com.codecool_mjs.dataaccess.ConnectionProvider;
import com.codecool_mjs.dataaccess.dao.Dao;
import com.codecool_mjs.dataaccess.dao.DaoException;
import com.codecool_mjs.dataaccess.dao.QuestDao;
import com.codecool_mjs.model.Quest;

import java.util.List;
import java.util.Map;

public class QuestController {

    private Dao<Quest> dao;
    private static QuestController instance = null;

    public QuestController() {
        setDao();
    }

    private void setDao() {
        try {
            dao = new QuestDao();
            ConnectionProvider.getInstance().connectionRequest(dao);
        } catch (DaoException e) {
            e.printStackTrace();
        }
    }

    public static QuestController getInstance() {
        if (instance == null) {
            instance = new QuestController();
        }
        return instance;
    }

    public List<Quest> getAllQuests() throws DaoException {
        return dao.getAll();
    }


}
