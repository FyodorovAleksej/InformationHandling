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
        Compositely compositable = parser.parse("    It has survived - not only (five) centuries, but also the leap into 13+ i--\n" +
                "electronic typesetting, remaining 3+5 essentially 6+9*(3-4) unchanged. It was\n" +
                "popularised in the 5*(1*2*(3*(4*(5- --j + 4)-3)-2)-1) with the release of Letraset sheets\n" +
                "containing Lorem Ipsum passages, and more recently with desktop publishing software\n" +
                "like Aldus PageMaker including versions of Lorem Ipsum.\n" +
                "    It is a long established fact that a reader will be distracted by the readable\n" +
                "content of a page when looking at its layout. The point of using (71-(2*i--*(3*(2-1/2*2)-\n" +
                "2)-10/2))*++i Ipsum is that it has a more-or-less normal distribution of letters, as\n" +
                "opposed to using (Content here), content here', making it look like readable English.\n" +
                "    It is a (-5+1/2*(2+5*2- --j))*1200 established fact that a reader will be of a page\n" +
                "when looking at its layout.\n" +
                "    Bye.");
        outComp(compositable);
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

    @Test
    public void regularTest() throws Exception {
        final String POSTFIKS_EXPRESSION = "\\s[ij][+\\-]{2}\\s";
        final String PREFIKS_EXPRESSION = "\\s[\\-+]{2}[ij]\\s";
        final String ARIPMETIC_EXPRESSION = "(" + POSTFIKS_EXPRESSION + ")|(" + PREFIKS_EXPRESSION + ")";

        String prefiks_i_plus = " ++i ";
        String prefiks_i_minus = " --i ";

        String postfiks_i_plus = " i++ ";
        String postfiks_i_minus = " i-- ";

        String prefiks_j_plus = " ++j ";
        String prefiks_j_minus = " --j ";

        String postfiks_j_plus = " j++ ";
        String postfiks_j_minus = " j-- ";


        Assert.assertTrue(prefiks_i_minus.matches(PREFIKS_EXPRESSION));
        Assert.assertTrue(prefiks_i_plus.matches(PREFIKS_EXPRESSION));

        Assert.assertTrue(prefiks_j_minus.matches(PREFIKS_EXPRESSION));
        Assert.assertTrue(prefiks_j_plus.matches(PREFIKS_EXPRESSION));

        Assert.assertTrue(postfiks_i_minus.matches(POSTFIKS_EXPRESSION));
        Assert.assertTrue(postfiks_i_plus.matches(POSTFIKS_EXPRESSION));

        Assert.assertTrue(postfiks_j_minus.matches(POSTFIKS_EXPRESSION));
        Assert.assertTrue(postfiks_j_plus.matches(POSTFIKS_EXPRESSION));




        Assert.assertFalse(prefiks_i_minus.matches(POSTFIKS_EXPRESSION));
        Assert.assertFalse(postfiks_i_minus.matches(PREFIKS_EXPRESSION));




        Assert.assertTrue(prefiks_i_minus.matches(ARIPMETIC_EXPRESSION));
        Assert.assertTrue(prefiks_i_plus.matches(ARIPMETIC_EXPRESSION));
        Assert.assertTrue(prefiks_j_minus.matches(ARIPMETIC_EXPRESSION));
        Assert.assertTrue(prefiks_j_plus.matches(ARIPMETIC_EXPRESSION));
        Assert.assertTrue(postfiks_i_minus.matches(ARIPMETIC_EXPRESSION));
        Assert.assertTrue(postfiks_i_plus.matches(ARIPMETIC_EXPRESSION));
        Assert.assertTrue(postfiks_j_minus.matches(ARIPMETIC_EXPRESSION));
        Assert.assertTrue(postfiks_j_plus.matches(ARIPMETIC_EXPRESSION));


        Assert.assertFalse(" k++ ".matches(ARIPMETIC_EXPRESSION));
        Assert.assertFalse(" i** ".matches(ARIPMETIC_EXPRESSION));
        Assert.assertFalse(" i+ ".matches(ARIPMETIC_EXPRESSION));
    }

    private void outComp(Compositely comp) {
        System.out.println(comp);
    }
}