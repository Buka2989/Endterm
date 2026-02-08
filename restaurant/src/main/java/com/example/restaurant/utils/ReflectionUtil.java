package com.example.restaurant.utils;

import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.util.Arrays;


public class ReflectionUtil {

    public static String inspectClass(Object obj) {
        Class<?> clazz = obj.getClass();
        StringBuilder sb = new StringBuilder();

        sb.append("=== Reflection Analysis ===\n");
        sb.append("Class Name: ").append(clazz.getSimpleName()).append("\n");

        sb.append("Fields: \n");
        Arrays.stream(clazz.getDeclaredFields())
                .forEach(field -> sb.append(" - ").append(field.getName())
                        .append(" (").append(field.getType().getSimpleName()).append(")\n"));

        sb.append("Methods: \n");
        Arrays.stream(clazz.getDeclaredMethods())
                .forEach(method -> sb.append(" - ").append(method.getName()).append("()\n"));

        return sb.toString();
    }
}