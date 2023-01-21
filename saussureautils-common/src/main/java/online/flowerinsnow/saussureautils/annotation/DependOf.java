package online.flowerinsnow.saussureautils.annotation;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * 代表这个类或方法正在使用这个依赖
 * 如果目标环境没有这个依赖，调用将会出现错误
 * 可以考虑一起打包进jar
 */
@Target({ElementType.METHOD, ElementType.TYPE})
@Retention(RetentionPolicy.CLASS)
public @interface DependOf {
    Dependency[] value();
}
