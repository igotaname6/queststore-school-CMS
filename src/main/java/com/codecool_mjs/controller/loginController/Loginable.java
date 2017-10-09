package com.codecool_mjs.controller.loginController;

import com.codecool_mjs.model.Login;

import java.sql.SQLException;

public interface Loginable {

    void login(Login user) throws SQLException;
}
