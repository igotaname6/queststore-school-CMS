package com.codecool_mjs.controller.applicationActionsController;

import com.codecool_mjs.dataaccess.ConnectionProvider;
import com.codecool_mjs.dataaccess.dao.CodecoolerDao;
import com.codecool_mjs.dataaccess.dao.Dao;
import com.codecool_mjs.dataaccess.dao.DaoException;
import com.codecool_mjs.model.Codecooler;

import java.util.List;
import java.util.Map;
import java.util.UUID;

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

    public void deleteCodecooler(Integer id) throws DaoException {
        Codecooler codecooler = new Codecooler(id);
        this.dao.delete(codecooler);
    }

    public void addCodecooler(Map<String, String> codecoolerData) throws DaoException {
        String name = codecoolerData.get("name");
        String surname = codecoolerData.get("surname");
        String email = codecoolerData.get("email");
        String password = UUID.randomUUID().toString();
        Codecooler codecooler = new Codecooler(name, surname, email, password);
        this.dao.insert(codecooler);
    }

    public void editCodecooler(Map<String, String> codecoolerData) throws DaoException {

        Integer id = Integer.parseInt(codecoolerData.get("id"));
        String name = codecoolerData.get("name");
        String surname = codecoolerData.get("surname");
        String email = codecoolerData.get("email");
        String password = codecoolerData.get("password");
        Codecooler codecooler= new Codecooler(id, name, surname, email, password);
        this.dao.update(codecooler);
    }
}
