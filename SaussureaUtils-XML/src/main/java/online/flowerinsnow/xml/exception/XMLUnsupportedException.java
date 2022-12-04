package online.flowerinsnow.xml.exception;

public class XMLUnsupportedException extends RuntimeException {
    public XMLUnsupportedException() {
        super();
    }

    public XMLUnsupportedException(String message) {
        super(message);
    }

    public XMLUnsupportedException(String message, Throwable cause) {
        super(message, cause);
    }

    public XMLUnsupportedException(Throwable cause) {
        super(cause);
    }
}
