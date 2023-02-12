package online.flowerinsnow.saussureautils.exception;

/**
 * 程序员操作失误或逻辑错误导致的异常
 * 一般情况下是不会发生，但是遇到了不是一般的情况
 * 例如默认不存在对应的物品但是一定要调用时
 * 或者除以0时
 * 这些异常应该提前自行判断，而不是等待该异常抛出
 */
public class LogicException extends RuntimeException {
    public LogicException() {
        super();
    }

    public LogicException(String message) {
        super(message);
    }

    public LogicException(String message, Throwable cause) {
        super(message, cause);
    }

    public LogicException(Throwable cause) {
        super(cause);
    }
}
