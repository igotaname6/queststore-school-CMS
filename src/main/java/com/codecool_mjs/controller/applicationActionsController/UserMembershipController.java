package com.codecool_mjs.controller.applicationActionsController;

import com.codecool_mjs.dataaccess.ConnectionProvider;
import com.codecool_mjs.dataaccess.dao.DaoException;
import com.codecool_mjs.dataaccess.dao.IDao;
import com.codecool_mjs.dataaccess.dao.UserMembershipDao;
import com.codecool_mjs.model.Group;
import com.codecool_mjs.model.User;
import com.codecool_mjs.model.UserMembership;

import java.util.ArrayList;
import java.util.List;


public class UserMembershipController {
    private IDao<UserMembership> dao;
    private static UserMembershipController instance = null;
    private MentorController mentorCon = MentorController.getInstance();
    private CodecoolerController codecoolerCon = CodecoolerController.getInstance();
    private GroupController groupCon = GroupController.getInstance();

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

    public void addMentorsToGroup(List<Integer> usersId, Integer groupId) throws DaoException {

        Group group = groupCon.getGroup(groupId);

        for (Integer id : usersId) {
            User user = mentorCon.getMentorById(id);
            UserMembership um = new UserMembership(user, group);
            this.dao.insert(um);
        }
    }

    public void addCodecoolersToGroup(List<Integer> usersId, Integer groupId) throws DaoException {

        Group group = groupCon.getGroup(groupId);

        for (Integer id : usersId) {
            User user = codecoolerCon.getCodecooler(id);
            UserMembership um = new UserMembership(user, group);
            this.dao.insert(um);
        }
    }


}
