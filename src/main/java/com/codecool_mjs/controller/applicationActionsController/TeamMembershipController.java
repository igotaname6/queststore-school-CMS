package com.codecool_mjs.controller.applicationActionsController;

import com.codecool_mjs.dataaccess.dao.DaoException;
import com.codecool_mjs.dataaccess.dao.MembershipDao;
import com.codecool_mjs.dataaccess.dao.TeamMembershipDao;
import com.codecool_mjs.model.GroupMembership;
import com.codecool_mjs.model.TeamMembership;

import java.util.List;


public class TeamMembershipController {

    private MembershipDao<TeamMembership> dao;
    private static TeamMembershipController instance = null;

    private TeamMembershipController() {
        setDao();
    }

    private void setDao() { dao = new TeamMembershipDao(); }

    public static TeamMembershipController getInstance() {
        if (instance == null) {
            instance = new TeamMembershipController();
        }
        return instance;
    }

    public List<TeamMembership> getAll() throws DaoException {
        List<TeamMembership> tmList = this.dao.getAll();
        return tmList;
    }
}
