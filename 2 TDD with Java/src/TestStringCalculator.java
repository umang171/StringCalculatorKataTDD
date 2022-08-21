package src;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

public class TestStringCalculator {
    @Test
    public void testNumberIsEmptySpace() {
        assertEquals(0, StringCalculator.add(" "));
    }

    @Test
    public void testStringHasOneNumber() {
        assertEquals(2, StringCalculator.add("2"));
    }

    @Test
    public void testStringHasTwoNumber() {
        assertEquals(3, StringCalculator.add("1,2"));
    }

    @Test
    public void testStringHasUnknownNumbers() {
        assertEquals(6, StringCalculator.add("1,2,3"));
    }
}