package test.fyodorov.informationhandling.interpretator;

import by.fyodorov.informationhandling.interpretator.Context;
import by.fyodorov.informationhandling.interpretator.PolishParser;
import by.fyodorov.informationhandling.interpretator.StaticArguments;
import org.testng.Assert;
import org.testng.annotations.Test;

public class ContextTest {

    @Test
    public void testEvaluate() throws Exception {
        final String EXPRESSION = "123-(23+3)+ ++j +4";
        final int EXPECTED = 109;
        Context context = new Context();
        PolishParser polishParser = new PolishParser();
        StaticArguments.getInstance().initialize(2,7);
        String polish = polishParser.toPolish(EXPRESSION);

        Assert.assertEquals(context.evaluate(polish).interpret(), EXPECTED);
    }

    @Test
    public void testBase() throws Exception {
        final String EXPRESSION = "2+4";
        final int EXPECTED = 6;
        Context context = new Context();
        PolishParser polishParser = new PolishParser();
        String polish = polishParser.toPolish(EXPRESSION);
        Assert.assertEquals(context.evaluate(polish).interpret(), EXPECTED);
    }

    @Test
    public void testPrefixEvaluate() throws Exception {
        final String EXPRESSION = "1+ ++j -2+ ++j -1";
        final int EXPECTED = 3;
        Context context = new Context();
        PolishParser polishParser = new PolishParser();
        StaticArguments.getInstance().initialize(1,1);
        String polish = polishParser.toPolish(EXPRESSION);

        Assert.assertEquals(context.evaluate(polish).interpret(), EXPECTED);
    }

    @Test
    public void testPostfixEvaluate() throws Exception {
        final String EXPRESSION = " j++ + j++ ";
        final int EXPECTED = 3;
        Context context = new Context();
        PolishParser polishParser = new PolishParser();
        StaticArguments.getInstance().initialize(1,1);
        String polish = polishParser.toPolish(EXPRESSION);

        Assert.assertEquals(context.evaluate(polish).interpret(), EXPECTED);
    }
}