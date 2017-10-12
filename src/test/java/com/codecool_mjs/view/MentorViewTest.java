package com.codecool_mjs.view;

import com.codecool_mjs.model.Mentor;
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

class MentorViewTest {

    private MentorView view = new MentorView();
    private PrintStream originalOutput;
    private OutputStream outputStream;
    private Mentor mockUser;

    @BeforeEach
    void setupOutput() {

        this.originalOutput = System.out;
        outputStream = new ByteArrayOutputStream();
        PrintStream ps = new PrintStream(outputStream);
        System.setOut(ps);
    }

    @BeforeEach
    void setupUser() {

        mockUser = mock(Mentor.class);
        when(mockUser.getId()).thenReturn(1);
        when(mockUser.getName()).thenReturn("testName");
        when(mockUser.getSurname()).thenReturn("testSurname");
        when(mockUser.getEmail()).thenReturn("testEmail");
    }

    @AfterEach
    void cleanOutput() {

        System.setOut(originalOutput);
    }

    @Test
    void testPrintList() {

        ArrayList<Mentor> testMentors = new ArrayList<>();
        testMentors.add(mockUser);
        testMentors.add(mockUser);

        MentorView.printAllMentors(testMentors);
        String expected = "1. testName testSurname || testEmail\n" +
                "1. testName testSurname || testEmail\n";

        assertEquals(expected, outputStream.toString(), "Missing whitespace");
    }

    @Test
    void testPrintEmptyList() {

        ArrayList<Mentor> testMentors = new ArrayList<>();

        MentorView.printAllMentors(testMentors);
        String expected = "No available data";

        assertEquals(expected, outputStream.toString(),
                "Missing information that there is no data to display");
    }

}