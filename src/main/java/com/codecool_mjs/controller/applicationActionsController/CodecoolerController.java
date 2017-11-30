package com.codecool_mjs.controller.applicationActionsController;

import com.codecool_mjs.dataaccess.ConnectionProvider;
import com.codecool_mjs.dataaccess.dao.CodecoolerDao;
import com.codecool_mjs.dataaccess.dao.Dao;
import com.codecool_mjs.dataaccess.dao.DaoException;
import com.codecool_mjs.dataaccess.dao.WalletDao;
import com.codecool_mjs.model.Codecooler;
import com.codecool_mjs.model.Wallet;

import java.util.List;
import java.util.Map;
import java.util.UUID;

public class CodecoolerController {

    private Dao<Codecooler> codecoolerDao;
    private Dao<Wallet> walletDao;
    private static CodecoolerController instance = null;

    public CodecoolerController(){
        setDao();
    }

    private void setDao(){
        try{
            codecoolerDao = new CodecoolerDao();
            walletDao = new WalletDao();
            ConnectionProvider.getInstance().connectionRequest(codecoolerDao);
            ConnectionProvider.getInstance().connectionRequest(walletDao);
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
        Codecooler codecooler = this.codecoolerDao.getById(id);
        return codecooler;
    }

    public List<Codecooler> getAllCodecoolers() throws DaoException {
        List<Codecooler> codecoolers = this.codecoolerDao.getAll();
        return codecoolers;
    }

    public void deleteCodecooler(Integer id) throws DaoException {
        Codecooler codecooler = codecoolerDao.getById(id);
        Wallet wallet = codecooler.getWallet();
        this.codecoolerDao.delete(codecooler);
        walletDao.delete(wallet);
    }

    public void addCodecooler(Map<String, String> codecoolerData) throws DaoException {
        String name = codecoolerData.get("name");
        String surname = codecoolerData.get("surname");
        String email = codecoolerData.get("email");
        String password = UUID.randomUUID().toString();

        Codecooler codecooler = new Codecooler(name, surname, email, password);
        this.codecoolerDao.insert(codecooler);
        Codecooler insertedCodecooler = codecoolerDao.getLast();
        Wallet codecoolerWallet = new Wallet(insertedCodecooler.getId());
        this.walletDao.insert(codecoolerWallet);
    }

    public void editCodecooler(Map<String, String> codecoolerData) throws DaoException {

        Integer id = Integer.parseInt(codecoolerData.get("id"));
        String name = codecoolerData.get("name");
        String surname = codecoolerData.get("surname");
        String email = codecoolerData.get("email");
        String password = codecoolerData.get("password");
        Codecooler codecooler= new Codecooler(id, name, surname, email, password);
        this.codecoolerDao.update(codecooler);
    }

    public void updateCodecoolerWallet(Codecooler codecooler) throws DaoException{
        Wallet wallet = codecooler.getWallet();
        walletDao.update(wallet);
    }

    public void updateCodecoolerWallet(Codecooler codecooler) throws DaoException {

    }
}
