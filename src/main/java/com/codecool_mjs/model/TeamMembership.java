package com.codecool_mjs.model;

import java.util.ArrayList;
import java.util.List;

public class TeamMembership {

    private List<Codecooler> codecoolers;
    private Team team;

    public TeamMembership(Team team) {
        this.team = team;
        this.codecoolers = new ArrayList<>();
    }

    public Team getTeam() {
        return team;
    }

    public List<Codecooler> getCodecoolers() {
        return codecoolers;
    }

    public void addCodecoolers(Codecooler codecooler) {
        this.codecoolers.add(codecooler);
    }
}