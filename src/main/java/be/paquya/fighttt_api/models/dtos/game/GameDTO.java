package be.paquya.fighttt_api.models.dtos.game;

import be.paquya.fighttt_api.models.entities.Game;
import lombok.*;

@Getter @Setter @NoArgsConstructor @AllArgsConstructor @Builder @ToString @EqualsAndHashCode
public class GameDTO {
    private Integer id;
    private String name;

    public static GameDTO fromEntity(Game game){
        return new GameDTO(game.getId(), game.getName());
    }
}
