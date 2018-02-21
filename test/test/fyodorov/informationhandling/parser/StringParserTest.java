package test.fyodorov.informationhandling.parser;

import by.fyodorov.informationhandling.composite.Compositely;
import by.fyodorov.informationhandling.interpretator.StaticArguments;
import by.fyodorov.informationhandling.parser.*;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class StringParserTest {

    @BeforeMethod
    public void setUp() throws Exception {
        StaticArguments.getInstance().initialize(0,0);
    }

    @AfterMethod
    public void tearDown() throws Exception {
    }

    @Test
    public void testParseLexeme() throws Exception {
        final String LEXEME = "about ";
        ParserHandler lexemeHandler = new LexemeParserHandler();
        lexemeHandler.setNext(null);
        Assert.assertEquals(lexemeHandler.parse(LEXEME).toString(), LEXEME);
    }

    @Test
    public void testParseSentence() throws Exception {
        final String SENTENCE = "About this everybody want to talk.";
        ParserHandler lexemeHandler = new LexemeParserHandler();
        lexemeHandler.setNext(null);

        ParserHandler sentenceHandler = new SentenceParserHandler();
        sentenceHandler.setNext(lexemeHandler);

        Assert.assertEquals(sentenceHandler.parse(SENTENCE).toString(), SENTENCE);
    }

    @Test
    public void testParseSentenceExecute() throws Exception {
        final String SENTENCE = "About this everybody want 1+23+56-(1+56)+2 to talk.";
        ParserHandler lexemeHandler = new LexemeParserHandler();
        lexemeHandler.setNext(null);

        ParserHandler sentenceHandler = new SentenceParserHandler();
        sentenceHandler.setNext(lexemeHandler);

        Assert.assertEquals(sentenceHandler.parse(SENTENCE).toString(), "About this everybody want 25 to talk.");
    }

    @Test
    public void testParseParagraph() throws Exception {
        final String PARAGRAPH = "About this everybody want to talk. Is this good. Bye.";

        ParserHandler lexemeHandler = new LexemeParserHandler();
        lexemeHandler.setNext(null);

        ParserHandler sentenceHandler = new SentenceParserHandler();
        sentenceHandler.setNext(lexemeHandler);

        ParserHandler paragraphHandler = new ParagraphParserHandler();
        paragraphHandler.setNext(sentenceHandler);

        Assert.assertEquals(paragraphHandler.parse(PARAGRAPH).toString(), "About this everybody want to talk.Is this good.Bye.");
    }

    @Test
    public void testParseParagraphExecute() throws Exception {
        final String PARAGRAPH = "About this 1+23+56-(1+5) everybody want 23+56 to talk. Is 2-53+ j++ -2 this good. Bye.";
        ParserHandler lexemeHandler = new LexemeParserHandler();
        lexemeHandler.setNext(null);

        ParserHandler sentenceHandler = new SentenceParserHandler();
        sentenceHandler.setNext(lexemeHandler);

        ParserHandler paragraphHandler = new ParagraphParserHandler();
        paragraphHandler.setNext(sentenceHandler);

        Assert.assertEquals(paragraphHandler.parse(PARAGRAPH).toString(), "About this 74 everybody want 79 to talk.Is -53 this good.Bye.");
    }

    @Test
    public void testParseAll() throws Exception {
        TextParserBuilder builder = new TextParserBuilder();
        ParserHandler handler = builder.getStandartTextParser();
        final String TEXT = "    It has survived not only (five) centuries, but also the leap into 13+ i-- " +
                "electronic typesetting, remaining 3+5 essentially 6+9*(3-4) unchanged. It was " +
                "popularised in the 5*(1*2*(3*(4*(5- --j + 4)-3)-2)-1) with the release of Letraset sheets " +
                "containing Lorem Ipsum passages, and more recently with desktop publishing software" +
                "like Aldus PageMaker including versions of Lorem Ipsum.\n" +
                "    It is a long established fact that a reader will be distracted by the readable" +
                "content of a page when looking at its layout. The point of using (71-(2* i-- *(3*(2-1/2*2)-" +
                "2)-10/2))* ++i  Ipsum is that it has a more-or-less normal distribution of letters, as" +
                "opposed to using (Content here), content here', making it look like readable English.\n" +
                "    It is a (-5+1/2*(2+5*2- --j ))*1200 established fact that a reader will be of a page" +
                "when looking at its layout.\n" +
                "    Bye.";
        Compositely compositable = handler.parse(TEXT);
        Assert.assertEquals(compositable.toString(), "It has survived not only (five) centuries, but also the leap into 13 electronic typesetting, remaining 8 essentially -3 unchanged.It was popularised in the 1085 with the release of Letraset sheets containing Lorem Ipsum passages, and more recently with desktop publishing softwarelike Aldus PageMaker including versions of Lorem Ipsum.It is a long established fact that a reader will be distracted by the readablecontent of a page when looking at its layout.The point of using -84  Ipsum is that it has a more-or-less normal distribution of letters, asopposed to using (Content here), content here', making it look like readable English.It is a -6000 established fact that a reader will be of a pagewhen looking at its layout.Bye.");
    }
}