package be.paquya.fighttt_api.models.dtos;

import be.paquya.fighttt_api.models.entities.Game;
import be.paquya.fighttt_api.models.entities.Tournament;
import lombok.*;

import java.util.Set;

@Getter @Setter @NoArgsConstructor @AllArgsConstructor @Builder @ToString @EqualsAndHashCode
public class GameDTO {
    private Integer id;
    private String name;

    public static GameDTO fromEntity(Game game){
        return new GameDTO(game.getId(), game.getName());
    }
}
