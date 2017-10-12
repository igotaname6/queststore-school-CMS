package com.codecool_mjs.dataaccess.dao;

import com.codecool_mjs.dataaccess.ConnectionProvider;
import com.codecool_mjs.model.Artifact;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.runners.MockitoJUnitRunner;

import java.sql.*;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Matchers.anyString;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

@RunWith(MockitoJUnitRunner.class)
class ArtifactDaoTest {

    private PreparedStatement prepStmt;
    private Connection conn;
    private ResultSet resSet;

    Artifact artifact;

    @BeforeEach
    public void setup() throws SQLException {

        prepStmt = mock(PreparedStatement.class);
        conn = mock(Connection.class);
        resSet = mock(ResultSet.class);
        when(prepStmt.getConnection()).thenReturn(conn);
        when(conn.prepareStatement(anyString())).thenReturn(prepStmt);
        when(resSet.getInt(anyString())).thenReturn(1);
        when(resSet.getString(anyString())).thenReturn("data");
        when(resSet.getBoolean(anyString())).thenReturn(false);
    }

    @Test
    public void testCreateObjectNotNull() throws SQLException {

        ArtifactDao instance = new ArtifactDao();
        artifact = instance.createObject(resSet);

        assertNotNull(artifact);
    }

    @Test
    public void testCreateObjectDefaultFields() throws SQLException {

        ArtifactDao instance = new ArtifactDao();
        artifact = instance.createObject(resSet);

        assertFalse(artifact.getIsGroup());
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

        String expected = "INSERT INTO artifacts (name, description, cost, isGroup)VALUES (?, ?, ?, ?)";
        assertEquals(expected, new ArtifactDao().getInsertationStatement());
    }
}