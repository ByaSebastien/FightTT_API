package be.paquya.fighttt_api.models.forms.validators;

import be.paquya.fighttt_api.models.forms.MemberRegisterForm;
import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintValidatorContext;

public class PasswordMatchValidator implements ConstraintValidator<PasswordMatch, MemberRegisterForm> {
    @Override
    public void initialize(PasswordMatch constraintAnnotation) {
        // Implémentation facultative si vous avez besoin d'initialiser le validateur avec des valeurs
//        ConstraintValidator.super.initialize(constraintAnnotation);
    }

    @Override
    public boolean isValid(MemberRegisterForm memberRegisterForm, ConstraintValidatorContext constraintValidatorContext) {
        String password = memberRegisterForm.getPassword();
        String confirmPassword = memberRegisterForm.getConfirmPassword();

        return password != null && password.equals(confirmPassword);
    }
}
