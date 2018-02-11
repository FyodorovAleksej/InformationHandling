package by.fyodorov.informationhandling.interpretator;

import org.testng.annotations.Test;

import static org.testng.Assert.*;

public class PolishParserTest {

    @Test
    public void testToPolish() throws Exception {
        PolishParser parser = new PolishParser();
        System.out.println(parser.toPolish("(514+23)*(15+ --i +6)-7"));
    }
}