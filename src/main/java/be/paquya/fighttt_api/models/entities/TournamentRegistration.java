package be.paquya.fighttt_api.models.entities;

import jakarta.persistence.*;
import lombok.*;

import java.io.Serializable;
import java.time.LocalDateTime;

@Entity @Table(name = "TOURNAMENT_REGISTRATION")
@EqualsAndHashCode(of = {"id","registrationDate"})
@ToString(of = {"id","registrationDate"})
public class TournamentRegistration implements Serializable {

    @EmbeddedId
    private TournamentRegistrationId id;

    @Getter @Setter
    @ManyToOne(fetch = FetchType.EAGER) @JoinColumn(name = "MEMBER_ID") @MapsId("memberId")
    private Member member;

    @Getter @Setter
    @ManyToOne(fetch = FetchType.EAGER) @JoinColumn(name = "TOURNAMENT_ID") @MapsId("tournamentId")
    private Tournament tournament;

    @Getter @Setter
    @Column(name = "REGISTRATION_DATE",nullable = false) @Temporal(TemporalType.TIMESTAMP)
    private LocalDateTime registrationDate;

    public TournamentRegistration(){
        this.id = new TournamentRegistrationId();
    }
}
