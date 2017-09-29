package com.codecool_mjs.controller.coodecoolerController;

import com.codecool_mjs.dataaccess.dao.CodecoolerDao;
import com.codecool_mjs.dataaccess.dao.Dao;
import com.codecool_mjs.model.User;
import com.codecool_mjs.view.CodecoolerView;

import java.sql.SQLException;
import java.util.List;

public class CodecoolerController {

    private Dao<User> dao;

    public CodecoolerController() throws SQLException {
        this.dao = new CodecoolerDao();
    }

    public void showCodecoolersAction() {

        List<User> codecoolers;
        codecoolers = this.dao.getAll();

        CodecoolerView.printAllCodecoolers(codecoolers);
    }
}

