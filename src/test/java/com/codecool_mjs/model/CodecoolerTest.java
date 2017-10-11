package com.codecool_mjs.model;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

class CodecoolerTest {

    @Test
    public void testCodecoolerEmptyConstructor() {
        Codecooler codecooler = new Codecooler();
        assertNull(codecooler.getWallet());
    }

    @Test
    public void testCodecoolerParametrizedConstructor() {
        Codecooler codecooler = new Codecooler(1, "test", "test", "test", "test");
        assertNotNull(codecooler.getId());
    }

    @Test
    public void testCodecoolerParametrizedConstructor2() {
        Wallet mockedWallet = mock(Wallet.class);
        Codecooler codecooler = new Codecooler(1, "test",
                                               "test", "test",
                                               "test", 1,
                                               mockedWallet);
        assertNotNull(codecooler.getWallet());
    }

    @Test
    public void testCodecoolerSetGetID() {
        Codecooler codecooler = new Codecooler();
        codecooler.setGroupId(1);
        assertEquals(1, (int)codecooler.getGroupId());
    }

    @Test
    public void testCodecoolerSetGetWallet() {
        Wallet mockedWallet = mock(Wallet.class);
        Codecooler codecooler = new Codecooler();
        codecooler.setWallet(mockedWallet);
        assertNotNull(codecooler.getWallet());
    }
}