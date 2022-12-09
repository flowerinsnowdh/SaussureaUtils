package online.flowerinsnow.saussureautils.collection;

import java.util.Arrays;
import java.util.Collection;
import java.util.Objects;

/**
 * <p>集合构造器，可以快速创建一个集合</p>
 * <p>示例：</p>
 * <p>new CollectionBuilder&lt;ArrayList&lt;Integer&gt;, Integer&gt;(new ArrayList&lt;&gt;())
 * <p>&emsp;&emsp;.add(1)</p>
 * <p>&emsp;.add(2)</p>
 * <p>&emsp;.add(new Integer[]{3, 4, 5})</p>
 * <p>&emsp;.get();</p>
 * <p>即可获得 ArrayList&lt;Integer&gt;&#91;1, 2, 3, 4, 5&#93;</p>
 *
 * @param <T> 集合类型
 * @param <E> the type of elements in this collection
 */
public class CollectionBuilder<T extends Collection<E>, E> {
    private final T collection;

    /**
     * 初始集合
     *
     * @param provider 初始集合
     */
    public CollectionBuilder(T provider) {
        Objects.requireNonNull(provider);
        this.collection = provider;
    }

    public CollectionBuilder<T, E> add(E value) {
        collection.add(value);
        return this;
    }

    public CollectionBuilder<T, E> add(E[] values) {
        collection.addAll(Arrays.asList(values));
        return this;
    }

    public CollectionBuilder<T, E> addAll(Collection<E> collection) {
        this.collection.addAll(collection);
        return this;
    }

    public CollectionBuilder<T, E> remove(E value) {
        collection.remove(value);
        return this;
    }

    public CollectionBuilder<T, E> removeAll(Collection<E> collection) {
        this.collection.removeAll(collection);
        return this;
    }

    public CollectionBuilder<T, E> clear() {
        collection.clear();
        return this;
    }

    /**
     * 获取最终结果
     *
     * @return 最终结果
     */
    public T get() {
        return collection;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        CollectionBuilder<?, ?> that = (CollectionBuilder<?, ?>) o;
        return collection.equals(that.collection);
    }

    @Override
    public int hashCode() {
        int result = 17;
        result = 31 * result + collection.hashCode();
        return result;
    }

    @Override
    public String toString() {
        return "CollectionBuilder{" +
                "collection=" + collection +
                '}';
    }
}
