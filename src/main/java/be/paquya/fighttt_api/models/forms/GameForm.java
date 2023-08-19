package be.paquya.fighttt_api.models.forms;

import be.paquya.fighttt_api.models.entities.Game;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.*;

@Getter @Setter @NoArgsConstructor @AllArgsConstructor @Builder @ToString @EqualsAndHashCode
public class GameForm {
    @NotBlank @Size(max = 100)
    private String name;

    public Game toEntity(){
        return new Game(this.name);
    }
}
