package com.codecool_mjs.view.oldConsoleView;

import com.codecool_mjs.model.Codecooler;
import com.codecool_mjs.model.User;

import java.util.List;

public class CodecoolerView {

    public static void printAllCodecoolers(List<Codecooler> codecoolers) {

        for (User codecooler : codecoolers) {
            String data = String.format("%d. %s || %s", codecooler.getId(), codecooler.getName() + codecooler.getSurname(), codecooler.getEmail());
            System.out.println(data);
        }
    }
}
