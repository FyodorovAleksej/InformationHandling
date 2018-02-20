package by.fyodorov.informationhandling.parser;

import by.fyodorov.informationhandling.composite.Compositely;
import by.fyodorov.informationhandling.composite.TextCompositeComponent;
import by.fyodorov.informationhandling.exception.TextException;

import java.util.LinkedList;

public class SentenceParserHandler extends BaseParserHandler {
    private static final String LEXEME_EXPRESSION = ".+?(\\s|\\.|\\!|\\?|\\,){1}";

    @Override
    public Compositely parse(String part) throws TextException {
        Compositely sentenceRoot = new TextCompositeComponent();
        LinkedList<String> lexemes = super.parseRegular(part, LEXEME_EXPRESSION);
        if (next != null) {
            for (String lexeme : lexemes) {
                sentenceRoot.addChild(next.parse(lexeme));
            }
        }
        return sentenceRoot;
    }
}
