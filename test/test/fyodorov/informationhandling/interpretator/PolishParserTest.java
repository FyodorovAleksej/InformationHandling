package test.fyodorov.informationhandling.interpretator;

import by.fyodorov.informationhandling.interpretator.PolishParser;
import org.testng.Assert;
import org.testng.annotations.Test;

public class PolishParserTest {

    @Test
    public void testToPolish() {
        PolishParser parser = new PolishParser();
        final String TEST_EXPRESSION = "(514+23)*( --i +15)-7";
        final String EXPECTED = "514 23 + --i 15 + * 7 - ";
        Assert.assertEquals(parser.toPolish(TEST_EXPRESSION),EXPECTED);
    }

    @Test
    public void testToPolishBase() {
        PolishParser parser = new PolishParser();
        final String TEST_EXPRESSION = "(23+(5+8*2)- j-- +1)/4";
        final String EXPECTED = "23 5 8 2 * + + j-- - 1 + 4 / ";
        Assert.assertEquals(parser.toPolish(TEST_EXPRESSION),EXPECTED);
    }

    @Test
    public void testToPolishArithmetic() {
        PolishParser parser = new PolishParser();
        final String TEST_EXPRESSION = " j++ +2+ j++ ";
        final String EXPECTED = "j++ 2 + j++ + ";
        Assert.assertEquals(parser.toPolish(TEST_EXPRESSION),EXPECTED);
    }
}