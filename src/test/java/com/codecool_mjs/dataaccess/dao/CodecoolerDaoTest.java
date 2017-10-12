package com.codecool_mjs.dataaccess.dao;

import com.codecool_mjs.dataaccess.ConnectionProvider;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.runners.MockitoJUnitRunner;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;

import static org.junit.jupiter.api.Assertions.*;

@RunWith(MockitoJUnitRunner.class)
class CodecoolerDaoTest {

    @Mock
    private ConnectionProvider connProv;
    @Mock
    private PreparedStatement prepStmt;
    @Mock
    private Connection conn;
    @Mock
    private ResultSet resSet;
    @Mock
    private Statement stmt;

    @Test
    public void testGetProfession() {

        assertEquals("codecooler", new CodecoolerDao().getProfession());
    }


}