package test.fyodorov.informationhandling.reader;

import by.fyodorov.informationhandling.exception.TextException;
import by.fyodorov.informationhandling.reader.TextReader;
import org.testng.Assert;
import org.testng.annotations.Test;

public class TextReaderTest {

    @Test
    public void testReadPositive() throws Exception {
        final String PATH = "input/text.txt";
        TextReader reader = new TextReader();
        String text = reader.readText(PATH);
        Assert.assertEquals(text, "NO\nTO\nASSERT\n");
    }

    @Test(expectedExceptions = TextException.class)
    public void testReadNegative() throws Exception {
        final String PATH = "input/IN.txt";
        TextReader reader = new TextReader();
        String text = reader.readText(PATH);
        Assert.fail("file wasn't exist");
    }
}
