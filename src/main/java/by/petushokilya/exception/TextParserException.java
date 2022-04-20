package by.petushokilya.exception;

public class TextParserException extends Exception{
    public TextParserException(String message) {
        super(message);
    }

    public TextParserException(String message, Throwable cause) {
        super(message, cause);
    }

    public TextParserException(Throwable cause) {
        super(cause);
    }
}
