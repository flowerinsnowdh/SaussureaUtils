package online.flowerinsnow.saussureautils.lang;

import online.flowerinsnow.saussureautils.object.DWord;

/**
 * 有关位的常用类
 */
public final class HexUtils {
    private static final char[] HEX = new char[] {
            '0', '1', '2', '3', '4', '5', '6', '7', '8', '9',
            'a', 'b', 'c', 'd', 'e', 'f'
    };

    /**
     * 封锁构造方法，不允许创建对象
     */
    private HexUtils() {
    }

    /**
     * 将byte数组转换为十六进制字符串
     *
     * @param bytes byte数组
     * @return 十六进制字符串
     */
    public static String hexToString(byte[] bytes) {
        char[] array = new char[bytes.length * 2];
        for (int i = 0; i < bytes.length; i++) {
            DWord current = hex(bytes[i]);
            array[i * 2] = current.get1();
            array[i * 2 + 1] = current.get2();
        }
        return new String(array);
    }

    /**
     * 将一个字节转换为十六进制字符串
     *
     * @param b 字节
     * @return 一个字节对应的两个十六进制字符
     */
    public static DWord hex(byte b) {
        byte left = (byte) ((b >>> 4) & 0xF);
        byte right = (byte) (b & 0xF);
        char one = HEX[left];
        char two = HEX[right];
        return new DWord(one, two);
    }

    /**
     * 获取十六进制的16个字符
     *
     * @return 十六进制的16个字符
     */
    public static char[] hexChars() {
        int size = HEX.length;
        char[] copy = new char[size];
        System.arraycopy(HEX, 0, copy, 0, size);
        return copy;
    }
}
