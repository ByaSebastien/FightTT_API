package be.paquya.fighttt_api.models.forms.member;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.*;

@Getter @Setter @NoArgsConstructor @AllArgsConstructor @Builder @ToString @EqualsAndHashCode
public class MemberLoginForm {

    @NotBlank @Email @Size(max = 100)
    private String email;

    @NotBlank @Size(min = 6,max = 50)
    private String password;
}
