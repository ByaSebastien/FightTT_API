package be.paquya.fighttt_api.models.dtos;

import be.paquya.fighttt_api.models.entities.Tournament;
import be.paquya.fighttt_api.models.enums.Status;
import lombok.*;

import java.time.LocalDateTime;
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
@ToString @EqualsAndHashCode

public class TournamentDTO {
    private Integer id;
    private String name;
    private String location;
    private Integer minPlayers;
    private Integer maxPlayers;
    private Status status;
    private int currentRound;
    private LocalDateTime creationDate;
    private LocalDateTime updateDate;
    private LocalDateTime endRegistration;
    private LocalDateTime startDate;

    public static TournamentDTO fromEntity(Tournament t){
        return new TournamentDTO(t.getId(), t.getName(), t.getLocation(), t.getMinPlayers(), t.getMaxPlayers(), t.getStatus(),
                t.getCurrentRound(), t.getCreationDate(), t.getUpdateDate(), t.getEndRegistration(), t.getStartDate());
    }
}
