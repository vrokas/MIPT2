package com.example.mipt2;

import org.junit.Test;
import static org.junit.Assert.*;

public class CalculatorTest {

    private Calculator calculator = new Calculator();

    @Test
    public void testCountSentences() {
        String text = "Hello world. This is a test.";
        assertEquals(2, calculator.countSentences(text));
    }

    @Test
    public void testCountWords() {
        String text = "Hello world, this is a test.";
        assertEquals(6, calculator.countWords(text));
    }

    @Test
    public void testCountPunctuationMarks() {
        String text = "Hello, world.";
        assertEquals(2, calculator.countPunctuationMarks(text));
    }

    @Test
    public void testCountNumbers() {
        String text = "I have 2 cats and 15 dogs.";
        assertEquals(2, calculator.countNumbers(text));
    }

    @Test
    public void testEmptyString() {
        String text = "";
        assertEquals(0, calculator.countWords(text));
        assertEquals(0, calculator.countSentences(text));
        assertEquals(0, calculator.countNumbers(text));
        assertEquals(0, calculator.countPunctuationMarks(text));
    }
}
