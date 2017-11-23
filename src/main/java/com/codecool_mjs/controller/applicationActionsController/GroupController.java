package com.codecool_mjs.controller.applicationActionsController;

import com.codecool_mjs.dataaccess.ConnectionProvider;
import com.codecool_mjs.dataaccess.dao.DaoException;
import com.codecool_mjs.dataaccess.dao.GroupDao;
import com.codecool_mjs.dataaccess.dao.IDao;
import com.codecool_mjs.model.Group;
import com.codecool_mjs.model.Mentor;

import java.util.List;
import java.util.Map;

public class GroupController {

    private GroupDao dao;
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

    public void addGroup(Map<String, String> groupData, List<Integer> mentorsId) throws DaoException {
        String name = groupData.get("name");
        Group group = new Group(name);

        for (Integer id : mentorsId) {
            Mentor mentor = MentorController.getInstance().getMentorById(id);
            group.addToMentors(mentor);
        }

        this.dao.insert(group);
        //add to membership dao???
    }
}
