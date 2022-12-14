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
        Exception e = assertThrows(Exception.class, () -> StringCalculator.add("-1"));
        assertEquals("Negative not allowed:-1", e.getMessage());
    }

    @Test
    public void testStringHasMultipleNegativeNumber() {
        Exception e = assertThrows(Exception.class, () -> StringCalculator.add("-1,3,-4,-2"));
        assertEquals("Negative not allowed:-1,-4,-2,", e.getMessage());
    }

    @Test
    public void testStringNumberIsBiggerThanThousand() {
        assertEquals(5, StringCalculator.add("1,2001,3,1001,1"));
    }

    @Test
    public void testNumberWithDifferentDelimiterNewLine() {
        assertEquals(6, StringCalculator.add("1\n2,3"));
    }

    @Test
    public void testNumberWithDifferentDelimiter() {
        assertEquals(6, StringCalculator.add("//;\n1;2;3"));
    }

    @Test
    public void testNumberWithOddIndicesSum() {
        assertEquals(4, StringCalculator.add("0//2,1,4,3"));
    }

    @Test
    public void testNumberWithEvenIndicesSum() {
        assertEquals(6, StringCalculator.add("1//1,2,5,3"));
    }

    @Test
    public void testNumberWithMulitpleLengthDelimiter() {
        assertEquals(6, StringCalculator.add("//;;;\n1;;;2;;;3"));
    }
}