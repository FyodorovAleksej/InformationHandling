package by.fyodorov.informationhandling.parser;

import by.fyodorov.informationhandling.composite.CompositeType;
import by.fyodorov.informationhandling.composite.Compositely;
import by.fyodorov.informationhandling.composite.TextCompositeComponent;
import by.fyodorov.informationhandling.exception.TextException;
import by.fyodorov.informationhandling.interpretator.Context;
import by.fyodorov.informationhandling.interpretator.PolishParser;

import java.util.LinkedList;

/**
 * class for parsing sentences
 */
public class SentenceParserHandler extends BaseParserHandler {
    private static final String LEXEME_EXPRESSION = ".+?(\\s|\\.|\\!|\\?|\\,){1}";
    private static final String MATH_EXPRESSION = "[0-9()+\\-*/.]+(\\s|\\.|!|\\?)";
    private static final String EXECUTE_EXPRESSION = "(([ij][+\\-]{2})|([\\-+]{2}[ij]))(\\s|\\.|!|\\?)";

    /**
     * parse current part of text to node of Composite tree
     * @param part part of text for current parsing
     * @return created node of Composite tree
     * @throws TextException in case, when in lexeme expression was invalid
     */
    @Override
    public Compositely parse(String part) throws TextException {
        Compositely sentenceRoot = new TextCompositeComponent(CompositeType.SENTENCE);
        LinkedList<String> lexemes = super.parseRegular(part, LEXEME_EXPRESSION);
        LinkedList<String> expressionParts = new LinkedList<>();
        if (next != null) {
            String end = "";
            for (String lexeme : lexemes) {
                if (lexeme.matches(MATH_EXPRESSION)) {
                    end = lexeme.substring(lexeme.length() - 1, lexeme.length());
                    expressionParts.add(lexeme.substring(0, lexeme.length() - 1));
                } else {
                    if (lexeme.matches(EXECUTE_EXPRESSION)) {
                        expressionParts.add(" " + lexeme);
                    } else {
                        if (!expressionParts.isEmpty()) {
                            StringBuilder builder = new StringBuilder();
                            for (String expression : expressionParts) {
                                builder.append(expression);
                            }
                            PolishParser polishParser = new PolishParser();
                            Context context = new Context();
                            sentenceRoot.addChild(next.parse(String.valueOf(context.evaluate(polishParser.toPolish(builder.toString())).interpret()) + end));
                            expressionParts.clear();
                        }
                        sentenceRoot.addChild(next.parse(lexeme));
                    }
                }
            }
        }
        return sentenceRoot;
    }
}
