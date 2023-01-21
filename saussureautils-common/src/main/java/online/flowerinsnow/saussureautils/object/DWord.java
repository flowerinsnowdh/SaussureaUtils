package online.flowerinsnow.saussureautils.object;

import java.util.Arrays;

/**
 * 代表一个两位的字符
 */
public class DWord {
    private final char[] array = new char[2];

    /**
     * 从一个两位的数组复制数据到本对象中，指定起始下标
     *
     * @param src 源数组
     * @param off 起始下标
     * @throws IllegalArgumentException 当源数组不足2位时抛出
     */
    public DWord(char[] src, int off) throws IllegalArgumentException {
        if ((src.length - off) < 2) {
            throw new IllegalArgumentException("At least 2 size required.");
        }
        System.arraycopy(src, off, array, 0, 2);
    }

    /**
     * 从一个两位的数组复制数据到本对象中
     *
     * @param src 源数组
     * @throws IllegalArgumentException 当源数组不足2位时抛出
     */
    public DWord(char[] src) throws IllegalArgumentException {
        this(src, 0);
    }

    /**
     * 指定两位字符
     *
     * @param one 第一位
     * @param two 第二位
     */
    public DWord(char one, char two) {
        array[0] = one;
        array[1] = two;
    }

    /**
     * 从一个字符串中复制数据到本对象中
     *
     * @param src 源字符串
     * @throws IllegalArgumentException 当字符串不足2位时抛出
     */
    public DWord(String src) throws IllegalArgumentException {
        this(src.toCharArray());
    }

    public char[] array() {
        char[] copy = new char[2];
        System.arraycopy(array, 0, copy, 0, 2);
        return copy;
    }

    public char get1() {
        return array[0];
    }

    public char get2() {
        return array[1];
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        DWord dWord = (DWord) o;
        return Arrays.equals(array, dWord.array);
    }

    @Override
    public int hashCode() {
        int result = 17;
        result = 31 * result + Arrays.hashCode(array);
        return result;
    }

    @Override
    public String toString() {
        return new String(array);
    }
}
