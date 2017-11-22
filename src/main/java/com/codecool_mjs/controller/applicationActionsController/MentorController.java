package com.codecool_mjs.controller.applicationActionsController;

import com.codecool_mjs.dataaccess.ConnectionProvider;
import com.codecool_mjs.dataaccess.dao.DaoException;
import com.codecool_mjs.dataaccess.dao.IDao;
import com.codecool_mjs.dataaccess.dao.MentorDao;
import com.codecool_mjs.model.Mentor;

import java.util.List;
import java.util.Map;
import java.util.UUID;

public class MentorController{

    private IDao<Mentor> dao;

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

    public List<Mentor> getAllMentors() throws DaoException {
        return dao.getAll();
    }

    //mentorData - mapa ze wszystkimi danymi potrzebnymi do stworzenia mentora
    public void addMentor(Map<String, String> mentorData) throws DaoException {
        String name = mentorData.get("name");
        String surname = mentorData.get("surname");
        String email = mentorData.get("email");
        String password = String.format("%s.%s", name, surname);
        Mentor mentor = new Mentor(name, surname, email, password);
        this.dao.insert(mentor);
    }

    //mapa zawierająca wszystkie dane mentora łącznie z jego id już po edycji
    public void editMentor(Map<String, String> mentorData) throws DaoException {
        Integer id = Integer.parseInt(mentorData.get("id"));
        String name = mentorData.get("name");
        String surname = mentorData.get("surname");
        String email = mentorData.get("email");
        String password = mentorData.get("password");
        Mentor mentor = new Mentor(id, name, surname, email, password);
        this.dao.update(mentor); 
    }
}
