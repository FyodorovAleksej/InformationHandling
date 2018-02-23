package test.fyodorov.informationhandling.comporator;

import by.fyodorov.informationhandling.composite.Compositely;
import by.fyodorov.informationhandling.interpretator.StaticArguments;
import by.fyodorov.informationhandling.parser.ParserHandler;
import by.fyodorov.informationhandling.parser.TextParserBuilder;
import by.fyodorov.informationhandling.reader.TextReader;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class ParagraphComparatorTest {
    private static final String INPUT = "input/paragraph/input.txt";
    private static final String EXPECTED = "input/paragraph/expected.txt";
    private static String text;
    private static String expected;


    @BeforeClass
    public void setUpClass() throws Exception {
        TextReader reader = new TextReader();
        text = reader.readText(INPUT);
        expected = reader.readText(EXPECTED);
    }

    @BeforeMethod
    public void setUpMethod() {
        StaticArguments.getInstance().initialize(0,0);
    }

    @Test
    public void testParagraphSort() throws Exception {
        TextParserBuilder builder = new TextParserBuilder();
        ParserHandler handler = builder.getStandardTextParser();
        Compositely compositable = handler.parse(text);
        compositable.sortParagraphs();
        Assert.assertEquals(compositable.toString(), expected);
    }


}
