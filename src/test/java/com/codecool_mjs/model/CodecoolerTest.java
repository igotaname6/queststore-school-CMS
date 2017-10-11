package com.codecool_mjs.model;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

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

//    @Test
//    public void testCodecoolerParametrizedConstructor2() {
//        Codecooler codecooler = new Codecooler();
//        assertNull(codecooler.getWallet());
//    }

    @Test
    public void testCodecoolerSetGetID() {
        Codecooler codecooler = new Codecooler();
        codecooler.setGroupId(1);
        assertEquals(1, (int)codecooler.getGroupId());
    }

}