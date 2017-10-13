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
        assertNull(emptyCodecooler.getWallet(),
                "Empty constructor does not set all fields to null.");
    }

    @Test
    void testCodecoolerParametrizedConstructor() {
        assertNotNull(parametrizedCodecooler.getId(),
                "Parametrized construcor sets fields to null.");
    }

    @Test
    void testCodecoolerParametrizedConstructor2() {
        assertNotNull(parametrizedCodecooler2.getId(),
                "Parametrized construcor sets fields to null.");
    }

    @Test
    void testCodecoolerSetGetID() {
        emptyCodecooler.setGroupId(1);
        assertEquals(1, (int)emptyCodecooler.getGroupId(),
                "Method sets field to an incorrect value.");
    }

    @Test
    void testCodecoolerSetIDToNegative() {
        assertThrows(IllegalArgumentException.class, () -> {
           emptyCodecooler.setGroupId(-1);
        }, "Id can be set to a negative value.");
    }

    @Test
    void testCodecoolerSetGetWallet() {
        emptyCodecooler.setWallet(mockedWallet);
        assertNotNull(emptyCodecooler.getWallet(),
                "Method sets field to an incorrect value.");
    }
}