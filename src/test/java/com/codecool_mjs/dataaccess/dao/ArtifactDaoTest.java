package com.codecool_mjs.dataaccess.dao;

import com.codecool_mjs.dataaccess.ConnectionProvider;
import com.codecool_mjs.model.Artifact;
import org.junit.Before;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.runners.MockitoJUnitRunner;

import java.sql.*;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Matchers.anyInt;
import static org.mockito.Matchers.anyString;
import static org.mockito.Mockito.*;

@RunWith(MockitoJUnitRunner.class)
class ArtifactDaoTest {

    private PreparedStatement prepStmt;
    private Connection conn;
    private ResultSet resSet;
    private ConnectionProvider connProv;

    Artifact artifact;

    @Before
    public void setupCreateObject() throws SQLException {

        resSet = mock(ResultSet.class);
        when(resSet.getInt(anyString())).thenReturn(1);
        when(resSet.getString(anyString())).thenReturn("data");
        when(resSet.getBoolean(anyString())).thenReturn(false);
    }

    @Before
    public void setupExecute() throws SQLException {

        prepStmt = mock(PreparedStatement.class);
        conn = mock(Connection.class);
        when(conn.prepareStatement("^INSERT.*$/")).thenReturn(prepStmt);
    }


    @Test
    public void testCreateObjectNotNull() throws SQLException {

        setupCreateObject();
        ArtifactDao instance = new ArtifactDao();
        artifact = instance.createObject(resSet);

        assertNotNull(artifact);
    }

    @Test
    public void testCreateObjectDefaultField() throws SQLException {

        setupCreateObject();
        ArtifactDao instance = new ArtifactDao();
        artifact = instance.createObject(resSet);

        assertFalse(artifact.getIsGroup());
    }

    @Test
    public void testExecuteInsertation() throws SQLException {

        setupExecute();
        setupCreateObject();

        when(prepStmt.executeUpdate()).thenReturn(1);

        ArtifactDao artifactDao = new ArtifactDao();
        Artifact newItem = artifactDao.createObject(resSet);

        int i = artifactDao.executeInsertation(newItem);


        verify(prepStmt, times(2)).setString(anyInt(), anyString());
        verify(prepStmt).setInt(3, anyInt());
        verify(prepStmt).setBoolean(4, anyBoolean());

        assertEquals(1, i);
    }

    @Test
    public void testExecuteDeletion() throws SQLException {

        setupExecute();
        ArtifactDao artifactDao = new ArtifactDao();
        setupCreateObject();
        Artifact newItem = artifactDao.createObject(resSet);
        artifactDao.executeInsertation(newItem);
        assertEquals(Integer.valueOf(1), artifactDao.executeDeletion(newItem));
    }

    @Test
    public void testGetQueryForGetAll() {

        String expected = "SELECT * FROM artifacts";
        assertEquals(expected, new ArtifactDao().getQueryForGetAll());
    }

    @Test
    public void testGetQueryForSearchBy() {

        String category = "category", arg = "arg";
        String expected = String.format("SELECT * FROM artifacts WHERE %s LIKE '%s'", category, arg);
        assertEquals(expected, new ArtifactDao().getQueryForSearchBy(category,arg));
    }

    @Test
    public void testGetInsertationStatement() {

        String expected = "INSERT INTO artifacts (name, description, cost, is_group)VALUES (?, ?, ?, ?)";
        assertEquals(expected, new ArtifactDao().getInsertationStatement());
    }
}