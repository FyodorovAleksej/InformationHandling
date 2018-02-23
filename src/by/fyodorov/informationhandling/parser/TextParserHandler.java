package by.fyodorov.informationhandling.parser;

import by.fyodorov.informationhandling.composite.CompositeType;
import by.fyodorov.informationhandling.composite.Compositely;
import by.fyodorov.informationhandling.composite.TextCompositeComponent;
import by.fyodorov.informationhandling.exception.TextException;

import java.util.LinkedList;

/**
 * class for parsing full text
 */
public class TextParserHandler extends BaseParserHandler {
    private static final String PARAGRAPH_EXPRESSION = "(\\t)|(\\s{4}).+(\\n|$)";

    /**
     * parse current part of text to node of Composite tree
     * @param part part of text for current parsing
     * @return created node of Composite tree
     * @throws TextException in case, when in lexeme expression was invalid
     */
    @Override
    public Compositely parse(String part) throws TextException {
        Compositely textRoot = new TextCompositeComponent(CompositeType.TEXT);
        LinkedList<String> paragraphs = super.parseRegular(part, PARAGRAPH_EXPRESSION);
        if (next != null) {
            for (String paragraph : paragraphs) {
                textRoot.addChild(next.parse("\t" + paragraph));
            }
        }
        return textRoot;
    }
}
