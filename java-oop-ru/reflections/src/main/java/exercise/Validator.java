package exercise;

import java.lang.reflect.Field;
// BEGIN

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Validator {

    public static List<String> validate(Object obj) {
        List<String> notValidFields = new ArrayList<>();
        Field[] fields = obj.getClass().getDeclaredFields();

        for (Field field : fields) {
            if (field.isAnnotationPresent(NotNull.class)) {
                field.setAccessible(true);
                try {
                    if (field.get(obj) == null) {
                        notValidFields.add(field.getName());
                    }
                } catch (IllegalAccessException e) {
                    e.printStackTrace();
                }
            }
        }
        return notValidFields;
    }

    public static Map<String, List<String>> advancedValidate(Object obj) {
        Map<String, List<String>> notValidFields = new HashMap<>();
        Field[] fields = obj.getClass().getDeclaredFields();

        for (Field field : fields) {
            field.setAccessible(true);
            List<String> messages = new ArrayList<>();

            // Проверка для @NotNull
            if (field.isAnnotationPresent(NotNull.class)) {
                try {
                    if (field.get(obj) == null) {
                        messages.add("can not be null");
                    }
                } catch (IllegalAccessException e) {
                    e.printStackTrace();
                }
            }

            // Проверка для @MinLength
            if (field.isAnnotationPresent(MinLength.class)) {
                MinLength minLength = field.getAnnotation(MinLength.class);
                int minLen = minLength.minLength();
                try {
                    String value = (String) field.get(obj);
                    if (value != null && value.length() < minLen) {
                        messages.add("length less than " + minLen);
                    }
                } catch (IllegalAccessException e) {
                    e.printStackTrace();
                }
            }

            // Если есть какие-то сообщения, добавляем их в карту
            if (!messages.isEmpty()) {
                notValidFields.put(field.getName(), messages);
            }
        }

        return notValidFields;
    }
}
// END
