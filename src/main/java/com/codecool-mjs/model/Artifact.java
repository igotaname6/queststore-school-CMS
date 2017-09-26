package model;

public class Artifact {

    private String name;
    private String description;
    private Integer cost;
    private Boolean isUsed;

    public Artifact() {

        this.name = null;
        this.description = null;
        this.cost = null;
        this.isUsed = false;
    }

    public Artifact(String name, String description, Integer cost) {

        this.name = name;
        this.description = description;
        this.cost = cost;
        this.isUsed = false;
    }

    public String getName() {

        return this.name;
    }

    public String getDescription() {

        return this.description;
    }

    public Integer getCost() {

        return this.cost;
    }

    public Boolean getIsUsed() {
        
        return this.isUsed;
    }

    public void setName(String name) {

        this.name = name;
    }

    public void setDescription(String description) {

        this.description = description;
    }

    public void setCost(Integer cost) {

        this.cost = cost;
    }

    public void useArtifact() {
        
        this.isUsed = true;
    }
}