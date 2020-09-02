package com.mercell.bowling;

import org.junit.jupiter.api.Test;

import java.io.IOException;
import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;
import static org.junit.jupiter.api.Assertions.assertNull;

class ScoreFileReaderTest {

    ScoreFileReader scoreFileReader;

    @Test
    public void givenANonExistingFile_whenReadFileAndExtractScores_thenReturnNull() {
        scoreFileReader = new ScoreFileReader("not-existed-file.csv");

        List<Integer> scores = scoreFileReader.readFileAndExtractTheScores();

        assertNull(scores);
    }

    @Test
    public void givenValidFile_whenReadFileAndExtractScores_thenReturnAValidArrayListContainingAllScores() throws IOException {
        List<Integer> scores = Arrays.asList(1, 2, 3, 4, 5, 6);

        scoreFileReader = new ScoreFileReader("src\\test\\java\\resources\\score-files-for-test.txt");

        assertArrayEquals(scores.toArray(), scoreFileReader.readFileAndExtractTheScores().toArray());
    }

}