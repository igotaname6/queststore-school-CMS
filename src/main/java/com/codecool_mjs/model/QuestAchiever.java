package com.codecool_mjs.model;

public class QuestAchiever {

    private Codecooler codecooler;
    private Quest quest;

    public QuestAchiever(Codecooler codecooler, Quest quest) {
        this.codecooler = codecooler;
        this.quest = quest;
    }

    public Codecooler getCodecooler() {
        return codecooler;
    }

    public Quest getQuest() {
        return quest;
    }
}
