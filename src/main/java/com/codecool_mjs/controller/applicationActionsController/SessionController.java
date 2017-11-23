package com.codecool_mjs.controller.applicationActionsController;

import com.codecool_mjs.dataaccess.dao.LogInDao;
import com.codecool_mjs.model.User;

public class SessionController{

    private LogInDao dao;
    private User loggedUser;

    public SessionController(){
        dao = new LogInDao();
    }

    public void logIn(String userName, String password){


    }

}
