package online.flowerinsnow.saussureautils.reflect;

import online.flowerinsnow.saussureautils.exception.LogicException;
import online.flowerinsnow.saussureautils.exception.ShouldNotOccurException;
import online.flowerinsnow.saussureautils.object.IExceptionHandler;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.Objects;

/**
 * 有关Java反射的常用类
 */
public abstract class ReflectUtils {
    private ReflectUtils() {
    }

    /**
     * 从对象中获取成员变量
     *
     * @param object 对象
     * @param fieldName 成员变量名
     * @return 获取的字段
     */
    public static @Nullable Object getField(@NotNull Object object, @NotNull String fieldName) {
        Objects.requireNonNull(object);
        Objects.requireNonNull(fieldName);
        try {
            Field field = object.getClass().getDeclaredField(fieldName);
            field.setAccessible(true);
            return field.get(object);
        } catch (NoSuchFieldException e) {
            throw new LogicException(e);
        } catch (IllegalAccessException e) {
            throw new ShouldNotOccurException(e);
        }
    }

    /**
     * 从对象中获取成员变量，并将其自动转换为对应类型
     *
     * @param object 对象
     * @param fieldName 成员变量名
     * @param type 对应类型
     * @return 转换后的获取的字段
     * @param <T> 对应类型
     * @throws ClassCastException 当转换错误时抛出
     */
    public static <T> @Nullable T getField(@NotNull Object object, @NotNull String fieldName, @NotNull Class<T> type) throws ClassCastException {
        Objects.requireNonNull(object);
        Objects.requireNonNull(fieldName);
        Objects.requireNonNull(type);
        return type.cast(getField(object, fieldName));
    }

    /**
     * 从类中获取静态变量
     *
     * @param cls 类
     * @param fieldName 静态变量名
     * @return 获取的字段
     */
    public static @Nullable Object getStatic(@NotNull Class<?> cls, @NotNull String fieldName) {
        Objects.requireNonNull(cls);
        Objects.requireNonNull(fieldName);
        try {
            Field field = cls.getDeclaredField(fieldName);
            field.setAccessible(true);
            return field.get(null);
        } catch (NoSuchFieldException e) {
            throw new LogicException(e);
        } catch (IllegalAccessException e) {
            throw new ShouldNotOccurException(e);
        }
    }

    /**
     * 从类中获取静态变量，并将其自动转换为对应类型
     *
     * @param cls 类
     * @param fieldName 静态变量名
     * @param type 对应类型
     * @return 转换后的获取的字段
     * @param <T> 对应类型
     * @throws ClassCastException 当转换错误时抛出
     */
    public static <T> @Nullable T getStatic(@NotNull Class<?> cls, @NotNull String fieldName, @NotNull Class<T> type) throws ClassCastException {
        Objects.requireNonNull(cls);
        Objects.requireNonNull(fieldName);
        Objects.requireNonNull(type);
        return type.cast(getStatic(cls, fieldName));
    }

    /**
     * 设置对象中的成员变量
     *
     * @param object 对象
     * @param fieldName 变量名
     * @param value 值
     */
    public static void putField(@NotNull Object object, @NotNull String fieldName, @Nullable Object value) {
        Objects.requireNonNull(object);
        Objects.requireNonNull(fieldName);
        try {
            Field field = object.getClass().getDeclaredField(fieldName);
            field.setAccessible(true);
            field.set(object, value);
        } catch (NoSuchFieldException e) {
            throw new LogicException(e);
        } catch (IllegalAccessException e) {
            throw new ShouldNotOccurException(e);
        }
    }

    /**
     * 设置类中的静态变量
     *
     * @param cls 类
     * @param fieldName 变量名
     * @param value 值
     */
    public static void putStatic(@NotNull Class<?> cls, @NotNull String fieldName, @Nullable Object value) {
        Objects.requireNonNull(cls);
        Objects.requireNonNull(fieldName);
        try {
            Field field = cls.getDeclaredField(fieldName);
            field.setAccessible(true);
            field.set(null, value);
        } catch (NoSuchFieldException e) {
            throw new LogicException(e);
        } catch (IllegalAccessException e) {
            throw new ShouldNotOccurException(e);
        }
    }

