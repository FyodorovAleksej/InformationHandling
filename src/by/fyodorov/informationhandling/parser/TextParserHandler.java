package by.fyodorov.informationhandling.parser;

import by.fyodorov.informationhandling.composite.Compositely;
import by.fyodorov.informationhandling.composite.TextCompositeComponent;
import by.fyodorov.informationhandling.exception.TextException;

import java.util.LinkedList;

public class TextParserHandler extends BaseParserHandler {
    private static final String PARAGRAPH_EXPRESSION = "(\\t)|(\\s{4}).+(\\n|$)";

    @Override
    public Compositely parse(String part) throws TextException {
        Compositely textRoot = new TextCompositeComponent();
        LinkedList<String> paragraphs = super.parseRegular(part, PARAGRAPH_EXPRESSION);
        if (next != null) {
            for (String paragraph : paragraphs) {
                textRoot.addChild(next.parse("\t" + paragraph));
            }
        }
        return textRoot;
    }
}
