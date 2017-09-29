package com.codecool_mjs;

import com.codecool_mjs.controller.loginController.LoginController;
import java.sql.SQLException;


public class App 
{
    public static void main( String[] args )
    {
        try {
            LoginController lc = new LoginController();
            lc.startController();
        } catch (SQLException e) {
            e.printStackTrace();
        }

    }
}
