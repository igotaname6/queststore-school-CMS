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

    public void addQuest(Map<String, String> questData) throws DaoException {
        String name = questData.get("name");
        String description = questData.get("description");
        Integer reward = Integer.parseInt(questData.get("reward"));
        Boolean isGroup;

        if (questData.get("isGroup").equals("true")) {
            isGroup = true;
        }
        else {
            isGroup = false;
        }
        Quest quest = new Quest(name, description, reward, isGroup);
        this.dao.insert(quest);
    }

    public Quest getQuestById(Integer id) throws DaoException {
        Quest quest = this.dao.getById(id);
        return quest;
    }

    public void deleteQuest(Integer id) throws DaoException {
        Quest quest = new Quest(id);
        this.dao.delete(quest);
    }

    public void editQuest(Map<String, String> questData) throws DaoException {

        Integer id = Integer.parseInt(questData.get("id"));
        String name = questData.get("name");
        String description = questData.get("description");
        Integer reward = Integer.parseInt(questData.get("reward"));
        Boolean isGroup;

        if (questData.get("isGroup").equals("true")) {
            isGroup = true;
        }
        else {
            isGroup = false;
        }
        Quest quest = new Quest(id, name, description, reward, isGroup);

        this.dao.update(quest);
    }
}
