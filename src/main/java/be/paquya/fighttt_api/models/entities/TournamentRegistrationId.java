package be.paquya.fighttt_api.models.entities;

import jakarta.persistence.Column;
import jakarta.persistence.Embeddable;
import lombok.*;

import java.io.Serializable;

@Embeddable
@NoArgsConstructor @AllArgsConstructor
@EqualsAndHashCode(of = {"memberId","tournamentId"})
@ToString(of = {"memberId","tournamentId"})
public class TournamentRegistrationId implements Serializable {
    @Getter @Setter
    @Column(name = "MEMBER_ID")
    private Long memberId;
    @Getter @Setter
    @Column(name = "TOURNAMENT_ID")
    private Long tournamentId;
}
