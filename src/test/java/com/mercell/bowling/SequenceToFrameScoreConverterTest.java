package com.mercell.bowling;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import org.junit.jupiter.api.Test;
import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

class SequenceToFrameScoreConverterTest {

    SequenceToFrameScoreConverter sequenceToFrameScoreConverter;

    @BeforeEach
    public void setUp() {
        sequenceToFrameScoreConverter = new SequenceToFrameScoreConverter();
    }

    @Test
    void givenAnArrayListOfScoresWithNoSpareAndNoStrike_whenConvert_thenReturnArrayOfFrameScores() {
        List<Integer> rawScores = Arrays.asList(1, 2, 3, 4, 5, 6);

        List<FrameScore> frameScores = sequenceToFrameScoreConverter.convert(rawScores);

        assertEquals(3, frameScores.size(), "The result must be an array with length 3");

        assertEquals(frameScores.get(0).getFirstScore(), 1);
        assertEquals(frameScores.get(0).getSecondScore(), 2);

        assertEquals(frameScores.get(1).getFirstScore(), 3);
        assertEquals(frameScores.get(1).getSecondScore(), 4);

        assertEquals(frameScores.get(2).getFirstScore(), 5);
        assertEquals(frameScores.get(2).getSecondScore(), 6);

    }

    @Test
    void givenAnArrayListOfScoresWithOneSpareAndNoStrike_whenConvert_thenReturnArrayOfFrameScores() {
        List<Integer> rawScores = Arrays.asList(1, 2, 5, 5, 5, 6);

        List<FrameScore> frameScores = sequenceToFrameScoreConverter.convert(rawScores);

        assertEquals(3, frameScores.size(), "The result must be an array with length 3");

        assertEquals(frameScores.get(0).getFirstScore(), 1);
        assertEquals(frameScores.get(0).getSecondScore(), 2);

        assertEquals(frameScores.get(1).getFirstScore(), 5);
        assertEquals(frameScores.get(1).getSecondScore(), 5);

        assertEquals(frameScores.get(2).getFirstScore(), 5);
        assertEquals(frameScores.get(2).getSecondScore(), 6);
    }

    @Test
    void givenAnArrayListOfScoresWithOneSpareAndOneStrike_whenConvert_thenReturnArrayOfFrameScores() {
        List<Integer> rawScores = Arrays.asList(5, 5, 10, 1, 2);

        List<FrameScore> frameScores = sequenceToFrameScoreConverter.convert(rawScores);

        assertEquals(3, frameScores.size(), "The result must be an array with length 3");

        assertEquals(frameScores.get(0).getFirstScore(), 5);
        assertEquals(frameScores.get(0).getSecondScore(), 5);

        assertEquals(frameScores.get(1).getFirstScore(), 10);
        assertEquals(frameScores.get(1).getSecondScore(), -1);

        assertEquals(frameScores.get(2).getFirstScore(), 1);
        assertEquals(frameScores.get(2).getSecondScore(), 2);
    }
}