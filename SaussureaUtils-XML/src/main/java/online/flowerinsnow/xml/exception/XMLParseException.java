package online.flowerinsnow.xml.exception;

public class XMLParseException extends RuntimeException {
    public XMLParseException() {
        super();
    }

    public XMLParseException(String message) {
        super(message);
    }

    public XMLParseException(String message, Throwable cause) {
        super(message, cause);
    }

    public XMLParseException(Throwable cause) {
        super(cause);
    }
}
