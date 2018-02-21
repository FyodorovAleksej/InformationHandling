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
        Context context = new Context();
        PolishParser polishParser = new PolishParser();
        StaticArguments.getInstance().initialize(2,7);
        String polish = polishParser.toPolish(EXPRESSION);

        Assert.assertEquals(context.evaluate(polish).interpret(), 109);
    }

    @Test
    public void testBase() throws Exception {
        final String EXPRESSION = "2+4";
        Context context = new Context();
        PolishParser polishParser = new PolishParser();
        String polish = polishParser.toPolish(EXPRESSION);
        Assert.assertEquals(context.evaluate(polish).interpret(), 6);
    }

    @Test
    public void testPrefixEvaluate() throws Exception {
        final String EXPRESSION = "1+ ++j -2+ ++j -1";
        Context context = new Context();
        PolishParser polishParser = new PolishParser();
        StaticArguments.getInstance().initialize(1,1);
        String polish = polishParser.toPolish(EXPRESSION);

        Assert.assertEquals(context.evaluate(polish).interpret(), 3);
    }

    @Test
    public void testPostfixEvaluate() throws Exception {
        final String EXPRESSION = " j++ + j++ ";
        Context context = new Context();
        PolishParser polishParser = new PolishParser();
        StaticArguments.getInstance().initialize(1,1);
        String polish = polishParser.toPolish(EXPRESSION);

        Assert.assertEquals(context.evaluate(polish).interpret(), 3);
    }
}