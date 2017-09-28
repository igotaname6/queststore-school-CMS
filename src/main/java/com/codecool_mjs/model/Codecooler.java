package com.codecool_mjs.model;

import java.util.ArrayList;

public class Codecooler extends User {

    private ArrayList<Quest> achievedQuests;
    private ArrayList<Artifact> ownArtifacts;
    private ArrayList<Team> teams;
    private Wallet wallet;

    public Codecooler(int id, String name, String surname, String email, String password) {
        super(id, name, surname, email, password);
        this.achievedQuests = new ArrayList<>();
        this.ownArtifacts = new ArrayList<>();
        this.teams = new ArrayList<>();
//        this.wallet = new Wallet();
    }

    public void addTeam(Team team) {
        this.teams.add(team);
    }

    public void addArtifact(Artifact artifact) {
        this.ownArtifacts.add(artifact);
    }

    public void addQuest(Quest quest) {
        this.achievedQuests.add(quest);
    }

    public void removeTeam(Team team) {
        this.teams.remove(team);
    }

    public ArrayList<Quest> getAchievedQuests() {
        return this.achievedQuests;
    }

    public ArrayList<Artifact> getOwnArtifacts() {
        return this.ownArtifacts;
    }

    public ArrayList<Team> getTeams() {
        return this.teams;
    }

    public Wallet getWallet() {
        return this.wallet;
    }

    public void getLevel(Wallet wallet) {
        //to implementation!
    }
}
