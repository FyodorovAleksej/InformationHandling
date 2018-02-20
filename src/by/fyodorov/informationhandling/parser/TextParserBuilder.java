package by.fyodorov.informationhandling.parser;

public class TextParserBuilder {

    public ParserHandler getStandartTextParser() {
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
