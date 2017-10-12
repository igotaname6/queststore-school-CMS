package com.codecool_mjs.model;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.mock;

class CodecoolerTest {

    private Codecooler emptyCodecooler;
    private Codecooler parametrizedCodecooler;
    private Codecooler parametrizedCodecooler2;
    private Wallet mockedWallet;

    @BeforeEach
    void setup() {

        this.emptyCodecooler = new Codecooler();
        this.parametrizedCodecooler = new Codecooler(1, "a", "b", "c",
                                                     "d", 1, mockedWallet);
        this.parametrizedCodecooler2 = new Codecooler(1, "a", "b", "c", "d");
        this.mockedWallet = mock(Wallet.class);
    }

    @Test
    void testCodecoolerEmptyConstructor() {
        assertNull(emptyCodecooler.getWallet());
    }

    @Test
    void testCodecoolerParametrizedConstructor() {
        assertNotNull(parametrizedCodecooler.getId());
    }

    @Test
    void testCodecoolerParametrizedConstructor2() {
        assertNotNull(parametrizedCodecooler2.getId());
    }

    @Test
    void testCodecoolerSetGetID() {
        emptyCodecooler.setGroupId(1);
        assertEquals(1, (int)emptyCodecooler.getGroupId());
    }

    @Test
    void testCodecoolerSetIDToNegative() {
        assertThrows(IllegalArgumentException.class, () -> {
           emptyCodecooler.setGroupId(-1);
        });
    }

    @Test
    void testCodecoolerSetGetWallet() {
        emptyCodecooler.setWallet(mockedWallet);
        assertNotNull(emptyCodecooler.getWallet());
    }
}