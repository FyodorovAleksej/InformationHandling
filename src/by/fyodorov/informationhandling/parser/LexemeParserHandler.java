package by.fyodorov.informationhandling.parser;

import by.fyodorov.informationhandling.composite.CompositeLeaf;
import by.fyodorov.informationhandling.composite.Compositely;
import by.fyodorov.informationhandling.composite.TextCompositeComponent;
import by.fyodorov.informationhandling.exception.TextException;
import by.fyodorov.informationhandling.interpretator.Context;
import by.fyodorov.informationhandling.interpretator.PolishParser;

public class LexemeParserHandler extends BaseParserHandler {
    private static final String MATH_EXPRESSION = "[0-9()+\\-*/.]+(\\s|\\.|!|\\?)";

    @Override
    public Compositely parse(String part) throws TextException {
        if (part.matches(MATH_EXPRESSION)) {
            PolishParser polishParser = new PolishParser();
            String end = part.substring(part.length() - 1);
            part = String.valueOf(new Context().evaluate(polishParser.toPolish(part.substring(0, part.length() - 1))).interpret()) + end;
        }
        Compositely lexemeRoot = new TextCompositeComponent();
        for (int i = 0; i < part.length(); i++) {
            lexemeRoot.addChild(new CompositeLeaf(part.charAt(i)));
        }
        return lexemeRoot;
    }
}
