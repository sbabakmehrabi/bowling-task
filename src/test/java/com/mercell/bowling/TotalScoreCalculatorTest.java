package com.mercell.bowling;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.awt.*;
import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class TotalScoreCalculatorTest {

    @Test
    public void givenASequenceWithNoSpareAndNoStrike_whenCalculate_thenReturnTheCorrectSum() {
        List<FrameScore> frameScores = new ArrayList<FrameScore>() {{
                add(new FrameScore(1, 1));
                add(new FrameScore(2, 2));
                add(new FrameScore(3, 3));
        }};
        TotalScoreCalculator totalScoreCalculator = new TotalScoreCalculator(frameScores);

        assertEquals(12, totalScoreCalculator.calculate());
    }

    @Test
    public void givenASequenceWithOneSpareAndNoStrike_whenCalculate_thenReturnTheCorrectSum() {
        List<FrameScore> frameScores = new ArrayList<FrameScore>() {{
            add(new FrameScore(1, 1));
            add(new FrameScore(8, 2));
            add(new FrameScore(3, 3));
        }};
        TotalScoreCalculator totalScoreCalculator = new TotalScoreCalculator(frameScores);

        assertEquals(2 + 13 + 6, totalScoreCalculator.calculate());
    }

    @Test
    public void givenASequenceWithOneSpareAndOneStrike_whenCalculate_thenReturnTheCorrectSum() {
        List<FrameScore> frameScores = new ArrayList<FrameScore>() {{
            add(new FrameScore(10));
            add(new FrameScore(8, 2));
            add(new FrameScore(3, 3));
        }};
        TotalScoreCalculator totalScoreCalculator = new TotalScoreCalculator(frameScores);

        assertEquals(20 + 13 + 6, totalScoreCalculator.calculate());
    }

    @Test
    public void givenASequenceWithOneSpareAtTheLastShot_whenCalculate_thenReturnTheCorrectSum() {
        List<FrameScore> frameScores = new ArrayList<FrameScore>() {{
            add(new FrameScore(1, 1));
            add(new FrameScore(2, 2));
            add(new FrameScore(8, 2, 5));
        }};
        TotalScoreCalculator totalScoreCalculator = new TotalScoreCalculator(frameScores);

        assertEquals(2 + 4 + 15, totalScoreCalculator.calculate());
    }

    @Test
    public void givenASequenceWithOneStrikeAtTheLastShot_whenCalculate_thenReturnTheCorrectSum() {
        List<FrameScore> frameScores = new ArrayList<FrameScore>() {{
            add(new FrameScore(1, 1));
            add(new FrameScore(2, 2));
            add(new FrameScore(10, -1, 5, 6));
        }};
        TotalScoreCalculator totalScoreCalculator = new TotalScoreCalculator(frameScores);

        assertEquals(2 + 4 + 21, totalScoreCalculator.calculate());
    }
}