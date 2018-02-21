package test.fyodorov.informationhandling.interpretator;

import by.fyodorov.informationhandling.interpretator.PolishParser;
import org.testng.Assert;
import org.testng.annotations.Test;

import static org.testng.Assert.*;

public class PolishParserTest {

    @Test
    public void testToPolish() throws Exception {
        PolishParser parser = new PolishParser();
        final String TEST_EXPRESSION = "(514+23)*( --i +15)-7";
        Assert.assertEquals(parser.toPolish(TEST_EXPRESSION),"514 23 + --i 15 + * 7 - ");
    }

    @Test
    public void testToPolishBase() throws Exception {
        PolishParser parser = new PolishParser();
        final String TEST_EXPRESSION = "(23+(5+8*2)- j-- +1)/4";
        Assert.assertEquals(parser.toPolish(TEST_EXPRESSION),"23 5 8 2 * + + j-- - 1 + 4 / ");
    }

    @Test
    public void testToPolishArithmetic() throws Exception {
        PolishParser parser = new PolishParser();
        final String TEST_EXPRESSION = " j++ +2+ j++ ";
        Assert.assertEquals(parser.toPolish(TEST_EXPRESSION),"j++ 2 + j++ + ");
    }
}