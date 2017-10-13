package com.codecool_mjs.view;

import com.codecool_mjs.model.Mentor;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

class MentorViewTest extends ViewTest {

    private MentorView view = new MentorView();
    private Mentor mockUser;

    @BeforeEach
    void setupUser() {

        mockUser = mock(Mentor.class);
        when(mockUser.getId()).thenReturn(1);
        when(mockUser.getName()).thenReturn("testName");
        when(mockUser.getSurname()).thenReturn("testSurname");
        when(mockUser.getEmail()).thenReturn("testEmail");
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