package com.codecool_mjs.dataaccess.dao;

import com.codecool_mjs.model.Admin;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.mockito.runners.MockitoJUnitRunner;

import java.sql.*;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

@RunWith(MockitoJUnitRunner.class)
class AdminDaoTest {

    private Admin admin;
    private ResultSet resSet;

    @BeforeClass
    public static void setUpClass() throws Exception {}

    @AfterClass
    public static void tearDownClass() {}

    @BeforeEach
    public void setup() throws SQLException {

        resSet = mock(ResultSet.class);
        when(resSet.getInt(anyString())).thenReturn(1);
        when(resSet.getString(anyString())).thenReturn("data");
    }

    @After
    public void tearDown() {}

    @Test
    public void testCreateObjectNotNull() throws SQLException{

        AdminDao instance = new AdminDao();
        admin = instance.createObject(resSet);

        assertNotNull(admin);
    }

    @Test
    public void testCreatedObjectsName() throws SQLException{

        AdminDao instance = new AdminDao();
        admin = instance.createObject(resSet);

        assertEquals("data", admin.getName());
    }

    @Test
    public void testGetQueryForGetAll() {

        String expected = "SELECT * FROM users WHERE profession = 'admin'";
        AdminDao instance = new AdminDao();
        assertEquals(expected, instance.getQueryForGetAll());
    }

    @Test
    public void testGetQueryForSearchBy() {

        String category = "category", arg = "arg";
        String expected = String.format("SELECT * FROM users WHERE %s LIKE '%s' AND profession = 'admin'", category, arg);
        AdminDao instance = new AdminDao();
        assertEquals(expected, instance.getQueryForSearchBy(category, arg));
    }

    @Test
    public void testGetProfession() {

        AdminDao instance = new AdminDao();
        assertEquals("admin", instance.getProfession());
    }
}