package src;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

public class TestStringCalculator {
    @Test
    public void testNumberIsEmptySpace() {
        assertEquals(0, StringCalculator.add(" "));
    }

    @Test
    public void testNumberIsOfOneDigit() {
        assertEquals(2, StringCalculator.add("2"));
        assertEquals(30, StringCalculator.add("30"));
    }
}