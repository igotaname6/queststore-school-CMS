package com.codecool_mjs.model;

public class Codecooler extends User {

    private Integer groupId;
    private Wallet wallet;


    public Codecooler(Integer id, String name, String surname, String email, String password,
                      Integer groupId, Wallet wallet) {

        super(id, name, surname, email, password);
        this.groupId = groupId;
        this.wallet = wallet;
    }

    public Codecooler(Integer id, String name, String surname, String email, String password) {

        super(id, name, surname, email, password);
        this.groupId = null;
        this.wallet = null;
    }

    public Wallet getWallet() {
        return wallet;
    }

    public void setWallet(Wallet wallet) {
        this.wallet = wallet;
    }

    public Integer getGroupId() {
        return this.groupId;
    }

    public void setGroupId(Integer groupId) {
        this.groupId = groupId;
    }
}
