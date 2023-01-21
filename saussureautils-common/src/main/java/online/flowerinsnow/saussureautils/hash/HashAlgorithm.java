package online.flowerinsnow.saussureautils.hash;

/**
 * 已知支持的哈希算法
 */
public enum HashAlgorithm {
    MD5("MD5", 32),
    SHA1("SHA-1", 40),
    SHA224("SHA-224", 56),
    SHA256("SHA-256", 64),
    SHA384("SHA-384", 96),
    SHA512("SHA-512", 128);
    public final String name;
    public final int size;

    HashAlgorithm(String name, int size) {
        this.name = name;
        this.size = size;
    }
}
