package com.mercell.bowling;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

class SequenceToFrameScoreConverterTest {

    SequenceToFrameScoreConverter sequenceToFrameScoreConverter;

    @BeforeEach
    void setUp() {
        sequenceToFrameScoreConverter = new SequenceToFrameScoreConverter();
    }

    @Test
    void givenAnArrayListOfScoresWithNoSpareAndNoStrike_whenConvert_thenReturnArrayOfFrameScores() {
        List<Integer> rawScores = Arrays.asList(1, 2, 3, 4, 5, 6);

        List<FrameScore> frameScores = sequenceToFrameScoreConverter.convert(rawScores);

        assertEquals(3, frameScores.size(), "The result must be an array with length 3");

        assertEquals(1, frameScores.get(0).getFirstScore());
        assertEquals(2, frameScores.get(0).getSecondScore());

        assertEquals(3, frameScores.get(1).getFirstScore());
        assertEquals(4, frameScores.get(1).getSecondScore());

        assertEquals(5, frameScores.get(2).getFirstScore());
        assertEquals(6, frameScores.get(2).getSecondScore());

    }

    @Test
    void givenAnArrayListOfScoresWithOneSpareAndNoStrike_whenConvert_thenReturnArrayOfFrameScores() {
        List<Integer> rawScores = Arrays.asList(1, 2, 5, 5, 5, 6);

        List<FrameScore> frameScores = sequenceToFrameScoreConverter.convert(rawScores);

        assertEquals(3, frameScores.size(), "The result must be an array with length 3");

        assertEquals(1, frameScores.get(0).getFirstScore());
        assertEquals(2, frameScores.get(0).getSecondScore());

        assertEquals(5, frameScores.get(1).getFirstScore());
        assertEquals(5, frameScores.get(1).getSecondScore());

        assertEquals(5, frameScores.get(2).getFirstScore());
        assertEquals(6, frameScores.get(2).getSecondScore());
    }

    @Test
    void givenAnArrayListOfScoresWithOneSpareAndOneStrike_whenConvert_thenReturnArrayOfFrameScores() {
        List<Integer> rawScores = Arrays.asList(
                10,
                1, 9,
                2, 0,
                3, 0,
                4, 0,
                5, 0,
                6, 0,
                7, 0,
                8, 0,
                9, 0
        );

        List<FrameScore> frameScores = sequenceToFrameScoreConverter.convert(rawScores);

        assertEquals(10, frameScores.size(), "The result must be an array with length 10");

        assertEquals(10, frameScores.get(0).getFirstScore(), "The first score of turn 1 must be 10");
        assertEquals(-1, frameScores.get(0).getSecondScore(), "The first score of turn 1 must be -1");
        assertEquals(-1, frameScores.get(0).getBonusPoint1(), "The first score of turn 1 must be -1");
        assertEquals(-1, frameScores.get(0).getBonusPoint2(), "The first score of turn 1 must be -1");

        assertEquals(1, frameScores.get(1).getFirstScore(), "The first score of turn 2 must be 1");
        assertEquals(9, frameScores.get(1).getSecondScore(), "The first score of turn 2 must be 9");
        assertEquals(-1, frameScores.get(1).getBonusPoint1(), "The first score of turn 2 must be -1");
        assertEquals(-1, frameScores.get(1).getBonusPoint2(), "The first score of turn 2 must be -1");

        for(int i=2 ; i < 10; i++) {
            assertEquals(i, frameScores.get(i).getFirstScore(),
                    "The first score of turn " + i + " must be " + i );
            assertEquals(0, frameScores.get(i).getSecondScore(),
                    "The second score of turn " + i + " must be 0");
            assertEquals(-1, frameScores.get(i).getBonusPoint1(),
                    "The bonus1 of turn " + i + " must be -1");
            assertEquals(-1, frameScores.get(i).getBonusPoint2(),
                    "The bonus2 of turn " + i + "  must be -1");
        }
    }

    @Test
    void givenAnArrayListOfScoresWithOneSpareAtTheLastShot_whenConvert_thenReturnArrayOfFrameScores() {
        List<Integer> rawScores = Arrays.asList(
                1, 0,
                2, 0,
                3, 0,
                4, 0,
                5, 0,
                6, 0,
                7, 0,
                8, 0,
                9, 0,
                9, 1, 5
        );

        List<FrameScore> frameScores = sequenceToFrameScoreConverter.convert(rawScores);

        assertEquals(10, frameScores.size(), "The result must be an array with length 10");

        for(int i=1 ; i < 10; i++) {
            assertEquals(i, frameScores.get(i - 1).getFirstScore(),
                    "The first score of turn " + i + " must be " + i );
            assertEquals(0, frameScores.get(i - 1).getSecondScore(),
                    "The second score of turn " + i + " must be 0");
            assertEquals(-1, frameScores.get(i - 1).getBonusPoint1(),
                    "The bonus1 of turn " + i + " must be -1");
            assertEquals(-1, frameScores.get(i - 1).getBonusPoint2(),
                    "The bonus2 of turn " + i + "  must be -1");
        }

        assertEquals(9, frameScores.get(9).getFirstScore(), "The first score for the last shot must be 9");
        assertEquals(1, frameScores.get(9).getSecondScore(), "The second score for the last shot must be 1");
        assertEquals(5, frameScores.get(9).getBonusPoint1(), "The bonus1 score for the last shot must be 5");
        assertEquals(-1, frameScores.get(9).getBonusPoint2(), "The bonus2 score for the last shot must be -1");
    }

    @Test
    void givenAnArrayListOfScoresWithOneStrikeAtTheLastShot_whenConvert_thenReturnArrayOfFrameScores() {
        List<Integer> rawScores = Arrays.asList(
                1, 0,
                2, 0,
                3, 0,
                4, 0,
                5, 0,
                6, 0,
                7, 0,
                8, 0,
                9, 0,
                10, 4, 5
        );

        List<FrameScore> frameScores = sequenceToFrameScoreConverter.convert(rawScores);

        assertEquals(10, frameScores.size(), "The result must be an array with length 10");

        for(int i=1 ; i < 10; i++) {
            assertEquals(i, frameScores.get(i - 1).getFirstScore(),
                    "The first score of turn " + i + " must be " + i );
            assertEquals(0, frameScores.get(i - 1).getSecondScore(),
                    "The second score of turn " + i + " must be 0");
            assertEquals(-1, frameScores.get(i - 1).getBonusPoint1(),
                    "The bonus1 of turn " + i + " must be -1");
            assertEquals(-1, frameScores.get(i - 1).getBonusPoint2(),
                    "The bonus2 of turn " + i + "  must be -1");
        }

        assertEquals(10, frameScores.get(9).getFirstScore(), "The first score for the last shot must be 10");
        assertEquals(-1, frameScores.get(9).getSecondScore(), "The second score for the last shot must be -1");
        assertEquals(4, frameScores.get(9).getBonusPoint1(), "The bonus1 score for the last shot must be 4");
        assertEquals(5, frameScores.get(9).getBonusPoint2(), "The bonus2 score for the last shot must be 5");
    }
}