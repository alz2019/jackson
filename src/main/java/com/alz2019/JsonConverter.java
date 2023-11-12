package com.alz2019;

import java.lang.reflect.Field;

public class JsonConverter {
    static String convertAnyObjectToJson(Object object) throws IllegalAccessException {
        StringBuilder stringBuilder = new StringBuilder();
        convertToJson(stringBuilder, object, 1);
        return stringBuilder.toString();
    }

    private static void convertToJson(StringBuilder stringBuilder, Object object, int tabs) throws IllegalAccessException {
        stringBuilder.append("{\n");
        Field[] fields = object.getClass().getDeclaredFields();
        for (int i = 0; i < fields.length; i++) {
            Field field = fields[i];
            field.setAccessible(true);
            String name = field.getName();
            Object value = field.get(object);
            stringBuilder.append("\t".repeat(tabs));
            stringBuilder.append("\"").append(name).append("\": ");
            if (value instanceof Number) {
                stringBuilder.append(value);
            } else if (value instanceof String) {
                stringBuilder.append("\"").append(value).append("\"");
            } else {
                convertToJson(stringBuilder, value, tabs + 1);
            }
            if (i < fields.length - 1) {
                stringBuilder.append(",");
            }
            stringBuilder.append("\n");
        }
        stringBuilder.append("\t".repeat(tabs - 1)).append("}");
    }
}
