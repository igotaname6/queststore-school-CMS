package com.codecool_mjs.view;

import org.junit.After;
import org.junit.Before;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;

import java.io.*;

abstract class ViewTest {

    PrintStream originalOutput;
    OutputStream outputStream;
    private InputStream stdin;

    @Before
    void setupInput(String data) {

        stdin = System.in;
        System.setIn(new ByteArrayInputStream(data.getBytes()));
    }

    @After
    void cleanInput() {

        System.setIn(stdin);
    }

    @BeforeEach
    void setupOutput() {

        this.originalOutput = System.out;
        outputStream = new ByteArrayOutputStream();
        PrintStream ps = new PrintStream(outputStream);
        System.setOut(ps);
    }

    @AfterEach
    void cleanOutput() {

        System.setOut(originalOutput);
    }

}
