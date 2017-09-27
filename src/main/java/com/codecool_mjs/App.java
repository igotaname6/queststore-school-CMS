package com.codecool_mjs;

import com.codecool_mjs.dataaccess.ConnectionProvider;

import java.sql.Connection;
import java.sql.SQLException;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args )
    {
        System.out.println( "Hello World!" );
        try {
            Connection con = ConnectionProvider.getConnection();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
