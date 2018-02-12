package by.fyodorov.informationhandling.interpretator;

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
}