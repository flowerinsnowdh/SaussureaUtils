package online.flowerinsnow.saussureautils.exception;

/**
 * 不应该出现的异常
 * 一般不需要手动捕获
 * 只是为了应付Java语法
 */
public class ShouldNotOccurException extends RuntimeException {
    public ShouldNotOccurException() {
        super();
    }

    public ShouldNotOccurException(String message) {
        super(message);
    }

    public ShouldNotOccurException(String message, Throwable cause) {
        super(message, cause);
    }

    public ShouldNotOccurException(Throwable cause) {
        super(cause);
    }
}
