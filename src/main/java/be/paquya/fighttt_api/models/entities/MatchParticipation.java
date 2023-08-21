package be.paquya.fighttt_api.models.entities;

import jakarta.persistence.*;

import java.io.Serializable;

@Entity
public class MatchParticipation implements Serializable {

    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "PARTICIPATION_ID")
    private Long id;

    @ManyToOne(fetch = FetchType.EAGER)
    private Member member;

    @ManyToOne(fetch = FetchType.EAGER)
    private GameCharacter character;

    @ManyToOne(fetch = FetchType.EAGER)
    private TournamentMatch match;
}
