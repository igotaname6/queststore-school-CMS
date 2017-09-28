package com.codecool_mjs.dataaccess.dao;

import com.codecool_mjs.dataaccess.ConnectionProvider;
import com.codecool_mjs.model.Login;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class LoginDao {

    Connection connection;

    public LoginDao() throws SQLException {

        this.connection = ConnectionProvider.getConnection();
    }

    public Login getLoginData(String email, String password) throws SQLException {

        String query = "SELECT * FROM users WHERE email = '" + email + "' AND password = '" + password + "'";

        Statement statement;
        ResultSet result;
        Integer id = null;
        String profession = null;
        Login login;

        statement = this.connection.createStatement();
        result = statement.executeQuery(query);

        id = result.getInt("id");
        profession = result.getString("profession");

        login = new Login(id, profession);

        return login;
    }
}
