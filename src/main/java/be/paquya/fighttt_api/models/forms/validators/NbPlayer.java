package be.paquya.fighttt_api.models.forms.validators;

import jakarta.validation.Payload;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Target(ElementType.TYPE)
@Retention(RetentionPolicy.RUNTIME)
public @interface NbPlayer {
    String message() default "Max players must be upper than min players";
    Class<?>[] groups() default {};
    Class<? extends Payload>[] payload() default {};
}
