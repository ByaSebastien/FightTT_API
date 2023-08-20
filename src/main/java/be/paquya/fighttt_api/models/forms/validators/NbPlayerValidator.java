package be.paquya.fighttt_api.models.forms.validators;

import be.paquya.fighttt_api.models.forms.tournament.TournamentForm;
import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintValidatorContext;

public class NbPlayerValidator implements ConstraintValidator<NbPlayer, TournamentForm> {
    @Override
    public void initialize(NbPlayer constraintAnnotation) {
//        ConstraintValidator.super.initialize(constraintAnnotation);
    }

    @Override
    public boolean isValid(TournamentForm tournamentForm, ConstraintValidatorContext constraintValidatorContext) {
        return tournamentForm.getMinPlayers() <= tournamentForm.getMaxPlayers();
    }
}
