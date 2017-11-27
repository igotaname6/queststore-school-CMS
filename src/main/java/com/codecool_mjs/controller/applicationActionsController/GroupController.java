package com.codecool_mjs.controller.applicationActionsController;

import com.codecool_mjs.dataaccess.ConnectionProvider;
import com.codecool_mjs.dataaccess.dao.Dao;
import com.codecool_mjs.dataaccess.dao.DaoException;
import com.codecool_mjs.dataaccess.dao.GroupDao;
import com.codecool_mjs.dataaccess.dao.IDao;
import com.codecool_mjs.model.Group;
import com.codecool_mjs.model.Mentor;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class GroupController {

    private Dao<Group> dao;
    private static GroupController instance = null;

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

    public static GroupController getInstance() {
        if(instance==null){
            instance = new GroupController();
        }
        return instance;
    }

    public List<Group> getAllGroups() throws DaoException {
        return dao.getAll();
    }

    public void addGroup(Map<String, String> groupData) throws DaoException {
        String name = groupData.get("groupName");
        Group group = new Group(name);
        this.dao.insert(group);
    }

    public Group getLastGroup() throws DaoException {
        Group group = this.dao.getLast();
        return group;
    }

    public Group getGroup(Integer id) throws DaoException {
        Group group = this.dao.getById(id);
        return group;
    }

}
