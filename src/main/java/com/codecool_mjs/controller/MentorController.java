package com.codecool_mjs.controller;

import com.codecool_mjs.dataaccess.ConnectionProvider;
import com.codecool_mjs.dataaccess.dao.DaoException;
import com.codecool_mjs.dataaccess.dao.IDao;
import com.codecool_mjs.dataaccess.dao.MentorDao;
import com.codecool_mjs.model.Mentor;

import java.util.List;

public class MentorController {

    private IDao<Mentor> dao;

    public MentorController(){

    }

    public void setDao(){
        try{
            dao = new MentorDao();
            ConnectionProvider.getInstance().connectionRequest(dao);
        } catch (DaoException e) {
            e.printStackTrace();
        }
    }

    public List<Mentor> getAllMentors() throws DaoException {
        return dao.getAll();
    }
}
