package online.flowerinsnow.saussureautils.hash;

import online.flowerinsnow.saussureautils.io.IOUtils;
import online.flowerinsnow.saussureautils.lang.HexUtils;
import online.flowerinsnow.saussureautils.object.IExceptionHandler;

import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.nio.file.Files;
import java.nio.file.Path;
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

    /**
     * 哈希输入流
     *
     * @param algorithm 算法
     * @param src 源数据
     * @param close 在读取完毕后是否自动关闭流
     * @return 哈希后的数据
     * @throws IllegalArgumentException 当算法不存在或不支持时抛出
     * @throws IOException 当出现IO异常时抛出
     */
    public static byte[] hash(String algorithm, InputStream src, boolean close) throws IllegalArgumentException, IOException {
        try {
            MessageDigest md = MessageDigest.getInstance(algorithm);
            int len;
            byte[] bytes = new byte[1024];
            while ((len = src.read(bytes)) != -1) {
                md.update(bytes, 0, len);
            }
            return md.digest();
        } catch (NoSuchAlgorithmException e) {
            throw new IllegalArgumentException(e);
        } finally {
            if (close) {
                IOUtils.closeQuietly(src);
            }
        }
    }

    /**
     * 哈希输入流，并将异常交由异常处理器处理
     *
     * @param algorithm 算法
     * @param src 源数据
     * @param close 在读取完毕后是否自动关闭流
     * @param exceptionHandler 异常处理器，可为空
     * @return 哈希后的数据
     * @throws IllegalArgumentException 当算法不存在或不支持时抛出
     */
    public static byte[] hash(String algorithm, InputStream src, boolean close, IExceptionHandler<IOException> exceptionHandler) throws IllegalArgumentException {
        try {
            return hash(algorithm, src, close);
        } catch (IOException e) {
            if (exceptionHandler != null) {
                exceptionHandler.accept(e);
            }
            return null;
        }
    }

    /**
     * 哈希输入流
     *
     * @param algorithm 算法
     * @param src 源数据
     * @param close 在读取完毕后是否自动关闭流
     * @return 哈希后的数据
     * @throws IOException 当出现IO异常时抛出
     */
    public static byte[] hash(HashAlgorithm algorithm, InputStream src, boolean close) throws IOException {
        return hash(algorithm.name, src, close);
    }

    /**
     * 哈希输入流，并将异常交由异常处理器处理
     *
     * @param algorithm 算法
     * @param src 源数据
     * @param close 在读取完毕后是否自动关闭流
     * @param exceptionHandler 异常处理器，可为空
     * @return 哈希后的数据
     */
    public static byte[] hash(HashAlgorithm algorithm, InputStream src, boolean close, IExceptionHandler<IOException> exceptionHandler) {
        try {
            return hash(algorithm, src, close);
        } catch (IOException e) {
            if (exceptionHandler != null) {
                exceptionHandler.accept(e);
            }
            return null;
        }
    }

    /**
     * 哈希文件
     *
     * @param algorithm 算法
     * @param src 源数据
     * @return 哈希后的数据
     * @throws IllegalArgumentException 当算法不存在或不支持时抛出
     * @throws IOException 当出现IO异常时抛出
     */
    public static byte[] hash(String algorithm, Path src) throws IllegalArgumentException, IOException {
        return hash(algorithm, Files.newInputStream(src), true);
    }

    /**
     * 哈希文件，并将异常交由异常处理器处理
     *
     * @param algorithm 算法
     * @param src 源数据
     * @param exceptionHandler 异常处理器，可为空
     * @return 哈希后的数据
     * @throws IllegalArgumentException 当算法不存在或不支持时抛出
     */
    public static byte[] hash(String algorithm, Path src, IExceptionHandler<IOException> exceptionHandler) throws IllegalArgumentException {
        try {
            return hash(algorithm, src);
        } catch (IOException e) {
            if (exceptionHandler != null) {
                exceptionHandler.accept(e);
            }
            return null;
        }
    }

    /**
     * 哈希文件
     *
     * @param algorithm 算法
     * @param src 源数据
     * @return 哈希后的数据
     * @throws IOException 当出现IO异常时抛出
     */
    public static byte[] hash(HashAlgorithm algorithm, Path src) throws IOException {
        return hash(algorithm, Files.newInputStream(src), true);
    }

    /**
     * 哈希文件，并将异常交由异常处理器处理
     *
     * @param algorithm 算法
     * @param src 源数据
     * @param exceptionHandler 异常处理器，可为空
     * @return 哈希后的数据
     */
    public static byte[] hash(HashAlgorithm algorithm, Path src, IExceptionHandler<IOException> exceptionHandler) {
        try {
            return hash(algorithm, src);
        } catch (IOException e) {
            if (exceptionHandler != null) {
                exceptionHandler.accept(e);
            }
            return null;
        }
    }

    /**
     * 哈希文件
     *
     * @param algorithm 算法
     * @param src 源数据
     * @return 哈希后的数据
     * @throws IllegalArgumentException 当算法不存在或不支持时抛出
     * @throws IOException 当出现IO异常时抛出
     */
    public static byte[] hash(String algorithm, File src) throws IllegalArgumentException, IOException {
        return hash(algorithm, src.toPath());
    }

    /**
     * 哈希文件，并将异常交由异常处理器处理
     *
     * @param algorithm 算法
     * @param src 源数据
     * @param exceptionHandler 异常处理器，可为空
     * @return 哈希后的数据
     * @throws IllegalArgumentException 当算法不存在或不支持时抛出
     */
    public static byte[] hash(String algorithm, File src, IExceptionHandler<IOException> exceptionHandler) throws IllegalArgumentException {
        try {
            return hash(algorithm, src);
        } catch (IOException e) {
            if (exceptionHandler != null) {
                exceptionHandler.accept(e);
            }
            return null;
        }
    }

    /**
     * 哈希文件
     *
     * @param algorithm 算法
     * @param src 源数据
     * @return 哈希后的数据
     * @throws IOException 当出现IO异常时抛出
     */
    public static byte[] hash(HashAlgorithm algorithm, File src) throws IllegalArgumentException, IOException {
        return hash(algorithm, src.toPath());
    }

    /**
     * 哈希文件，并将异常交由异常处理器处理
     *
     * @param algorithm 算法
     * @param src 源数据
     * @param exceptionHandler 异常处理器，可为空
     * @return 哈希后的数据
     */
    public static byte[] hash(HashAlgorithm algorithm, File src, IExceptionHandler<IOException> exceptionHandler) throws IllegalArgumentException {
        try {
            return hash(algorithm, src);
        } catch (IOException e) {
            if (exceptionHandler != null) {
                exceptionHandler.accept(e);
            }
            return null;
        }
    }

    /**
     * 哈希输入流，并将其转换为十六进制字符串
     *
     * @param algorithm 算法
     * @param src 输入源
     * @param close 在读取完毕后是否自动关闭流
     * @return 哈希并转换后的十六进制字符串
     * @throws IllegalArgumentException 当算法不存在或不支持时抛出
     * @throws IOException 当出现IO异常时抛出
     */
    public static String hashToHex(String algorithm, InputStream src, boolean close) throws IllegalArgumentException, IOException {
        return HexUtils.hexToString(hash(algorithm, src, close));
    }

    /**
     * 哈希输入流，并将其转换为十六进制字符串，并将异常交由异常处理器处理
     *
     * @param algorithm 算法
     * @param src 输入源
     * @param close 在读取完毕后是否自动关闭流
     * @param exceptionHandler 异常处理器，可为空
     * @return 哈希并转换后的十六进制字符串
     * @throws IllegalArgumentException 当算法不存在或不支持时抛出
     */
    public static String hashToHex(String algorithm, InputStream src, boolean close, IExceptionHandler<IOException> exceptionHandler) throws IllegalArgumentException {
        try {
            return hashToHex(algorithm, src, close);
        } catch (IOException e) {
            if (exceptionHandler != null) {
                exceptionHandler.accept(e);
            }
            return null;
        }
    }

    /**
     * 哈希输入流，并将其转换为十六进制字符串
     *
     * @param algorithm 算法
     * @param src 输入源
     * @param close 在读取完毕后是否自动关闭流
     * @return 哈希并转换后的十六进制字符串
     * @throws IOException 当出现IO异常时抛出
     */
    public static String hashToHex(HashAlgorithm algorithm, InputStream src, boolean close) throws IOException {
        return HexUtils.hexToString(hash(algorithm, src, close));
    }

    /**
     * 哈希输入流，并将其转换为十六进制字符串，并将异常交由异常处理器处理
     *
     * @param algorithm 算法
     * @param src 输入源
     * @param close 在读取完毕后是否自动关闭流
     * @param exceptionHandler 异常处理器，可为空
     * @return 哈希并转换后的十六进制字符串
     */
    public static String hashToHex(HashAlgorithm algorithm, InputStream src, boolean close, IExceptionHandler<IOException> exceptionHandler) {
        try {
            return hashToHex(algorithm, src, close);
        } catch (IOException e) {
            if (exceptionHandler != null) {
                exceptionHandler.accept(e);
            }
            return null;
        }
    }

    /**
     * 哈希文件，并将其转换为十六进制字符串
     *
     * @param algorithm 算法
     * @param src 输入源
     * @return 哈希并转换后的十六进制字符串
     * @throws IllegalArgumentException 当算法不存在或不支持时抛出
     * @throws IOException 当出现IO异常时抛出
     */
    public static String hashToHex(String algorithm, Path src) throws IllegalArgumentException, IOException {
        return HexUtils.hexToString(hash(algorithm, src));
    }

    /**
     * 哈希文件，并将其转换为十六进制字符串，并将异常交由异常处理器处理
     *
     * @param algorithm 算法
     * @param src 输入源
     * @param exceptionHandler 异常处理器，可为空
     * @return 哈希并转换后的十六进制字符串
     * @throws IllegalArgumentException 当算法不存在或不支持时抛出
     */
    public static String hashToHex(String algorithm, Path src, IExceptionHandler<IOException> exceptionHandler) throws IllegalArgumentException {
        try {
            return hashToHex(algorithm, src);
        } catch (IOException e) {
            if (exceptionHandler != null) {
                exceptionHandler.accept(e);
            }
            return null;
        }
    }

    /**
     * 哈希文件，并将其转换为十六进制字符串
     *
     * @param algorithm 算法
     * @param src 输入源
     * @return 哈希并转换后的十六进制字符串
     * @throws IOException 当出现IO异常时抛出
     */
    public static String hashToHex(HashAlgorithm algorithm, Path src) throws IOException {
        return HexUtils.hexToString(hash(algorithm, src));
    }

    /**
     * 哈希文件，并将其转换为十六进制字符串，并将异常交由异常处理器处理
     *
     * @param algorithm 算法
     * @param src 输入源
     * @param exceptionHandler 异常处理器，可为空
     * @return 哈希并转换后的十六进制字符串
     */
    public static String hashToHex(HashAlgorithm algorithm, Path src, IExceptionHandler<IOException> exceptionHandler) {
        try {
            return hashToHex(algorithm, src);
        } catch (IOException e) {
            if (exceptionHandler != null) {
                exceptionHandler.accept(e);
            }
            return null;
        }
    }

    /**
     * 哈希文件，并将其转换为十六进制字符串
     *
     * @param algorithm 算法
     * @param src 输入源
     * @return 哈希并转换后的十六进制字符串
     * @throws IllegalArgumentException 当算法不存在或不支持时抛出
     * @throws IOException 当出现IO异常时抛出
     */
    public static String hashToHex(String algorithm, File src) throws IllegalArgumentException, IOException {
        return hashToHex(algorithm, src.toPath());
    }

    /**
     * 哈希文件，并将其转换为十六进制字符串，并将异常交由异常处理器处理
     *
     * @param algorithm 算法
     * @param src 输入源
     * @param exceptionHandler 异常处理器，可为空
     * @return 哈希并转换后的十六进制字符串
     * @throws IllegalArgumentException 当算法不存在或不支持时抛出
     */
    public static String hashToHex(String algorithm, File src, IExceptionHandler<IOException> exceptionHandler) throws IllegalArgumentException {
        try {
            return hashToHex(algorithm, src);
        } catch (IOException e) {
            if (exceptionHandler != null) {
                exceptionHandler.accept(e);
            }
            return null;
        }
    }

    /**
     * 哈希文件，并将其转换为十六进制字符串
     *
     * @param algorithm 算法
     * @param src 输入源
     * @return 哈希并转换后的十六进制字符串
     * @throws IOException 当出现IO异常时抛出
     */
    public static String hashToHex(HashAlgorithm algorithm, File src) throws IOException {
        return hashToHex(algorithm, src.toPath());
    }

    /**
     * 哈希文件，并将其转换为十六进制字符串，并将异常交由异常处理器处理
     *
     * @param algorithm 算法
     * @param src 输入源
     * @param exceptionHandler 异常处理器，可为空
     * @return 哈希并转换后的十六进制字符串
     */
    public static String hashToHex(HashAlgorithm algorithm, File src, IExceptionHandler<IOException> exceptionHandler) {
        try {
            return hashToHex(algorithm, src);
        } catch (IOException e) {
            if (exceptionHandler != null) {
                exceptionHandler.accept(e);
            }
            return null;
        }
    }

    /**
     * 哈希输入流，并将其转换为Base64字符串
     *
     * @param algorithm 算法
     * @param src 输入源
     * @param close 在读取完毕后是否自动关闭流
     * @return 哈希并转换后的Base64字符串
     * @throws IllegalArgumentException 当算法不存在或不支持时抛出
     * @throws IOException 当出现IO异常时抛出
     */
    public static String hashToBase64(String algorithm, InputStream src, boolean close) throws IllegalArgumentException, IOException {
        return Base64.getEncoder().encodeToString(hash(algorithm, src, close));
    }

    /**
     * 哈希输入流，并将其转换为Base64字符串，并将异常交由异常处理器处理
     *
     * @param algorithm 算法
     * @param src 输入源
     * @param close 在读取完毕后是否自动关闭流
     * @param exceptionHandler 异常处理器，可为空
     * @return 哈希并转换后的Base64字符串
     * @throws IllegalArgumentException 当算法不存在或不支持时抛出
     */
    public static String hashToBase64(String algorithm, InputStream src, boolean close, IExceptionHandler<IOException> exceptionHandler) throws IllegalArgumentException {
        try {
            return hashToBase64(algorithm, src, close);
        } catch (IOException e) {
            if (exceptionHandler != null) {
                exceptionHandler.accept(e);
            }
            return null;
        }
    }

    /**
     * 哈希输入流，并将其转换为Base64字符串
     *
     * @param algorithm 算法
     * @param src 输入源
     * @param close 在读取完毕后是否自动关闭流
     * @return 哈希并转换后的Base64字符串
     * @throws IOException 当出现IO异常时抛出
     */
    public static String hashToBase64(HashAlgorithm algorithm, InputStream src, boolean close) throws IOException {
        return Base64.getEncoder().encodeToString(hash(algorithm, src, close));
    }

    /**
     * 哈希输入流，并将其转换为Base64字符串，并将异常交由异常处理器处理
     *
     * @param algorithm 算法
     * @param src 输入源
     * @param close 在读取完毕后是否自动关闭流
     * @param exceptionHandler 异常处理器，可为空
     * @return 哈希并转换后的Base64字符串
     */
    public static String hashToBase64(HashAlgorithm algorithm, InputStream src, boolean close, IExceptionHandler<IOException> exceptionHandler) {
        try {
            return hashToBase64(algorithm, src, close);
        } catch (IOException e) {
            if (exceptionHandler != null) {
                exceptionHandler.accept(e);
            }
            return null;
        }
    }

    /**
     * 哈希文件，并将其转换为Base64字符串
     *
     * @param algorithm 算法
     * @param src 输入源
     * @return 哈希并转换后的Base64字符串
     * @throws IllegalArgumentException 当算法不存在或不支持时抛出
     * @throws IOException 当出现IO异常时抛出
     */
    public static String hashToBase64(String algorithm, Path src) throws IllegalArgumentException, IOException {
        return Base64.getEncoder().encodeToString(hash(algorithm, src));
    }

    /**
     * 哈希文件，并将其转换为Base64字符串，并将异常交由异常处理器处理
     *
     * @param algorithm 算法
     * @param src 输入源
     * @param exceptionHandler 异常处理器，可为空
     * @return 哈希并转换后的Base64字符串
     * @throws IllegalArgumentException 当算法不存在或不支持时抛出
     */
    public static String hashToBase64(String algorithm, Path src, IExceptionHandler<IOException> exceptionHandler) throws IllegalArgumentException {
        try {
            return hashToBase64(algorithm, src);
        } catch (IOException e) {
            if (exceptionHandler != null) {
                exceptionHandler.accept(e);
            }
            return null;
        }
    }

    /**
     * 哈希文件，并将其转换为Base64字符串
     *
     * @param algorithm 算法
     * @param src 输入源
     * @return 哈希并转换后的Base64字符串
     * @throws IOException 当出现IO异常时抛出
     */
    public static String hashToBase64(HashAlgorithm algorithm, Path src) throws IOException {
        return Base64.getEncoder().encodeToString(hash(algorithm, src));
    }

    /**
     * 哈希文件，并将其转换为Base64字符串，并将异常交由异常处理器处理
     *
     * @param algorithm 算法
     * @param src 输入源
     * @param exceptionHandler 异常处理器，可为空
     * @return 哈希并转换后的Base64字符串
     */
    public static String hashToBase64(HashAlgorithm algorithm, Path src, IExceptionHandler<IOException> exceptionHandler) {
        try {
            return hashToBase64(algorithm, src);
        } catch (IOException e) {
            if (exceptionHandler != null) {
                exceptionHandler.accept(e);
            }
            return null;
        }
    }

    /**
     * 哈希文件，并将其转换为Base64字符串
     *
     * @param algorithm 算法
     * @param src 输入源
     * @return 哈希并转换后的Base64字符串
     * @throws IllegalArgumentException 当算法不存在或不支持时抛出
     * @throws IOException 当出现IO异常时抛出
     */
    public static String hashToBase64(String algorithm, File src) throws IllegalArgumentException, IOException {
        return hashToBase64(algorithm, src.toPath());
    }

    /**
     * 哈希文件，并将其转换为Base64字符串，并将异常交由异常处理器处理
     *
     * @param algorithm 算法
     * @param src 输入源
     * @param exceptionHandler 异常处理器，可为空
     * @return 哈希并转换后的Base64字符串
     * @throws IllegalArgumentException 当算法不存在或不支持时抛出
     */
    public static String hashToBase64(String algorithm, File src, IExceptionHandler<IOException> exceptionHandler) throws IllegalArgumentException {
        try {
            return hashToBase64(algorithm, src);
        } catch (IOException e) {
            if (exceptionHandler != null) {
                exceptionHandler.accept(e);
            }
            return null;
        }
    }

    /**
     * 哈希文件，并将其转换为Base64字符串
     *
     * @param algorithm 算法
     * @param src 输入源
     * @return 哈希并转换后的Base64字符串
     * @throws IOException 当出现IO异常时抛出
     */
    public static String hashToBase64(HashAlgorithm algorithm, File src) throws IOException {
        return hashToBase64(algorithm, src.toPath());
    }

    /**
     * 哈希文件，并将其转换为Base64字符串，并将异常交由异常处理器处理
     *
     * @param algorithm 算法
     * @param src 输入源
     * @param exceptionHandler 异常处理器，可为空
     * @return 哈希并转换后的Base64字符串
     */
    public static String hashToBase64(HashAlgorithm algorithm, File src, IExceptionHandler<IOException> exceptionHandler) {
        try {
            return hashToBase64(algorithm, src);
        } catch (IOException e) {
            if (exceptionHandler != null) {
                exceptionHandler.accept(e);
            }
            return null;
        }
    }
}
