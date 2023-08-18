package be.paquya.fighttt_api.models.entities;

import be.paquya.fighttt_api.models.enums.Result;
import jakarta.persistence.*;
import lombok.*;

import java.util.Set;

@Entity
@NoArgsConstructor @AllArgsConstructor @Builder @ToString @EqualsAndHashCode

public class TournamentMatch {
    @Getter
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "MATCH_ID")
    private Integer id;

    @Getter @Setter
    @Column(name = "PLAYER1_SCORE", nullable = true)
    private Integer playerOneScore;

    @Getter @Setter
    @Column(name = "PLAYER2_SCORE", nullable = true)
    private Integer playerTwoScore;

    @Getter @Setter
    @Column(name = "MATCH_RESULT", nullable = true) @Enumerated(EnumType.STRING)
    private Result result;

    @ManyToOne(fetch = FetchType.EAGER)
    private Tournament tournament;

    @OneToMany(mappedBy = "match")
    private Set<MatchParticipation> participations;
}
