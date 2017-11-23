package com.codecool_mjs.controller.applicationActionsController;

import com.codecool_mjs.dataaccess.ConnectionProvider;
import com.codecool_mjs.dataaccess.dao.DaoException;
import com.codecool_mjs.dataaccess.dao.IDao;
import com.codecool_mjs.dataaccess.dao.UserMembershipDao;
import com.codecool_mjs.model.UserMembership;

public class UserMembershipController {
    private IDao<UserMembership> dao;
    private static MentorController instance = null;

    public UserMembershipController(){
        setDao();
    }

    private void setDao(){
        try{
            dao = new UserMembershipDao();
            ConnectionProvider.getInstance().connectionRequest(dao);
        } catch (DaoException e) {
            e.printStackTrace();
        }
    }

    public static MentorController getInstance() {
        if(instance==null){
            instance = new MentorController();
        }
        return instance;
    }
}
