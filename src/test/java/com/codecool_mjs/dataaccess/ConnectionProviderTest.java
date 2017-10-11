package com.codecool_mjs.dataaccess;

import org.junit.jupiter.api.Test;

import java.sql.Connection;

import static org.junit.jupiter.api.Assertions.*;

class ConnectionProviderTest {

    @Test
    public void testCreateConnection() {

        assertTrue(ConnectionProvider.getConnection() != null);
    }

}