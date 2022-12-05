package online.flowerinsnow.xml.exception;

/**
 * 在XML非法操作时抛出
 */
public class XMLIllegalOperationException extends RuntimeException {
    public XMLIllegalOperationException() {
        super();
    }

    public XMLIllegalOperationException(String message) {
        super(message);
    }

    public XMLIllegalOperationException(String message, Throwable cause) {
        super(message, cause);
    }

    public XMLIllegalOperationException(Throwable cause) {
        super(cause);
    }
}
