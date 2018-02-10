package by.fyodorov.informationhandling.exception;

public class TextException extends Exception {

    public TextException(String message) {
        super(message);
    }

    public TextException(String message, Exception e) {
        super(message, e);
    }
}
