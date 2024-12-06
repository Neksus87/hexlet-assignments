package exercise;

import java.lang.annotation.Target;
import java.lang.annotation.Retention;
import java.lang.annotation.ElementType;
import java.lang.annotation.RetentionPolicy;

@Target(value = ElementType.FIELD)
@Retention(RetentionPolicy.RUNTIME)
public @interface MinLength {
    // Изменено на minLength, чтобы соответствовать тому, как аннотация используется
    int minLength() default 3;
}
