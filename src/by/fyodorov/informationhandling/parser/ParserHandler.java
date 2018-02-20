package by.fyodorov.informationhandling.parser;

import by.fyodorov.informationhandling.composite.Compositely;
import by.fyodorov.informationhandling.exception.TextException;

import java.util.LinkedList;

public interface ParserHandler {
    Compositely parse(String part) throws TextException;
    void setNext(ParserHandler handler);
}
