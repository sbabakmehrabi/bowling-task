package com.mercell.bowling;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.PrintStream;

import static org.junit.jupiter.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.assertEquals;

class MainTest {

    ByteArrayOutputStream redirectedStdOutput;

    @BeforeEach
    void setUp() {
        redirectedStdOutput = new ByteArrayOutputStream();
        System.setOut(new PrintStream(redirectedStdOutput));
    }

    @Test
    public void givenNoInput_whenMain_thenMustPrintAnErrorToStandardOutput() {
        Main.main(new String[]{});

        final String standardOutput = redirectedStdOutput.toString();
        assertTrue(standardOutput.contains("You must specify the file path of game score"));
    }

    @Test
    public void givenInInvalidFilePath_whenMain_thenWeMustSeeFileNotFoundInTheStdout() {
        Main.main(new String[]{"Not-found-file.txt"});

        final String standardOutput = redirectedStdOutput.toString();
        assertTrue(standardOutput.contains("The provided file was not found"));
    }
}