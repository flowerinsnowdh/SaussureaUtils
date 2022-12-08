package online.flowerinsnow.saussureautils.hash;

import online.flowerinsnow.saussureautils.lang.HexUtils;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.Base64;

/**
 * 哈希算法相关常用类
 */
public class HashUtils {
    private HashUtils() {
    }

    /**
     * 用算法哈希一个byte数组
     *
     * @param algorithm 算法
     * @param src 源数据
     * @param off 读取源数据开始的下标
     * @param len 读取源数据长度，从开始下标开始
     * @return 哈希后的数据
     * @throws IllegalArgumentException 当算法不存在或不支持时抛出
     */
    public static byte[] hash(String algorithm, byte[] src, int off, int len) throws IllegalArgumentException {
        try {
            MessageDigest md = MessageDigest.getInstance(algorithm);
            md.update(src, off, len);
            return md.digest();
        } catch (NoSuchAlgorithmException e) {
            throw new IllegalArgumentException(e);
        }
    }

    /**
     * 用算法哈希一个byte数组
     *
     * @param algorithm 算法
     * @param src 源数据
     * @return 哈希后的数据
     * @throws IllegalArgumentException 当算法不存在或不支持时抛出
     */
    public static byte[] hash(String algorithm, byte[] src) throws IllegalArgumentException {
        return hash(algorithm, src, 0, src.length);
    }

    /**
     * 用算法哈希一个byte数组
     *
     * @param algorithm 算法
     * @param src 源数据
     * @param off 读取源数据开始的下标
     * @param len 读取源数据长度，从开始下标开始
     * @return 哈希后的数据
     */
    public static byte[] hash(HashAlgorithm algorithm, byte[] src, int off, int len) {
        return hash(algorithm.name, src, off, len);
    }

    /**
     * 用算法哈希一个byte数组
     *
     * @param algorithm 算法
     * @param src 源数据
     * @return 哈希后的数据
     */
    public static byte[] hash(HashAlgorithm algorithm, byte[] src) {
        return hash(algorithm.name, src, 0, src.length);
    }

    /**
     * 哈希一个byte数组，并将其转为十六进制字符串
     *
     * @param algorithm 算法
     * @param src 源数据
     * @param off 读取源数据开始的下标
     * @param len 读取源数据长度，从开始下标开始
     * @return 哈希并转换后的十六进制字符串
     * @throws IllegalArgumentException 当算法不存在或不支持时抛出
     */
    public static String hashToHex(String algorithm, byte[] src, int off, int len) throws IllegalArgumentException {
        return HexUtils.hexToString(hash(algorithm, src, off, len));
    }

    /**
     * 哈希一个byte数组，并将其转为十六进制字符串
     *
     * @param algorithm 算法
     * @param src 源数据
     * @return 哈希并转换后的十六进制字符串
     * @throws IllegalArgumentException 当算法不存在或不支持时抛出
     */
    public static String hashToHex(String algorithm, byte[] src) throws IllegalArgumentException {
        return HexUtils.hexToString(hash(algorithm, src));
    }

    /**
     * 哈希一个byte数组，并将其转为十六进制字符串
     *
     * @param algorithm 算法
     * @param src 源数据
     * @param off 读取源数据开始的下标
     * @param len 读取源数据长度，从开始下标开始
     * @return 哈希并转换后的十六进制字符串
     */
    public static String hashToHex(HashAlgorithm algorithm, byte[] src, int off, int len) {
        return HexUtils.hexToString(hash(algorithm, src, off, len));
    }

    /**
     * 哈希一个byte数组，并将其转为十六进制字符串
     *
     * @param algorithm 算法
     * @param src 源数据
     * @return 哈希并转换后的十六进制字符串
     */
    public static String hashToHex(HashAlgorithm algorithm, byte[] src) {
        return HexUtils.hexToString(hash(algorithm, src));
    }

    /**
     * 哈希一个byte数组，并将其转为Base64字符串
     *
     * @param algorithm 算法
     * @param src 源数据
     * @param off 读取源数据开始的下标
     * @param len 读取源数据长度，从开始下标开始
     * @return 哈希并转换后的Base64字符串
     * @throws IllegalArgumentException 当算法不存在或不支持时抛出
     */
    public static String hashToBase64(String algorithm, byte[] src, int off, int len) throws IllegalArgumentException {
        return Base64.getEncoder().encodeToString(hash(algorithm, src, off, len));
    }

    /**
     * 哈希一个byte数组，并将其转为Base64字符串
     *
     * @param algorithm 算法
     * @param src 源数据
     * @return 哈希并转换后的Base64字符串
     * @throws IllegalArgumentException 当算法不存在或不支持时抛出
     */
    public static String hashToBase64(String algorithm, byte[] src) throws IllegalArgumentException {
        return Base64.getEncoder().encodeToString(hash(algorithm, src));
    }

    /**
     * 哈希一个byte数组，并将其转为Base64字符串
     *
     * @param algorithm 算法
     * @param src 源数据
     * @param off 读取源数据开始的下标
     * @param len 读取源数据长度，从开始下标开始
     * @return 哈希并转换后的Base64字符串
     */
    public static String hashToBase64(HashAlgorithm algorithm, byte[] src, int off, int len) {
        return Base64.getEncoder().encodeToString(hash(algorithm, src, off, len));
    }

    /**
     * 哈希一个byte数组，并将其转为Base64字符串
     *
     * @param algorithm 算法
     * @param src 源数据
     * @return 哈希并转换后的Base64字符串
     */
    public static String hashToBase64(HashAlgorithm algorithm, byte[] src) {
        return Base64.getEncoder().encodeToString(hash(algorithm, src));
    }
}
