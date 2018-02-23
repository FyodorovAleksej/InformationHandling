package by.fyodorov.informationhandling.parser;

import by.fyodorov.informationhandling.composite.CompositeType;
import by.fyodorov.informationhandling.composite.Compositely;
import by.fyodorov.informationhandling.composite.TextCompositeComponent;
import by.fyodorov.informationhandling.exception.TextException;

import java.util.LinkedList;

/**
 * class for parsing paragraphs
 */
public class ParagraphParserHandler extends BaseParserHandler {
    private static final String SENTENCE_EXPRESSION = "[A-Z].*?[\\.\\?\\!]{1}";

    /**
     * parse current part of text to node of Composite tree
     * @param part part of text for current parsing
     * @return created node of Composite tree
     * @throws TextException in case, when in lexeme expression was invalid
     */
    @Override
    public Compositely parse(String part) throws TextException {
        Compositely paragraphRoot = new TextCompositeComponent(CompositeType.PARAGRAPH);
        LinkedList<String> sentences = super.parseRegular(part, SENTENCE_EXPRESSION);
        if (next != null) {
            for (String sentence : sentences) {
                paragraphRoot.addChild(next.parse(sentence));
            }
        }
        return paragraphRoot;
    }
}
