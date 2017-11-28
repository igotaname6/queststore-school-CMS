package com.codecool_mjs.controller.applicationActionsController;

import com.codecool_mjs.dataaccess.ConnectionProvider;
import com.codecool_mjs.dataaccess.dao.Dao;
import com.codecool_mjs.dataaccess.dao.DaoException;
import com.codecool_mjs.dataaccess.dao.GroupMembershipDao;
import com.codecool_mjs.model.Group;
import com.codecool_mjs.model.User;
import com.codecool_mjs.model.GroupMembership;

import java.util.List;


public class GroupMembershipController {
    private Dao<GroupMembership> dao;
    private static GroupMembershipController instance = null;
    private MentorController mentorCon = MentorController.getInstance();
    private CodecoolerController codecoolerCon = CodecoolerController.getInstance();
    private GroupController groupCon = GroupController.getInstance();

    public GroupMembershipController() {
        setDao();
    }

    private void setDao() {
        try {
            dao = new GroupMembershipDao();
            ConnectionProvider.getInstance().connectionRequest(dao);
        } catch (DaoException e) {
            e.printStackTrace();
        }
    }

    public static GroupMembershipController getInstance() {
        if (instance == null) {
            instance = new GroupMembershipController();
        }
        return instance;
    }

    public void addMentorsToGroup(List<Integer> usersId, Integer groupId) throws DaoException {

        Group group = groupCon.getGroup(groupId);

        for (Integer id : usersId) {
            User user = mentorCon.getMentorById(id);
            GroupMembership um = new GroupMembership(user, group);
            this.dao.insert(um);
        }
    }

    public void addCodecoolersToGroup(List<Integer> usersId, Integer groupId) throws DaoException {

        Group group = groupCon.getGroup(groupId);

        for (Integer id : usersId) {
            User user = codecoolerCon.getCodecoolerById(id);
            GroupMembership um = new GroupMembership(user, group);
            this.dao.insert(um);
        }
    }
}
