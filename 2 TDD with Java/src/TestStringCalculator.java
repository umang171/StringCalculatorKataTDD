package src;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertThrows;

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

    @Test
    public void testStringHasAlphabets() {
        assertEquals(6, StringCalculator.add("a,b,c"));
        assertEquals(10, StringCalculator.add("1,a,b,2,c,1"));
    }

    @Test
    public void testStringHasNegativeNumber() {
        // assertEquals("Negative not allowed", StringCalculator.add("-5"));
        Exception e = assertThrows(Exception.class, () -> StringCalculator.add("-1"));
        assertEquals(e.getMessage(), "Negative not allowed:-1");
    }
}