package com.mercell.bowling;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class FrameScoreTest {

    private FrameScore frameScore;

    @BeforeEach
    void setUp() {
        frameScore = new FrameScore();
    }

    @Test
    void bothScoresForAnEmptyFrameScoreObjectMustBeMinesOne() {
        assertEquals(-1, frameScore.getFirstScore());
        assertEquals(-1, frameScore.getSecondScore());
    }

    @Test
    void isStrikeMustOnlyReturnsTrueIfTheFirstScoreIs10() {
        FrameScore strikeFrameScore = new FrameScore(10);
        assertTrue(strikeFrameScore.isStrike(), "A shot with the first score equals to 10 is a Strike.");

        FrameScore notStrike = new FrameScore(5, 4);
        assertFalse(notStrike.isStrike(), "If the first score is not 10, then this shot is not Strike.");

        FrameScore invalidScore = new FrameScore(10, 2);
        assertFalse(invalidScore.isStrike(), "If the first shot is 10, then the score for the second value must be -1");

    }

    @Test
    void givenAFrameSquareWithSum10_whenIsSpare_thenReturnTrue() {
        FrameScore strikeFrameScore = new FrameScore(1, 9);
        assertTrue(strikeFrameScore.isSpare());
    }

    @Test
    void givenAFrameSquareWithSumNot10_whenIsSpare_thenReturnFalse() {
        FrameScore strikeFrameScore = new FrameScore(1, 8);
        assertFalse(strikeFrameScore.isSpare());
    }

    @Test
    void givenAFrameSquareWhichIsAStrike_whenIsSpare_thenReturnFalse() {
        FrameScore strikeFrameScore = new FrameScore(10);
        assertFalse(strikeFrameScore.isSpare());
    }
}