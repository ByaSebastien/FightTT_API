package be.paquya.fighttt_api.models.forms;

import be.paquya.fighttt_api.models.entities.Member;
import be.paquya.fighttt_api.models.entities.Role;
import be.paquya.fighttt_api.models.enums.Gender;
import be.paquya.fighttt_api.models.forms.validators.PasswordMatch;
import jakarta.validation.constraints.*;
import lombok.*;

import java.time.LocalDate;

@PasswordMatch
@Getter @Setter @NoArgsConstructor @AllArgsConstructor @Builder @ToString @EqualsAndHashCode
public class MemberRegisterForm {

    @NotBlank @Size(max = 50)
    private String username;
    @NotBlank @Email @Size(max = 100)
    private String email;
    @NotBlank @Size(min = 6,max = 50)
    private String password;
    @NotBlank @Size(min = 6,max = 50)
    private String confirmPassword;
    @Past
    private LocalDate birthdate;
    @NotNull
    private Gender gender;

    public Member toEntity(){

        return new Member(this.getUsername(),this.getEmail(),this.getPassword(),this.getBirthdate(),this.getGender());
    }
}
