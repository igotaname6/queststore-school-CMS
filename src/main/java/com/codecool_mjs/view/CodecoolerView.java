package com.codecool_mjs.view;

import com.codecool_mjs.model.User;

import java.util.List;

public class CodecoolerView {

    public static void printAllCodecoolers(List<User> codecoolers) {

        for (User codecooler : codecoolers) {
            String data = String.format("%d. %s || %s", codecooler.getId(), codecooler.getFullName(), codecooler.getEmail());
            System.out.println(data);
        }
    }
}
