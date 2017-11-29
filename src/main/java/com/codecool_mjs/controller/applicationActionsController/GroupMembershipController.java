package com.codecool_mjs.controller.applicationActionsController;

import com.codecool_mjs.dataaccess.ConnectionProvider;
import com.codecool_mjs.dataaccess.dao.DaoException;
import com.codecool_mjs.dataaccess.dao.GroupMembershipDao;
import com.codecool_mjs.dataaccess.dao.MembershipDao;
import com.codecool_mjs.model.GroupMembership;

public class GroupMembershipController {

    private MembershipDao<GroupMembership> dao;
    private static GroupMembershipController instance = null;

    private GroupMembershipController() {
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
}
