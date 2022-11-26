package online.flowerinsnow.saussureautils.object;

import java.util.function.Consumer;

public interface IExceptionHandler<T extends Throwable> extends Consumer<T> {
    @Override
    void accept(T t);
}
