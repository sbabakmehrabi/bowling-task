package com.mercell.bowling;

import org.junit.jupiter.api.Test;

import java.io.IOException;
import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class ScoreFileReaderTest {

    ScoreFileReader scoreFileReader;

    @Test
    public void givenANonExistingFile_whenReadFileAndExtractScores_thenReturnNull() throws IOException {
        scoreFileReader = new ScoreFileReader("not-existed-file.csv");

        Exception exception = assertThrows(IOException.class, () -> {
            scoreFileReader.readFileAndExtractTheScores();
        });

        assertTrue(exception.getMessage().contains("The system cannot find the file specified"));
    }

    @Test
    public void givenValidFile_whenReadFileAndExtractScores_thenReturnAValidArrayListContainingAllScores() throws IOException {
        List<Integer> scores = Arrays.asList(1, 2, 3, 4, 5, 6);

        scoreFileReader = new ScoreFileReader("src\\test\\java\\resources\\score-files-for-test.txt");

        assertArrayEquals(scores.toArray(), scoreFileReader.readFileAndExtractTheScores().toArray());
    }

}