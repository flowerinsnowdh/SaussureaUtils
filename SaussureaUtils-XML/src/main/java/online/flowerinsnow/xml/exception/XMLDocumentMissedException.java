package online.flowerinsnow.xml.exception;

public class XMLDocumentMissedException extends RuntimeException {
    public XMLDocumentMissedException() {
        super();
    }

    public XMLDocumentMissedException(String message) {
        super(message);
    }

    public XMLDocumentMissedException(String message, Throwable cause) {
        super(message, cause);
    }

    public XMLDocumentMissedException(Throwable cause) {
        super(cause);
    }
}
