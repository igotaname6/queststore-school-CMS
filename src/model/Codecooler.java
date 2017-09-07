package model;

import java.util.ArrayList;

public class Codecooler extends AbstractUser {

    private ArrayList<Quest> achievedQuests;
    private ArrayList<Artifact> ownArtifacts;
    private ArrayList<Team> teams;
    private Wallet wallet;

    public Codecooler(String name, String surname, String email, String password) {
        super(name, surname, email, password);
        this.achievedQuests = new ArrayList<>();
        this.achievedQuests = new ArrayList<>();
        this.achievedQuests = new ArrayList<>();
        this.wallet = new Wallet();
    }
}
