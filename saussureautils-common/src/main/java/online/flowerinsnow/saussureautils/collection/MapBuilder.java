package online.flowerinsnow.saussureautils.collection;

import java.util.Map;
import java.util.Objects;

/**
 * <p>映射构造器，可以快速构造一个映射</p>
 * <p>例如：</p>
 * <p>new MapBuilder&lt;HashMap&lt;String, String&gt;, String, String&gt;(new HashMap&lt;&gt;())</p>
 * <p>&emsp;&emsp;.put("name", "张三")</p>
 * <p>&emsp;&emsp;.put("性别", "男")</p>
 * <p>&emsp;&emsp;.put("职业", "法外狂徒")</p>
 * <p>&emsp;.get()</p>
 * <p>即可获得</p>
 * <p>&#123;职业=法外狂徒, name=张三, 性别=男&#125;</p>
 *
 * @param <T> Map类型
 * @param <K> the type of keys maintained by this map
 * @param <V> the type of mapped values
 */
public class MapBuilder<T extends Map<K, V>, K, V> {
    private final T map;

    /**
     * 初始映射
     *
     * @param provider 初始映射
     */
    public MapBuilder(T provider) {
        Objects.requireNonNull(provider);
        this.map = provider;
    }

    public MapBuilder<T, K, V> put(K key, V value) {
        map.put(key, value);
        return this;
    }

    public MapBuilder<T, K, V> put(Map.Entry<K, V>[] entries) {
        for (Map.Entry<K, V> entry : entries) {
            map.put(entry.getKey(), entry.getValue());
        }
        return this;
    }

    public MapBuilder<T, K, V> putAll(Map<K, V> map) {
        this.map.putAll(map);
        return this;
    }

    public MapBuilder<T, K, V> remove(K key) {
        map.remove(key);
        return this;
    }

    public MapBuilder<T, K, V> clear() {
        map.clear();
        return this;
    }

    /**
     * 获取最终结果
     *
     * @return 最终结果
     */
    public T get() {
        return map;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        MapBuilder<?, ?, ?> that = (MapBuilder<?, ?, ?>) o;
        return map.equals(that.map);
    }

    @Override
    public int hashCode() {
        int result = 17;
        result = 31 * result + map.hashCode();
        return result;
    }

    @Override
    public String toString() {
        return "MapBuilder{" +
                "map=" + map +
                '}';
    }
}