    /**
     * 调用对象中的成员方法，并将返回值转换到指定类型
     *
     * @param object 对象
     * @param methodName 方法名
     * @param paramTypes 方法的参数类型列表
     * @param params 调用参数
     * @return 转换后的返回值
     * @throws Throwable 当调用的方法抛出异常时抛出
     */
    public static @Nullable Object invokeVirtual(@NotNull Object object, @NotNull String methodName, @NotNull Class<?>[] paramTypes, @Nullable Object... params) throws Throwable {
        Objects.requireNonNull(object);
        Objects.requireNonNull(methodName);
        Objects.requireNonNull(paramTypes);
        try {
            Method method = object.getClass().getDeclaredMethod(methodName, paramTypes);
            method.setAccessible(true);
            return method.invoke(object, params);
        } catch (NoSuchMethodException e) {
            throw new LogicException(e);
        } catch (IllegalAccessException e) {
            throw new ShouldNotOccurException(e);
        } catch (InvocationTargetException e) {
            throw e.getCause();
        }
    }

    /**
     * 调用类中的静态方法，并将返回值转换到指定类型
     *
     * @param cls 类
     * @param methodName 方法名
     * @param paramTypes 方法的参数类型列表
     * @param params 调用参数
     * @return 转换后的返回值
     * @throws Throwable 当调用的方法抛出异常时抛出
     */
    public static @Nullable Object invokeStatic(@NotNull Class<?> cls, @NotNull String methodName, @NotNull Class<?>[] paramTypes, @Nullable Object... params) throws Throwable {
        Objects.requireNonNull(cls);
        Objects.requireNonNull(methodName);
        Objects.requireNonNull(paramTypes);
        try {
            Method method = cls.getDeclaredMethod(methodName, paramTypes);
            method.setAccessible(true);
            return method.invoke(null, params);
        } catch (NoSuchMethodException e) {
            throw new LogicException(e);
        } catch (IllegalAccessException e) {
            throw new ShouldNotOccurException(e);
        } catch (InvocationTargetException e) {
            throw e.getCause();
        }
    }

    /**
     * 调用对象中的成员方法，并将返回值转换到指定类型，将异常交给异常处理器处理
     *
     * @param object 对象
     * @param methodName 方法名
     * @param paramTypes 方法的参数类型列表
     * @param exceptionHandler 异常处理器
     * @param params 调用参数
     * @return 转换后的返回值
     */
    public static @Nullable Object invokeVirtual(@NotNull Object object, @NotNull String methodName, @NotNull Class<?>[] paramTypes, @Nullable IExceptionHandler<Throwable> exceptionHandler, @Nullable Object... params) {
        Objects.requireNonNull(object);
        Objects.requireNonNull(methodName);
        Objects.requireNonNull(paramTypes);
        try {
            Method method = object.getClass().getDeclaredMethod(methodName, paramTypes);
            method.setAccessible(true);
            return method.invoke(object, params);
        } catch (NoSuchMethodException e) {
            throw new LogicException(e);
        } catch (IllegalAccessException e) {
            throw new ShouldNotOccurException(e);
        } catch (InvocationTargetException e) {
            if (exceptionHandler != null) {
                exceptionHandler.accept(e.getCause());
            }
            return null;
        }
    }

    /**
     * 调用类中的静态方法，并将返回值转换到指定类型
     *
     * @param cls 类
     * @param methodName 方法名
     * @param paramTypes 方法的参数类型列表
     * @param exceptionHandler 异常处理器，可为空
     * @param params 调用参数
     * @return 转换后的返回值
     */
    public static @Nullable Object invokeStatic(@NotNull Class<?> cls, @NotNull String methodName, @NotNull Class<?>[] paramTypes, @Nullable IExceptionHandler<Throwable> exceptionHandler, @Nullable Object... params) {
        Objects.requireNonNull(cls);
        Objects.requireNonNull(methodName);
        Objects.requireNonNull(paramTypes);
        try {
            Method method = cls.getDeclaredMethod(methodName, paramTypes);
            method.setAccessible(true);
            return method.invoke(null, params);
        } catch (NoSuchMethodException e) {
            throw new LogicException(e);
        } catch (IllegalAccessException e) {
            throw new ShouldNotOccurException(e);
        } catch (InvocationTargetException e) {
            if (exceptionHandler != null) {
                exceptionHandler.accept(e.getCause());
            }
            return null;
        }
    }

