package model;

public class Class {

    private String name;
    private ArrayList<Codecooler> members;
    private ArrayList<Mentor> mentor;

    public Class(String name) {
        this.name = name;
        this.members = new ArrayList<>();
        this.mentors = new ArrayList<>();
    }

    public ArrayList<Codecooler> getMembers() {
        return this.members;
    }
}
