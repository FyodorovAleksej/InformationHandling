package by.fyodorov.informationhandling.parser;

import by.fyodorov.informationhandling.composite.CompositeLeaf;
import by.fyodorov.informationhandling.composite.CompositeType;
import by.fyodorov.informationhandling.composite.Compositely;
import by.fyodorov.informationhandling.composite.TextCompositeComponent;

/**
 * class for parsing lexemes
 */
public class LexemeParserHandler extends BaseParserHandler {

    /**
     * parse current part of text to node of Composite tree
     * @param part part of text for current parsing
     * @return created node of Composite tree
     */
    @Override
    public Compositely parse(String part) {
        Compositely lexemeRoot = new TextCompositeComponent(CompositeType.LEXEME);
        for (int i = 0; i < part.length(); i++) {
            lexemeRoot.addChild(new CompositeLeaf(part.charAt(i)));
        }
        return lexemeRoot;
    }
}
