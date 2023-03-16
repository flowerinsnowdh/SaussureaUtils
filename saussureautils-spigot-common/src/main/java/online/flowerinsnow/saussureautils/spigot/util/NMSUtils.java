package online.flowerinsnow.saussureautils.spigot.util;

import online.flowerinsnow.saussureautils.annotation.DependOf;
import online.flowerinsnow.saussureautils.annotation.Dependency;
import online.flowerinsnow.saussureautils.object.IExceptionHandler;
import org.bukkit.Bukkit;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/**
 * net.minecraft.server包的常用类
 */
@DependOf(
        @Dependency(
                groupId = "org.spigotmc",
                artifactId = "spigot-api",
                version = "1.19.4-R0.1-SNAPSHOT",
                minVersion = "1.8.8-R0.1-SNAPSHOT",
                maxVersion = "1.19.4-R0.1-SNAPSHOT"
        )
)
public class NMSUtils {
    /**
     * 获取NMS类
     *
     * @param className 类名
     * @return 获取到的类
     * @throws ClassNotFoundException 当找不到类时抛出
     */
    public static Class<?> getNMSClass(@NotNull String className) throws ClassNotFoundException {
        if (isLegacy()) {
            Class.forName("net.minecraft.server.MinecraftServer");
            // 是高版本，以net.minecraft开头
            return Class.forName("net.minecraft." + className);
        } else {
            // 是低版本，以net.minecraft.server.<版本>开头
            return Class.forName("net.minecraft.server." + getVersion() + "." + className);
        }
    }

    /**
     * 获取NMS类
     * 并将异常交由异常处理器处理
     *
     * @param className 类名
     * @param exceptionHandler 异常处理器，可为空
     * @return 获取到的类
     */
    public static @Nullable Class<?> getNMSClass(@NotNull String className, @Nullable IExceptionHandler<ClassNotFoundException> exceptionHandler) {
        try {
            return getNMSClass(className);
        } catch (ClassNotFoundException e) {
            if (exceptionHandler != null) {
                exceptionHandler.accept(e);
            }
            return null;
        }
    }

    /**
     * 将会获取org.bukkit.craftbukkit.&lt;版本&gt;.&lt;className&gt;类
     *
     * @param className org.bukkit.craftbukkit.&lt;版本&gt; 包下的类名
     * @return 获取到的类
     * @throws ClassNotFoundException 当找不到类时抛出
     */
    public static @NotNull Class<?> getCraftBukkitClass(@NotNull String className) throws ClassNotFoundException {
        return Class.forName(Bukkit.getServer().getClass().getName()
                .replace("CraftServer", className));
    }

    /**
     * 将会获取org.bukkit.craftbukkit.&lt;版本&gt;.&lt;className&gt;类
     * 并将异常交由异常处理器处理
     *
     * @param className org.bukkit.craftbukkit.&lt;版本&gt; 包下的类名
     * @param exceptionHandler 异常处理器，可为空
     * @return 获取到的类
     */
    public static @Nullable Class<?> getCraftBukkitClass(@NotNull String className, @Nullable IExceptionHandler<ClassNotFoundException> exceptionHandler) {
        try {
            return getCraftBukkitClass(className);
        } catch (ClassNotFoundException e) {
            if (exceptionHandler != null) {
                exceptionHandler.accept(e);
            }
            return null;
        }
    }

    public static @NotNull String getVersion() {
        return Bukkit.getServer().getClass().getName()
                .replace("org.bukkit.craftbukkit.", "")
                .replace(".CraftServer", "");
    }

    /**
     * 判断服务器是否&lt;=1.17，若不小于，则应该使用新版命名（Mojang映射）
     *
     * @return 服务端是否&lt;=1.17
     */
    public static boolean isLegacy() {
        try {
            Class.forName("net.minecraft.server.MinecraftServer");
            return false;
        } catch (ClassNotFoundException e) {
            return true;
        }
    }
}
