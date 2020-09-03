package com.mercell.bowling;

import org.junit.jupiter.api.Test;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class GameResultPrinterTest {

    @Test
    public void givenASequenceWith10ShotsProvidedByTaskDescription_whenCalculate_thenReturnTheCorrectSum() {
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

        final ByteArrayOutputStream myOut = new ByteArrayOutputStream();
        System.setOut(new PrintStream(myOut));

        GameResultPrinter gameResultPrinter = new GameResultPrinter(frameScores);
        gameResultPrinter.print();
        final String standardOutput = myOut.toString();

        assertEquals("| f1 | f2 | f3 | f4 | f5 | f6 | f7 | f8 | f9 | f10   |" + System.lineSeparator() +
                "|-, 3|5, -|9, /|2, 5|3, 2|4, 2|3, 3|4, /|X   |X, 2, 5|" + System.lineSeparator() +
                "score: 103", standardOutput);
    }

    @Test
    public void givenASequenceWith10ShotsProvidedByTheSecondTaskDescription_whenCalculate_thenReturnTheCorrectSum() {
        List<FrameScore> frameScores = new ArrayList<FrameScore>() {{
            add(new FrameScore(7, 1));
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

        final ByteArrayOutputStream myOut = new ByteArrayOutputStream();
        System.setOut(new PrintStream(myOut));

        GameResultPrinter gameResultPrinter = new GameResultPrinter(frameScores);
        gameResultPrinter.print();
        final String standardOutput = myOut.toString();

        assertEquals("| f1 | f2 | f3 | f4 | f5 | f6 | f7 | f8 | f9 | f10   |" + System.lineSeparator() +
                "|7, 1|5, /|2, 7|4, /|-, 5|8, /|8, 1|4, 3|2, 4|5, 2   |" + System.lineSeparator() +
                "score: 91", standardOutput);
    }
}
