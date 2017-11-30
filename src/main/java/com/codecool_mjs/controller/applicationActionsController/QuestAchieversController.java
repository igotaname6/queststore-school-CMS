package com.codecool_mjs.controller.applicationActionsController;

import com.codecool_mjs.dataaccess.dao.QuestAchieverDao;
import com.codecool_mjs.model.Codecooler;
import com.codecool_mjs.model.Quest;
import com.codecool_mjs.model.QuestAchiever;

public class QuestAchieversController {

    private QuestAchieverDao qad = new QuestAchieverDao();

    public QuestAchieverDao getQad() {
        return qad;
    }

    public void addQuestAchiever(Integer userId, Integer questId) {
        Codecooler codecooler = new Codecooler(userId);
        Quest quest = new Quest(questId);
        QuestAchiever questAchiever = new QuestAchiever(codecooler, quest);

        qad.addQuestAchiever(questAchiever);
    }
}
