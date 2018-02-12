package by.fyodorov.informationhandling.interpretator;

import org.testng.Assert;
import org.testng.annotations.Test;

import static org.testng.Assert.*;

public class PolishParserTest {

    @Test
    public void testToPolish() throws Exception {
        PolishParser parser = new PolishParser();
        final String TEST_EXPRESSION = "(514+23)*( --i +15)-7";
        Assert.assertEquals(parser.toPolish(TEST_EXPRESSION),"514 23 + i --i 15 + * 7 - ");
    }
}