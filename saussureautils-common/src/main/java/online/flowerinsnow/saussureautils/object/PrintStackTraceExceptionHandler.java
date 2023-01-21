package online.flowerinsnow.saussureautils.object;

public class PrintStackTraceExceptionHandler<T extends Throwable> implements IExceptionHandler<T> {
    @Override
    public void accept(T t) {
        t.printStackTrace();
    }
}
