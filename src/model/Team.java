package model;

import java.util.ArrayList;

public class Team {

    private String name;
    private ArrayList<TeamQuest> achievedQuests;
    private ArrayList<TeamArtifact> ownArtifacts;
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

    public ArrayList<TeamQuest> getAchievedQuests() {
        return this.achievedQuests;
    }

    public ArrayList<TeamArtifact> getOwnArtifacts() {
        return this.ownArtifacts;
    }

    public ArrayList<Codecooler> getMembers() {
        return this.members;
    }

    public void addTeamArtifact(TeamArtifact artifact) {
        this.ownArtifacts.add(artifact);
    }

    public void addTeamQuest(TeamQuest quest) {
        this.achievedQuests.add(quest);
    }

    public void addMember(Codecooler member) {
        this.members.add(member);
    }

    public void removeMember(Codecooler member) {
        this.members.remove(member);
    }

    public void splitEqualGainedCoins() {
        //to implementation
    }
}
