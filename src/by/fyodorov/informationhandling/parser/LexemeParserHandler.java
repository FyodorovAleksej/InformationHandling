package by.fyodorov.informationhandling.parser;

import by.fyodorov.informationhandling.composite.CompositeLeaf;
import by.fyodorov.informationhandling.composite.Compositely;
import by.fyodorov.informationhandling.composite.TextCompositeComponent;
import by.fyodorov.informationhandling.exception.TextException;

public class LexemeParserHandler extends BaseParserHandler {


    @Override
    public Compositely parse(String part) throws TextException {
        Compositely lexemeRoot = new TextCompositeComponent();
        for (int i = 0; i < part.length(); i++) {
            lexemeRoot.addChild(new CompositeLeaf(part.charAt(i)));
        }
        return lexemeRoot;
    }
}
