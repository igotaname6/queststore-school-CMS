package com.codecool_mjs;

import com.codecool_mjs.controller.AdminMenuController;
import com.codecool_mjs.dataaccess.ConnectionProvider;
import com.codecool_mjs.dataaccess.dao.Dao;
import com.codecool_mjs.dataaccess.dao.MentorDao;
import com.codecool_mjs.model.User;

import java.util.List;
import java.sql.SQLException;


public class App 
{
    public static void main( String[] args )
    {

        System.out.println( "Hello World!" );

        try {
            AdminMenuController amc = new AdminMenuController();
            amc.startController();
        } catch (SQLException e) {
            e.printStackTrace();
        }

    }
}
