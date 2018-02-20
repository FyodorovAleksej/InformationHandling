package by.fyodorov.informationhandling.parser;

import by.fyodorov.informationhandling.composite.Compositely;
import by.fyodorov.informationhandling.exception.TextException;

import java.util.LinkedList;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public abstract class BaseParserHandler implements ParserHandler {
    ParserHandler next = null;

    @Override
    public Compositely parse(String part) throws TextException {
        return null;
    }

    @Override
    public void setNext(ParserHandler handler) {
        next = handler;
    }

    public LinkedList<String> parseRegular(String text, String expression) {
        Pattern pattern = Pattern.compile(expression);
        Matcher matcher = pattern.matcher(text);
        LinkedList<String> list = new LinkedList<String>();
        while(matcher.find()) {
            list.add(text.substring(matcher.start(), matcher.end()));
        }
        return list;
    }
}
