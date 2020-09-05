package com.mercell.bowling;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

class TotalScoreCalculatorTest {

    @Test
    void givenASequenceWithNoSpareAndNoStrike_whenCalculate_thenReturnTheCorrectSum() {
        List<FrameScore> frameScores = new ArrayList<FrameScore>() {{
                add(new FrameScore(1, 1));
                add(new FrameScore(2, 2));
                add(new FrameScore(3, 3));
        }};
        TotalScoreCalculator totalScoreCalculator = new TotalScoreCalculator(frameScores);

        assertEquals(12, totalScoreCalculator.calculate());
    }

    @Test
    void givenASequenceWithOneSpareAndNoStrike_whenCalculate_thenReturnTheCorrectSum() {
        List<FrameScore> frameScores = new ArrayList<FrameScore>() {{
            add(new FrameScore(1, 1));
            add(new FrameScore(8, 2));
            add(new FrameScore(3, 3));
        }};
        TotalScoreCalculator totalScoreCalculator = new TotalScoreCalculator(frameScores);

        assertEquals(2 + 13 + 6, totalScoreCalculator.calculate());
    }

    @Test
    void givenASequenceWithOneSpareAndOneStrike_whenCalculate_thenReturnTheCorrectSum() {
        List<FrameScore> frameScores = new ArrayList<FrameScore>() {{
            add(new FrameScore(10));
            add(new FrameScore(8, 2));
            add(new FrameScore(3, 3));
        }};
        TotalScoreCalculator totalScoreCalculator = new TotalScoreCalculator(frameScores);

        assertEquals(20 + 13 + 6, totalScoreCalculator.calculate());
    }

    @Test
    void givenASequenceWithOneSpareAtTheLastShot_whenCalculate_thenReturnTheCorrectSum() {
        List<FrameScore> frameScores = new ArrayList<FrameScore>() {{
            add(new FrameScore(1, 1));
            add(new FrameScore(2, 2));
            add(new FrameScore(8, 2, 5));
        }};
        TotalScoreCalculator totalScoreCalculator = new TotalScoreCalculator(frameScores);

        assertEquals(2 + 4 + 15, totalScoreCalculator.calculate());
    }

    @Test
    void givenASequenceWithOneStrikeAtTheLastShot_whenCalculate_thenReturnTheCorrectSum() {
        List<FrameScore> frameScores = new ArrayList<FrameScore>() {{
            add(new FrameScore(1, 1));
            add(new FrameScore(2, 2));
            add(new FrameScore(10, -1, 5, 6));
        }};
        TotalScoreCalculator totalScoreCalculator = new TotalScoreCalculator(frameScores);

        assertEquals(2 + 4 + 21, totalScoreCalculator.calculate());
    }

    @Test
    void givenASequenceWith10ShotsProvidedByTaskDescription_whenCalculate_thenReturnTheCorrectSum() {
        List<FrameScore> frameScores = new ArrayList<FrameScore>() {{
            add(new FrameScore(0, 3));
            add(new FrameScore(5, 0));
            add(new FrameScore(9, 1));
            add(new FrameScore(2, 5));
            add(new FrameScore(3, 2));
            add(new FrameScore(4, 2));
            add(new FrameScore(3, 3));
            add(new FrameScore(4, 6));
            add(new FrameScore(10));
            add(new FrameScore(10, -1, 2, 5));
        }};
        TotalScoreCalculator totalScoreCalculator = new TotalScoreCalculator(frameScores);

        assertEquals(103, totalScoreCalculator.calculate());
    }

    @Test
    void givenASequenceWith10ShotsProvidedBySecondExampleInTaskDescription_whenCalculate_thenReturnTheCorrectSum() {
        List<FrameScore> frameScores = new ArrayList<FrameScore>() {{
            add(new FrameScore(7,1));
            add(new FrameScore(5, 5));
            add(new FrameScore(2, 7));
            add(new FrameScore(4, 6));
            add(new FrameScore(0, 5));
            add(new FrameScore(8, 2));
            add(new FrameScore(8, 1));
            add(new FrameScore(4, 3));
            add(new FrameScore(2, 4));
            add(new FrameScore(5, 2));
        }};
        TotalScoreCalculator totalScoreCalculator = new TotalScoreCalculator(frameScores);

        assertEquals(91, totalScoreCalculator.calculate());
    }

    @Test
    void givenASequenceWith10ShotsWith3StrikesShotAtTheLast3Turns_whenCalculate_thenReturnTheCorrectSum() {
        List<FrameScore> frameScores = new ArrayList<FrameScore>() {{
            add(new FrameScore(5, 0));
            add(new FrameScore(5, 0));
            add(new FrameScore(5, 0));
            add(new FrameScore(5, 0));
            add(new FrameScore(4, 0));
            add(new FrameScore(8, 2));
            add(new FrameScore(0, 6));
            add(new FrameScore(10));
            add(new FrameScore(10));
            add(new FrameScore(10, -1, 8, 1));
        }};
        TotalScoreCalculator totalScoreCalculator = new TotalScoreCalculator(frameScores);

        assertEquals(117, totalScoreCalculator.calculate());
    }
}