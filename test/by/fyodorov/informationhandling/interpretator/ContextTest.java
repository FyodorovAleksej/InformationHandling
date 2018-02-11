package by.fyodorov.informationhandling.interpretator;

import org.testng.annotations.Test;

public class ContextTest {

    @Test
    public void testEvaluate() throws Exception {
        final String EXPRESSION = "123-23+3+4";
        Context context = new Context();
        System.out.println(context.evaluate(EXPRESSION).interpret());
    }
}