package com.codecool_mjs.controller.applicationActionsController;

import com.codecool_mjs.dataaccess.ConnectionProvider;
import com.codecool_mjs.dataaccess.dao.DaoException;
import com.codecool_mjs.dataaccess.dao.IDao;
import com.codecool_mjs.dataaccess.dao.UserMembershipDao;
import com.codecool_mjs.model.Group;
import com.codecool_mjs.model.User;
import com.codecool_mjs.model.UserMembership;

import java.util.List;


public class UserMembershipController {
    private IDao<UserMembership> dao;
    private static UserMembershipController instance = null;

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

    public static UserMembershipController getInstance() {
        if(instance==null){
            instance = new UserMembershipController();
        }
        return instance;
    }

    public void addMembership(List<Integer> usersId) throws DaoException {

        Group group = GroupController.getInstance().getLastGroup();

        for (Integer id : usersId) {
            User user = MentorController.getInstance().getMentorById(id);
            UserMembership um = new UserMembership(user, group);
            this.dao.insert(um);
            //coś się dodaje ale nie do końca to, co trzeba, zrobim jutro resztę
        }
    }
}
