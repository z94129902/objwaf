package com.practice.campus.util;

import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.Method;

/**
 * 反射工具类。
 */
public class ReflectionUtil {
    public static void printClassInfo(String className) {
        try {
            Class<?> clazz = Class.forName(className);

            System.out.println("类名：" + clazz.getName());

            System.out.println("--- 属性 ---");
            Field[] fields = clazz.getDeclaredFields();
            if (fields.length == 0) {
                System.out.println("暂无属性");
            }
            for (Field field : fields) {
                System.out.println(field.getType().getSimpleName() + " " + field.getName());
            }

            System.out.println("--- 方法 ---");
            Method[] methods = clazz.getDeclaredMethods();
            if (methods.length == 0) {
                System.out.println("暂无方法");
            }
            for (Method method : methods) {
                System.out.println("方法名字是"+ method.getName());
                System.out.println("方法的返回值类型是" + method.getReturnType().getSimpleName());
                System.out.println("方法的参数类型：");
            	Class<?>[] parameterTypes = method.getParameterTypes();

                if (parameterTypes.length == 0) {
                    System.out.println("无");
                } else {
                    for (Class<?> parameterType : parameterTypes) {
                        System.out.print(parameterType.getSimpleName() + " ");
                    }
                    System.out.println();
                }
            }
            

            System.out.println("--- 构造方法 ---");
            Constructor<?>[] constructors = clazz.getDeclaredConstructors();
            if (constructors.length == 0) {
                System.out.println("暂无构造方法");
            }
            for (Constructor<?> constructor : constructors) {
                System.out.println(constructor.getName());
            }

            // TODO 新手练习：输出每个方法的参数类型和返回值类型。
        } catch (ClassNotFoundException e) {
            System.out.println("没有找到这个类，请检查完整类名是否正确：" + className);
        }
    }
}
