package com.codecool_mjs.controller.applicationActionsController;

import com.codecool_mjs.dataaccess.ConnectionProvider;
import com.codecool_mjs.dataaccess.dao.DaoException;
import com.codecool_mjs.dataaccess.dao.GroupDao;
import com.codecool_mjs.dataaccess.dao.IDao;
import com.codecool_mjs.model.Group;

import java.util.List;
import java.util.Map;

public class GroupController {

    private IDao<Group> dao;

    public GroupController(){
        setDao();
    }

    private void setDao(){
        try{
            dao = new GroupDao();
            ConnectionProvider.getInstance().connectionRequest(dao);
        } catch (DaoException e) {
            e.printStackTrace();
        }
    }

    public List<Group> getAllGroups() throws DaoException {
        return dao.getAll();
    }

    //map z danymi, lista z id mentorów przypisanych do klasy
    public void addGroup(Map<String, String> groupData) throws DaoException {
        String name = groupData.get("name");
        Group group = new Group(name);
        this.dao.insert(group);
    }
}
