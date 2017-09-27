package com.codecool_mjs.dataaccess.dao;

import com.codecool_mjs.model.Codecooler;
import com.codecool_mjs.model.User;

import java.sql.ResultSet;
import java.sql.SQLException;

public class AdminDao extends Dao<User> {

    private static String QUERY = "SELECT * FROM users WHERE profession = \"admin\";";


}

