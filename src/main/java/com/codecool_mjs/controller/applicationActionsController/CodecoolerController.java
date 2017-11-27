package com.codecool_mjs.controller.applicationActionsController;

import com.codecool_mjs.dataaccess.ConnectionProvider;
import com.codecool_mjs.dataaccess.dao.CodecoolerDao;
import com.codecool_mjs.dataaccess.dao.Dao;
import com.codecool_mjs.dataaccess.dao.DaoException;
import com.codecool_mjs.model.Codecooler;

import java.util.List;

public class CodecoolerController {

    private Dao<Codecooler> dao;
    private static CodecoolerController instance = null;

    public CodecoolerController(){
        setDao();
    }

    private void setDao(){
        try{
            dao = new CodecoolerDao();
            ConnectionProvider.getInstance().connectionRequest(dao);
        } catch (DaoException e) {
            e.printStackTrace();
        }
    }

    public static CodecoolerController getInstance() {
        if(instance==null){
            instance = new CodecoolerController();
        }
        return instance;
    }

    public Codecooler getCodecoolerById(Integer id) throws DaoException {
        Codecooler codecooler = this.dao.getById(id);
        return codecooler;
    }

    public List<Codecooler> getAllCodecoolers() throws DaoException {
        List<Codecooler> codecoolers = this.dao.getAll();
        return codecoolers;
    }
}
