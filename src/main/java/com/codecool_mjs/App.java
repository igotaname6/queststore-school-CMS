package com.codecool_mjs;

import com.codecool_mjs.severProvider.ServerController;

import java.io.IOException;

public class App {

    public static void main(String[] args) {

        ServerController sc = new ServerController();

        try {
            sc.createAndStartSever();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