    /**
     * 调用对象中的成员方法，并将返回值转换到指定类型
     *
     * @param object 对象
     * @param methodName 方法名
     * @param paramTypes 方法的参数类型列表
     * @param returnType 返回值类型，获取的返回值会被自动转换成这个类型并返回
     * @param params 调用参数
     * @return 转换后的返回值
     * @param <T> 指定类型
     * @throws Throwable 当调用的方法抛出异常时抛出
     */
    public static <T> @Nullable T invokeVirtual(@NotNull Object object, @NotNull String methodName, @NotNull Class<?>[] paramTypes, @NotNull Class<T> returnType, @Nullable Object... params) throws Throwable {
        Objects.requireNonNull(object);
        Objects.requireNonNull(methodName);
        Objects.requireNonNull(paramTypes);
        Objects.requireNonNull(returnType);
        try {
            Method method = object.getClass().getDeclaredMethod(methodName, paramTypes);
            method.setAccessible(true);
            return returnType.cast(method.invoke(object, params));
        } catch (NoSuchMethodException e) {
            throw new LogicException(e);
        } catch (IllegalAccessException e) {
            throw new ShouldNotOccurException(e);
        } catch (InvocationTargetException e) {
            throw e.getCause();
        }
    }

    /**
     * 调用类中的静态方法，并将返回值转换到指定类型
     *
     * @param cls 类
     * @param methodName 方法名
     * @param paramTypes 方法的参数类型列表
     * @param returnType 返回值类型，获取的返回值会被自动转换成这个类型并返回
     * @param params 调用参数
     * @return 转换后的返回值
     * @param <T> 指定类型
     * @throws Throwable 当调用的方法抛出异常时抛出
     */
    public static <T> @Nullable T invokeStatic(@NotNull Class<?> cls, @NotNull String methodName, @NotNull Class<?>[] paramTypes, @NotNull Class<T> returnType, @Nullable Object... params) throws Throwable {
        Objects.requireNonNull(cls);
        Objects.requireNonNull(methodName);
        Objects.requireNonNull(paramTypes);
        Objects.requireNonNull(returnType);
        try {
            Method method = cls.getDeclaredMethod(methodName, paramTypes);
            method.setAccessible(true);
            return returnType.cast(method.invoke(null, params));
        } catch (NoSuchMethodException e) {
            throw new LogicException(e);
        } catch (IllegalAccessException e) {
            throw new ShouldNotOccurException(e);
        } catch (InvocationTargetException e) {
            throw e.getCause();
        }
    }

    /**
     * 调用对象中的成员方法，并将返回值转换到指定类型，将异常交给异常处理器处理
     *
     * @param object 对象
     * @param methodName 方法名
     * @param paramTypes 方法的参数类型列表
     * @param exceptionHandler 异常处理器
     * @param returnType 返回值类型，获取的返回值会被自动转换成这个类型并返回
     * @param params 调用参数
     * @return 转换后的返回值
     * @param <T> 指定类型
     */
    public static <T> @Nullable T invokeVirtual(@NotNull Object object, @NotNull String methodName, @NotNull Class<?>[] paramTypes, @NotNull Class<T> returnType, @Nullable IExceptionHandler<Throwable> exceptionHandler, @Nullable Object... params) {
        Objects.requireNonNull(object);
        Objects.requireNonNull(methodName);
        Objects.requireNonNull(paramTypes);
        Objects.requireNonNull(returnType);
        try {
            Method method = object.getClass().getDeclaredMethod(methodName, paramTypes);
            method.setAccessible(true);
            return returnType.cast(method.invoke(object, params));
        } catch (NoSuchMethodException e) {
            throw new LogicException(e);
        } catch (IllegalAccessException e) {
            throw new ShouldNotOccurException(e);
        } catch (InvocationTargetException e) {
            if (exceptionHandler != null) {
                exceptionHandler.accept(e.getCause());
            }
            return null;
        }
    }

