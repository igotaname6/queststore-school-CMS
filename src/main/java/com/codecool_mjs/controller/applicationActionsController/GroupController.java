package com.codecool_mjs.controller.applicationActionsController;

import com.codecool_mjs.dataaccess.ConnectionProvider;
import com.codecool_mjs.dataaccess.dao.DaoException;
import com.codecool_mjs.dataaccess.dao.GroupDao;
import com.codecool_mjs.dataaccess.dao.IDao;
import com.codecool_mjs.model.Group;

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
}
