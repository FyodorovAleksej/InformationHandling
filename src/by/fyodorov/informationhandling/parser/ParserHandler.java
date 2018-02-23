package by.fyodorov.informationhandling.parser;

import by.fyodorov.informationhandling.composite.Compositely;
import by.fyodorov.informationhandling.exception.TextException;

/**
 * interface for all Handlers, used for parsing
 */
public interface ParserHandler {

    /**
     * parse current part of text to node of Composite tree
     * @param part part of text for current parsing
     * @return created node of Composite tree
     * @throws TextException in case, when in lexeme expression was invalid
     */
    Compositely parse(String part) throws TextException;

    /**
     * setting next node in Chain of Responsibility pattern
     * @param handler next handler
     */
    void setNext(ParserHandler handler);
}
