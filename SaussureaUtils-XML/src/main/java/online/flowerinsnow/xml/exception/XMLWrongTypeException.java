package online.flowerinsnow.xml.exception;

public class XMLWrongTypeException extends RuntimeException {
    public XMLWrongTypeException() {
        super();
    }

    public XMLWrongTypeException(String message) {
        super(message);
    }

    public XMLWrongTypeException(String message, Throwable cause) {
        super(message, cause);
    }

    public XMLWrongTypeException(Throwable cause) {
        super(cause);
    }
}
