package be.paquya.fighttt_api.models.dtos.tournament;

import be.paquya.fighttt_api.models.entities.Tournament;
import be.paquya.fighttt_api.models.enums.Rules;
import be.paquya.fighttt_api.models.enums.Status;
import lombok.*;

import java.time.LocalDateTime;

@Getter @Setter @NoArgsConstructor @AllArgsConstructor @Builder @ToString @EqualsAndHashCode
public class TournamentSimpleDTO {
    private Integer id;
    private String name;
    private String location;
    private Status status;
    private LocalDateTime startDate;
    private Rules rules;

    public static TournamentSimpleDTO fromEntity(Tournament t){
        return new TournamentSimpleDTO(
                t.getId(),
                t.getName(),
                t.getLocation(),
                t.getStatus(),
                t.getStartDate(),
                t.getRules());
    }
}
