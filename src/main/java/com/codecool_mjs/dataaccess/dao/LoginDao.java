package com.codecool_mjs.dataaccess.dao;

import com.codecool_mjs.dataaccess.ConnectionProvider;
import com.codecool_mjs.model.Login;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class LoginDao {

    Connection connection;

    public LoginDao() {

        this.connection = ConnectionProvider.getConnection();
    }

    public Login getLoginData(String email, String password) {

        String query = "SELECT * FROM users WHERE email = '" + email + "' AND password = '" + password + "'";

        Statement statement;
        ResultSet result;
        Integer id = 0;
        String profession = "";
        Login login = null;

        try {

            statement = this.connection.createStatement();
            result = statement.executeQuery(query);

            if (result.next()) {
                id = result.getInt("id");
                profession = result.getString("profession");
            }
            login = new Login(id, profession);

            statement.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return login;
    }
}
