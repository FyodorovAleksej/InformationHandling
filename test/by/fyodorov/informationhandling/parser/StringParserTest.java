package by.fyodorov.informationhandling.parser;

import by.fyodorov.informationhandling.composite.Compositely;
import by.fyodorov.informationhandling.composite.TextCompositeComponent;
import by.fyodorov.informationhandling.reader.TextReader;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.LinkedList;

public class StringParserTest {

    @BeforeMethod
    public void setUp() throws Exception {
    }

    @AfterMethod
    public void tearDown() throws Exception {
    }

    @Test
    public void testParse() throws Exception {
        StringParser parser = new StringParser();
        Compositely compositable = parser.parse("    It has survived - not only (five) centuries, but also the leap into 13+ i--" +
                "electronic typesetting, remaining 3+5 essentially 6+9*(3-4) unchanged. It was" +
                "popularised in the 5*(1*2*(3*(4*(5- --j + 4)-3)-2)-1) with the release of Letraset sheets" +
                "containing Lorem Ipsum passages, and more recently with desktop publishing software" +
                "like Aldus PageMaker including versions of Lorem Ipsum.\n" +
                "    It is a long established fact that a reader will be distracted by the readable" +
                "content of a page when looking at its layout. The point of using (71-(2*i--*(3*(2-1/2*2)-" +
                "2)-10/2))*++i Ipsum is that it has a more-or-less normal distribution of letters, as" +
                "opposed to using (Content here), content here', making it look like readable English.\n" +
                "    It is a (-5+1/2*(2+5*2- --j))*1200 established fact that a reader will be of a page" +
                "when looking at its layout.\n" +
                "    Bye.");
        System.out.println(compositable);
    }

    @Test
    public void testRead() throws Exception {
        TextReader reader = new TextReader();
        String text = reader.readText("./input/text.txt");
        System.out.println(text);
        StringParser parser = new StringParser();
        System.out.println("---------------------");
        System.out.println(parser.parse(text));
    }
}