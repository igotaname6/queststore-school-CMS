package com.codecool_mjs.dataaccess.dao;

import com.codecool_mjs.dataaccess.ConnectionProvider;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import static org.junit.jupiter.api.Assertions.*;

class DaoTest {

    @Mock
    private ConnectionProvider connProv;
    @Mock
    private PreparedStatement prepStmt;
    @Mock
    private Connection conn;
    @Mock
    private ResultSet resSet;

    @Test
    public void testDaoConstructor() {


    }

}