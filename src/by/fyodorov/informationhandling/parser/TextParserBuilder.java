package by.fyodorov.informationhandling.parser;

/**
 * class for getting standard hierarchy of parsers
 */
public class TextParserBuilder {

    /**
     * getting standard hierarchy
     * @return root of hierarchy of parsers
     */
    public ParserHandler getStandardTextParser() {
        ParserHandler textHandler = new TextParserHandler();
        ParserHandler paragraphHandler = new ParagraphParserHandler();
        ParserHandler sentenceHandler = new SentenceParserHandler();
        ParserHandler lexemeHandler = new LexemeParserHandler();

        textHandler.setNext(paragraphHandler);
        paragraphHandler.setNext(sentenceHandler);
        sentenceHandler.setNext(lexemeHandler);
        lexemeHandler.setNext(null);

        return textHandler;
    }
}