    /**
     * 调用类中的静态方法，并将返回值转换到指定类型
     *
     * @param cls 类
     * @param methodName 方法名
     * @param paramTypes 方法的参数类型列表
     * @param returnType 返回值类型，获取的返回值会被自动转换成这个类型并返回
     * @param exceptionHandler 异常处理器，可为空
     * @param params 调用参数
     * @return 转换后的返回值
     * @param <T> 指定类型
     */
    public static <T> @Nullable T invokeStatic(@NotNull Class<?> cls, @NotNull String methodName, @NotNull Class<?>[] paramTypes, @NotNull Class<T> returnType, @Nullable IExceptionHandler<Throwable> exceptionHandler, @Nullable Object... params) {
        Objects.requireNonNull(cls);
        Objects.requireNonNull(methodName);
        Objects.requireNonNull(paramTypes);
        Objects.requireNonNull(returnType);
        try {
            Method method = cls.getDeclaredMethod(methodName, paramTypes);
            method.setAccessible(true);
            return returnType.cast(method.invoke(null, params));
        } catch (NoSuchMethodException e) {
            throw new LogicException(e);
        } catch (IllegalAccessException e) {
            throw new ShouldNotOccurException(e);
        } catch (InvocationTargetException e) {
            if (exceptionHandler != null) {
                exceptionHandler.accept(e.getCause());
            }
            return null;
        }
    }

    /**
     * 调用Class.forName(String)，并将异常交由异常处理器处理
     *
     * @param name 类名
     * @param exceptionHandler 异常处理器，可为空
     * @return 获取的类
     */
    public static @Nullable Class<?> getClass(@NotNull String name, @Nullable IExceptionHandler<ClassNotFoundException> exceptionHandler) {
        Objects.requireNonNull(name);
        try {
            return Class.forName(name);
        } catch (ClassNotFoundException e) {
            if (exceptionHandler != null) {
                exceptionHandler.accept(e);
            }
            return null;
        }
    }

    /**
     * 获取包下的类
     *
     * @param pkg 包名
     * @param name 类名
     * @return 获取的类
     * @throws ClassNotFoundException if the class cannot be located
     */
    public static @NotNull Class<?> getClass(@NotNull String pkg, @NotNull String name) throws ClassNotFoundException {
        Objects.requireNonNull(pkg);
        Objects.requireNonNull(name);
        return Class.forName(pkg + "." + name);
    }

    /**
     * 获取包下的类，并将异常交由异常处理器处理
     *
     * @param pkg 包名
     * @param name 类名
     * @param exceptionHandler 异常处理器，可为空
     * @return 获取的类
     */
    public static @Nullable Class<?> getClass(@Nullable String pkg, @NotNull String name, @Nullable IExceptionHandler<ClassNotFoundException> exceptionHandler) {
        Objects.requireNonNull(name);
        return getClass((pkg == null ? "" : pkg + ".") + name, exceptionHandler);
    }

    /**
     * new一个类，调用构造方法
     *
     * @param cls 类
     * @param paramTypes 构造方法参数类型
     * @param params 参数
     * @return new出来的对象
     * @param <T> 类类型
     * @throws Throwable if the underlying constructor throws an exception.
     */
    public static <T> @NotNull T newInstance(@NotNull Class<T> cls, @NotNull Class<?>[] paramTypes, @Nullable Object... params) throws Throwable {
        Objects.requireNonNull(cls);
        Objects.requireNonNull(paramTypes);
        try {
            Constructor<T> constructor = cls.getDeclaredConstructor(paramTypes);
            constructor.setAccessible(true);
            return constructor.newInstance(params);
        } catch (NoSuchMethodException | InstantiationException e) {
            throw new LogicException(e);
        } catch (IllegalAccessException e) {
            throw new ShouldNotOccurException(e);
        } catch (InvocationTargetException e) {
            throw e.getCause();
        }
    }

    /**
     * new一个类，调用构造方法，并将异常交由异常处理器处理
     *
     * @param cls 类
     * @param paramTypes 构造方法参数类型
     * @param exceptionHandler 异常处理器，可为空
     * @param params 参数
     * @return new出来的对象
     * @param <T> 类类型
     */
    public static <T> @Nullable T newInstance(@NotNull Class<T> cls, @NotNull  Class<?>[] paramTypes, @Nullable IExceptionHandler<Throwable> exceptionHandler, @Nullable Object... params) {
        Objects.requireNonNull(cls);
        Objects.requireNonNull(paramTypes);
        try {
            Constructor<T> constructor = cls.getDeclaredConstructor(paramTypes);
            constructor.setAccessible(true);
            return constructor.newInstance(params);
        } catch (NoSuchMethodException | InstantiationException e) {
            throw new LogicException(e);
        } catch (IllegalAccessException e) {
            throw new ShouldNotOccurException(e);
        } catch (InvocationTargetException e) {
            if (exceptionHandler != null) {
                exceptionHandler.accept(e.getCause());
            }
            return null;
        }
    }
}
