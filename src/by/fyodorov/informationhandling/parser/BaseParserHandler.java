package by.fyodorov.informationhandling.parser;

import by.fyodorov.informationhandling.composite.Compositely;
import by.fyodorov.informationhandling.exception.TextException;

import java.util.LinkedList;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * abstract class for all handlers
 */
public abstract class BaseParserHandler implements ParserHandler {
    ParserHandler next = null;

    /**
     * parse current part of text to node of Composite tree
     * @param part part of text for current parsing
     * @return created node of Composite tree
     * @throws TextException in case, when in lexeme expression was invalid
     */
    @Override
    public Compositely parse(String part) throws TextException {
        return null;
    }

    @Override
    public void setNext(ParserHandler handler) {
        next = handler;
    }

    /**
     * parsing input string by input expression to List
     * @param text string for parsing
     * @param expression regular expression for parsing
     * @return list of all matches in input string
     */
    public LinkedList<String> parseRegular(String text, String expression) {
        Pattern pattern = Pattern.compile(expression);
        Matcher matcher = pattern.matcher(text);
        LinkedList<String> list = new LinkedList<>();
        while(matcher.find()) {
            list.add(text.substring(matcher.start(), matcher.end()));
        }
        return list;
    }
}
