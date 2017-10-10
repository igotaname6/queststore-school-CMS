package com.codecool_mjs.controller.coodecoolerController;

import com.codecool_mjs.dataaccess.dao.CodecoolerDao;
import com.codecool_mjs.dataaccess.dao.Dao;
import com.codecool_mjs.model.Codecooler;
import com.codecool_mjs.model.User;
import com.codecool_mjs.view.CodecoolerView;

import java.sql.SQLException;
import java.util.List;

public class CodecoolerController {

    private Dao<Codecooler> dao;

    public CodecoolerController() {
        this.dao = new CodecoolerDao();
    }

    public void showCodecoolersAction() {

        List<Codecooler> codecoolers;
        codecoolers = this.dao.getAll();

        CodecoolerView.printAllCodecoolers(codecoolers);
    }
}

