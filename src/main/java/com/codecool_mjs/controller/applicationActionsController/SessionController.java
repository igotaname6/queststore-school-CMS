package com.codecool_mjs.controller.applicationActionsController;

import com.codecool_mjs.dataaccess.dao.DaoException;
import com.codecool_mjs.dataaccess.dao.LogInDao;
import com.codecool_mjs.model.User;

import java.util.UUID;

public class SessionController{

    private LogInDao dao;
    private User loggedUser;

    public SessionController(){
        dao = new LogInDao();
    }

    public void logIn(String email, String password) throws DaoException{
        User user;

        user = dao.checkLogin(email, password);
        if(user != null){
            String uuid = createSessionUUID();
        }

    }

    private String createSessionUUID(){
        return UUID.randomUUID().toString();
    }



}
