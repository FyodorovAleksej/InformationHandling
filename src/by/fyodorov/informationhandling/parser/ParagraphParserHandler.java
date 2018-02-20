package by.fyodorov.informationhandling.parser;

import by.fyodorov.informationhandling.composite.Compositely;
import by.fyodorov.informationhandling.composite.TextCompositeComponent;
import by.fyodorov.informationhandling.exception.TextException;

import java.util.LinkedList;

public class ParagraphParserHandler extends BaseParserHandler {
    private static final String SENTENCE_EXPRESSION = "[A-Z].*?[\\.\\?\\!]{1}";

    @Override
    public Compositely parse(String part) throws TextException {
        Compositely paragraphRoot = new TextCompositeComponent();
        LinkedList<String> sentences = super.parseRegular(part, SENTENCE_EXPRESSION);
        if (next != null) {
            for (String sentence : sentences) {
                paragraphRoot.addChild(next.parse(sentence));
            }
        }
        return paragraphRoot;
    }
}
