package online.flowerinsnow.saussureautils.annotation;

import java.lang.annotation.Target;

/**
 * 代表一个Maven依赖
 */
@Target({})
public @interface Dependency {
    String groupId();
    String artifactId();
    String version();
    String minVersion() default "";
    String maxVersion() default "";
}
