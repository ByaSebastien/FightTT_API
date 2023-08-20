package be.paquya.fighttt_api.models.entities;

import be.paquya.fighttt_api.models.enums.Rules;
import be.paquya.fighttt_api.models.enums.Status;
import jakarta.persistence.*;
import lombok.*;

import java.io.Serializable;
import java.time.LocalDateTime;
import java.util.Set;

@Entity
@NoArgsConstructor @AllArgsConstructor @Builder @ToString
public class Tournament implements Serializable {

    @Getter
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "TOURNAMENT_ID")
    private Integer id;

    @Getter @Setter
    @Column(nullable = false,length = 100)
    private String name;

    @Getter @Setter
    @Column(nullable = false,length = 100)
    private String location;

    @Getter @Setter
    @Column(name = "MIN_PLAYERS", nullable = false)
    private Integer minPlayers;

    @Getter @Setter
    @Column(name = "MAX_PLAYERS", nullable = false)
    private Integer maxPlayers;

    @Getter @Setter
    @Column(nullable = false) @Enumerated(EnumType.STRING)
    private Status status;

    @Getter @Setter
    @Column(name = "CURRENT_ROUND",nullable = true)
    private int currentRound;

    @Getter @Setter
    @Column(name = "CREATION_DATE",nullable = false) @Temporal(TemporalType.TIMESTAMP)
    private LocalDateTime creationDate;

    @Getter @Setter
    @Column(name = "UPDATE_DATE",nullable = true) @Temporal(TemporalType.TIMESTAMP)
    private LocalDateTime updateDate;

    @Getter @Setter
    @Column(name = "END_REGISTRATION",nullable = false) @Temporal(TemporalType.TIMESTAMP)
    private LocalDateTime endRegistration;

    @Getter @Setter
    @Column(name = "START_DATE",nullable = false) @Temporal(TemporalType.TIMESTAMP)
    private LocalDateTime startDate;

    @Getter @Setter
    @Column(nullable = false) @Enumerated(EnumType.STRING)
    private Rules rules;

    @OneToMany(mappedBy = "tournament",fetch = FetchType.LAZY)
    private Set<TournamentRegistration> registrations;

    @ManyToOne(fetch = FetchType.EAGER,cascade = CascadeType.PERSIST)
    private TournamentType type;

    @Getter
    @ManyToOne(fetch = FetchType.EAGER,cascade = CascadeType.PERSIST)
    private Game game;

    @OneToMany(mappedBy = "tournament",fetch = FetchType.LAZY)
    private Set<TournamentMatch> matches;

    public Tournament(
            String name,
            String location,
            Integer minPlayers,
            Integer maxPlayers,
            LocalDateTime endRegistration,
            LocalDateTime startDate,
            Rules rules) {
        this.name = name;
        this.location = location;
        this.minPlayers = minPlayers;
        this.maxPlayers = maxPlayers;
        this.endRegistration = endRegistration;
        this.startDate = startDate;
        this.rules = rules;
    }

    public void setGame(Game game){
        this.game = game;
        game.addTournament(this);
    }
}
