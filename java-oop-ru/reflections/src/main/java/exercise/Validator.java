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
        Class<?> clazz = obj.getClass();

        for (Field field : clazz.getDeclaredFields()) {
            field.setAccessible(true); // Даем доступ к приватным полям
            if (field.isAnnotationPresent(NotNull.class)) {
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
        Class<?> clazz = obj.getClass();

        for (Field field : clazz.getDeclaredFields()) {
            field.setAccessible(true);
            List<String> errors = new ArrayList<>();

            if (field.isAnnotationPresent(NotNull.class)) {
                try {
                    if (field.get(obj) == null) {
                        errors.add("can not be null");
                    }
                } catch (IllegalAccessException e) {
                    e.printStackTrace();
                }
            }

            if (field.isAnnotationPresent(MinLength.class)) {
                MinLength minLengthAnnotation = field.getAnnotation(MinLength.class);
                int minLength = minLengthAnnotation.minLength();
                try {
                    String value = (String) field.get(obj);
                    if (value != null && value.length() < minLength) {
                        errors.add("length less than " + minLength);
                    }
                } catch (IllegalAccessException e) {
                    e.printStackTrace();
                }
            }

            if (!errors.isEmpty()) {
                notValidFields.put(field.getName(), errors);
            }
        }
        return notValidFields;
    }
}
// END
