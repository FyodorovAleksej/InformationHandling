package by.fyodorov.informationhandling.parser;

import by.fyodorov.informationhandling.composite.Compositely;
import by.fyodorov.informationhandling.composite.TextCompositeComponent;
import by.fyodorov.informationhandling.exception.TextException;
import by.fyodorov.informationhandling.interpretator.Context;
import by.fyodorov.informationhandling.interpretator.PolishParser;

import java.util.LinkedList;

public class SentenceParserHandler extends BaseParserHandler {
    private static final String LEXEME_EXPRESSION = ".+?(\\s|\\.|\\!|\\?|\\,){1}";
    private static final String MATH_EXPRESSION = "[0-9()+\\-*/.]+(\\s|\\.|!|\\?)";
    private static final String EXECUTE_EXPRESSION = "(([ij][+\\-]{2})|([\\-+]{2}[ij]))(\\s|\\.|!|\\?)";

    @Override
    public Compositely parse(String part) throws TextException {
        Compositely sentenceRoot = new TextCompositeComponent();
        LinkedList<String> lexemes = super.parseRegular(part, LEXEME_EXPRESSION);
        LinkedList<String> expessionParts = new LinkedList<String>();
        if (next != null) {
            String end = "";
            for (String lexeme : lexemes) {
                if (lexeme.matches(MATH_EXPRESSION)) {
                    end = lexeme.substring(lexeme.length() - 1, lexeme.length());
                    expessionParts.add(lexeme.substring(0, lexeme.length() - 1));
                } else {
                    if (lexeme.matches(EXECUTE_EXPRESSION)) {
                        expessionParts.add(" " + lexeme);
                    } else {
                        if (!expessionParts.isEmpty()) {
                            StringBuilder builder = new StringBuilder();
                            for (String expression : expessionParts) {
                                builder.append(expression);
                            }
                            PolishParser polishParser = new PolishParser();
                            Context context = new Context();
                            sentenceRoot.addChild(next.parse(String.valueOf(context.evaluate(polishParser.toPolish(builder.toString())).interpret()) + end));
                            expessionParts.clear();
                        }
                        sentenceRoot.addChild(next.parse(lexeme));
                    }
                }
            }
        }
        return sentenceRoot;
    }
}
