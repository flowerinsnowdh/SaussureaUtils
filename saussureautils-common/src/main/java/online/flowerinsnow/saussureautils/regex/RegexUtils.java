package online.flowerinsnow.saussureautils.regex;

import org.jetbrains.annotations.NotNull;

import java.util.Objects;
import java.util.Optional;
import java.util.regex.Pattern;
import java.util.regex.PatternSyntaxException;

/**
 * 有关正则表达式的常用类
 */
public abstract class RegexUtils {
    private RegexUtils() {
    }

    /**
     * 匹配数字0~255
     */
    /*
    0~9: [0-9]
    10~99: [1-9][0-9] - 两位数的情况下第一位必须是1~9，第二位随意
    100~199: 1[0-9]{2} - 100及以上200以下第一位必须是1，其余两位随意
    200~249: 2[0-4][0-9] - 200及以上250以下第一位必须是2，其余两位随意
    250~255: 25[0-5] - 250及以上256以下第一位必须是2，第二位必须是5，第三位不得超过5
    */
    @NotNull public static final String PRESET_ZERO_TO_TWO_HUNDRED_AND_FIFTY_FIVE_STRING = "([0-9]|1[0-9]{2}|2[0-4][0-9]|25[0-5])";

    /**
     * 匹配数字0~255
     */
    @NotNull public static final Pattern PRESET_ZERO_TO_TWO_HUNDRED_AND_FIFTY_FIVE = Pattern.compile(
            PRESET_ZERO_TO_TWO_HUNDRED_AND_FIFTY_FIVE_STRING
    );

    /**
     * 匹配数字0~32
     */
    @NotNull public static final String PRESET_ZERO_TO_THIRTY_TWO_STRING = "([0-9]|[1-2][0-9]|3[0-2])";

    /**
     * 预设格式
     * 匹配0~32之间的整数
     */
    @NotNull public static final Pattern PRESET_ZERO_TO_THIRTY_TWO = Pattern.compile(
            PRESET_ZERO_TO_THIRTY_TWO_STRING
    );

    /**
     * IPv4地址
     */
    @NotNull public static final String PRESET_IPV4_ADDRESS_STRING =
            "(" + PRESET_ZERO_TO_TWO_HUNDRED_AND_FIFTY_FIVE_STRING + "\\.){3}" + PRESET_ZERO_TO_TWO_HUNDRED_AND_FIFTY_FIVE_STRING;

    /**
     * <p>预设格式</p>
     * <p>匹配IPv4地址</p>
     * <pre>
     * 192.168.0.1
     * 255.255.255.0
     * </pre>
     */
    @NotNull public static final Pattern PRESET_IPV4_ADDRESS = Pattern.compile(
            PRESET_IPV4_ADDRESS_STRING
    );

    /**
     * 匹配带子网掩码长度的IPv4地址
     */
    @NotNull public static final String PRESET_IPV4_ADDRESS_WITH_SUBNET_MASK_STRING =
            PRESET_IPV4_ADDRESS_STRING + "/" + PRESET_ZERO_TO_THIRTY_TWO_STRING;

    /**
     * <p>预设格式</p>
     * <p>匹配IPv4地址，带子网掩码长度</p>
     * <pre>
     * 192.168.0.0/16
     * 10.0.0.0/8
     * </pre>
     */
    @NotNull public static final Pattern PRESET_IPV4_ADDRESS_WITH_SUBNET_MASK = Pattern.compile(
            PRESET_IPV4_ADDRESS_WITH_SUBNET_MASK_STRING
    );

    /**
     * 匹配可以带也可以不带子网掩码长度的IPv4地址
     */
    @NotNull public static final String PRESET_IPV4_ADDRESS_MAY_WITH_SUBNET_MASK_STRING =
            PRESET_IPV4_ADDRESS_STRING + "(/" + PRESET_ZERO_TO_THIRTY_TWO_STRING + ")?";

    /**
     * <p>预设格式</p>
     * <p>匹配可以带也可以不带子网掩码长度的IPv4地址</p>
     * <pre>
     * 192.168.0.0/16
     * 10.0.0.0
     * </pre>
     */
    @NotNull public static final Pattern PRESET_IPV4_ADDRESS_MAY_WITH_SUBNET_MASK = Pattern.compile(
            PRESET_IPV4_ADDRESS_MAY_WITH_SUBNET_MASK_STRING
    );

    /**
     * <p>预设格式</p>
     * <p>匹配一个电子邮箱地址</p>
     * <pre>
     * flowerimsnow@hotmail.com
     * t@t.cn
     * </pre>
     */
    @NotNull public static final Pattern PRESET_EMAIL = Pattern.compile(
            "\\w+([-+.]\\w+)*@\\w+([-.]\\w+)*\\.\\w+([-.]\\w+)*"
    );

    /**
     * <p>预设格式</p>
     * <p>匹配一个Minecraft用户名</p>
     * <pre>
     * flowerinsnow
     * LifeIsHappy
     * </pre>
     */
    @NotNull public static final Pattern PRESET_MINECRAFT_USERNAME = Pattern.compile(
            "\\w{3,16}"
    );

    /**
     * <p>预设格式</p>
     * <p>匹配一个UUID</p>
     * <pre>
     * 16d3c457b24c9344069e07ad5bd84c22
     * aead26321dfbfdf6e183f28772cc3d1b
     * </pre>
     */
    @NotNull public static final Pattern PRESET_UUID = Pattern.compile(
            "[0-9a-fA-F]{8}([0-9a-fA-F]{4}){3}[0-9a-fA-F]{12}"
    );

    /**
     * <p>预设格式</p>
     * <p>匹配一个带连接线的UUID</p>
     * <pre>
     * 16d3c457-b24c-9344-069e-07ad5bd84c22
     * aead2632-1dfb-fdf6-e183-f28772cc3d1b
     * </pre>
     */
    @NotNull public static final Pattern PRESET_UUID_WITH_LINK = Pattern.compile(
            "[0-9a-fA-F]{8}(-[0-9a-fA-F]{4}){3}-[0-9a-fA-F]{12}"
    );

    /**
     * <p>预设格式</p>
     * <p>匹配一个带连接线或不带连接线的UUID</p>
     * <pre>
     * 16d3c457-b24c-9344-069e-07ad5bd84c22
     * aead26321dfbfdf6e183f28772cc3d1b
     * </pre>
     */
    @NotNull public static final Pattern PRESET_UUID_MAY_WITH_LINK = Pattern.compile(
            "([0-9a-fA-F]{8}([0-9a-fA-F]{4}){3}[0-9a-fA-F]{12}|[0-9a-fA-F]{8}(-[0-9a-fA-F]{4}){3}-[0-9a-fA-F]{12})"
    );



    /**
     * 判断Pattern格式是否合法
     *
     * @param pattern 格式
     * @return 如果该格式合法，返回true
     */
    public static boolean isPatternValid(@NotNull String pattern) {
        Objects.requireNonNull(pattern);
        try {
            Pattern.compile(pattern);
            return true;
        } catch (PatternSyntaxException e) {
            return false;
        }
    }

    /**
     * 判断Pattern格式是否合法，如果合法，将其返回
     *
     * @param pattern 格式
     * @return 如果Pattern合法，将其返回，否则返回null
     */
    public static @NotNull Optional<Pattern> testPattern(@NotNull String pattern) {
        Objects.requireNonNull(pattern);
        try {
            return Optional.of(Pattern.compile(pattern));
        } catch (PatternSyntaxException e) {
            return Optional.empty();
        }
    }
}
