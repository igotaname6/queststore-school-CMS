package com.codecool_mjs;

import com.codecool_mjs.controller.LoginController;
import java.sql.SQLException;


public class App 
{
    public static void main( String[] args )
    {
            LoginController lc = new LoginController();
            lc.startController();

    }
}
