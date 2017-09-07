package model;

import java.util.ArrayList;

public class Team {

    private String name;
    private ArrayList<Quest> achievedQuests;
    private ArrayList<Artifact> ownArtifacts;
    private ArrayList<Codecooler> members;

    public Team(String name) {
        this.name = name;
        this.achievedQuests = new ArrayList<>();
        this.ownArtifacts = new ArrayList<>();
        this.members = new ArrayList<>();
    }

    public String getName() {
        return this.name;
    }
    
    public ArrayList<Quest> getAchievedQuests() {
        return this.achievedQuests;
    }

    public ArrayList<Artifact> getOwnArtifacts() {
        return this.ownArtifacts;
    }

    public ArrayList<Codecooler> getMembers() {
        return this.members;
    }
}
