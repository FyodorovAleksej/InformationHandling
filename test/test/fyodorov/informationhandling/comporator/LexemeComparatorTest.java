package test.fyodorov.informationhandling.comporator;

import by.fyodorov.informationhandling.composite.Compositely;
import by.fyodorov.informationhandling.interpretator.StaticArguments;
import by.fyodorov.informationhandling.parser.ParserHandler;
import by.fyodorov.informationhandling.parser.TextParserBuilder;
import by.fyodorov.informationhandling.reader.TextReader;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class LexemeComparatorTest {
    private static final String INPUT = "input/lexeme/input.txt";
    private static final String EXPECTED = "input/lexeme/expected.txt";
    private static String text;
    private static String expected;

    @BeforeClass
    public void setUp() throws Exception {
        StaticArguments.getInstance().initialize(0,0);

        TextReader reader = new TextReader();
        text = reader.readText(INPUT);
        expected = reader.readText(EXPECTED);
    }

    @Test
    public void testLexemeSort() throws Exception {
        final char symbol = 's';

        TextParserBuilder builder = new TextParserBuilder();
        ParserHandler handler = builder.getStandardTextParser();
        Compositely compositable = handler.parse(text);
        compositable.sortLexemes(symbol);
        Assert.assertEquals(compositable.toString(), expected);

    }
}
