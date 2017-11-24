package com.codecool_mjs.controller.applicationActionsController;

import com.codecool_mjs.dataaccess.ConnectionProvider;
import com.codecool_mjs.dataaccess.dao.DaoException;
import com.codecool_mjs.dataaccess.dao.IDao;
import com.codecool_mjs.dataaccess.dao.MentorDao;
import com.codecool_mjs.model.Mentor;

import java.util.List;
import java.util.Map;
import java.util.UUID;

public class MentorController {

    private IDao<Mentor> dao;
    private static MentorController instance = null;

    public MentorController(){
        setDao();
    }

    private void setDao(){
        try{
            dao = new MentorDao();
            ConnectionProvider.getInstance().connectionRequest(dao);
        } catch (DaoException e) {
            e.printStackTrace();
        }
    }

    public static MentorController getInstance() {
        if(instance==null){
            instance = new MentorController();
        }
        return instance;
    }

    public List<Mentor> getAllMentors() throws DaoException {
        return dao.getAll();
    }

    public void addMentor(Map<String, String> mentorData) throws DaoException {
        String name = mentorData.get("name");
        String surname = mentorData.get("surname");
        String email = mentorData.get("email");
        //how to generate password?
        String password = UUID.randomUUID().toString();
        Mentor mentor = new Mentor(name, surname, email, password);
        this.dao.insert(mentor);
    }

    public void editMentor(Map<String, String> mentorData) throws DaoException {

        System.out.println(mentorData);

        Integer id = Integer.parseInt(mentorData.get("id"));
        String name = mentorData.get("name");
        String surname = mentorData.get("surname");
        String email = mentorData.get("email");
        String password = mentorData.get("password");
        Mentor mentor = new Mentor(id, name, surname, email, password);
        this.dao.update(mentor); 
    }

    public void deleteMentor(Integer id) throws DaoException {
        Mentor mentor = new Mentor(id);
        this.dao.delete(mentor);
    }

    public Mentor getMentorById(Integer id) throws DaoException {
        Mentor mentor = this.dao.getById(id);
        return mentor;
    }

    public static void main(String[] args) throws DaoException {
        MentorController.getInstance().deleteMentor(1);
    }
}