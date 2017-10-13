package com.codecool_mjs.view;

import com.codecool_mjs.model.Codecooler;
import com.codecool_mjs.model.User;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import java.io.ByteArrayOutputStream;
import java.io.OutputStream;
import java.io.PrintStream;
import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

class CodecoolerViewTest extends ViewTest {

    private CodecoolerView view = new CodecoolerView();
    private Codecooler mockUser;

    @BeforeEach
    void setupUser() {

        mockUser = mock(Codecooler.class);
        when(mockUser.getId()).thenReturn(1);
        when(mockUser.getName()).thenReturn("testName");
        when(mockUser.getSurname()).thenReturn("testSurname");
        when(mockUser.getEmail()).thenReturn("testEmail");
    }

    @Test
    void testPrintList() {

        ArrayList<Codecooler> testStudents = new ArrayList<>();
        testStudents.add(mockUser);
        testStudents.add(mockUser);

        CodecoolerView.printAllCodecoolers(testStudents);
        String expected = "1. testName testSurname || testEmail\n" +
                          "1. testName testSurname || testEmail\n";

        assertEquals(expected, outputStream.toString(), "Missing whitespace");
    }

    @Test
    void testPrintEmptyList() {

        ArrayList<Codecooler> testStudents = new ArrayList<>();

        CodecoolerView.printAllCodecoolers(testStudents);
        String expected = "No available data";

        assertEquals(expected, outputStream.toString(),
                "Missing information that there is no data to display");
    }
}