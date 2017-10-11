package com.codecool_mjs.model;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.mock;

class CodecoolerTest {

    Codecooler emptyCodecooler;
    Codecooler parametrizedCodecooler;
    Wallet mockedWallet;

    @BeforeEach
    public void setup() {

        this.emptyCodecooler = new Codecooler();
        this.parametrizedCodecooler = new Codecooler(1, "test",
                                                     "test", "test",
                                                     "test", 1, mockedWallet);
        this.mockedWallet = mock(Wallet.class);
    }

    @Test
    public void testCodecoolerEmptyConstructor() {
        assertNull(emptyCodecooler.getWallet());
    }

    @Test
    public void testCodecoolerParametrizedConstructor() {
        assertNotNull(parametrizedCodecooler.getId());
    }

    @Test
    public void testCodecoolerSetGetID() {
        emptyCodecooler.setGroupId(1);
        assertEquals(1, (int)emptyCodecooler.getGroupId());
    }

    @Test
    public void testCodecoolerSetIDToNegative() {
        assertThrows(IllegalArgumentException.class, () -> {
           emptyCodecooler.setGroupId(-1);
        });
    }

    @Test
    public void testCodecoolerSetGetWallet() {
        emptyCodecooler.setWallet(mockedWallet);
        assertNotNull(emptyCodecooler.getWallet());
    }
}