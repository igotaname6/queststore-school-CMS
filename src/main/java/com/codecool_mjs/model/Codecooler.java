package com.codecool_mjs.model;

public class Codecooler extends User {

    private Wallet wallet;

    public Codecooler(Integer id, String name, String surname, String email, String password, Wallet wallet) {
        super(id, name, surname, email, password);
        this.wallet = wallet;
    }

    public Codecooler() {
        super();
        this.wallet = null;
    }

    public Wallet getWallet() {
        return wallet;
    }

    public void setWallet(Wallet wallet) {
        this.wallet = wallet;
    }
}
