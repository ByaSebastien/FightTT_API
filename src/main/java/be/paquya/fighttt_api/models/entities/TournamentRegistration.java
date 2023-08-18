package be.paquya.fighttt_api.models.entities;

import jakarta.persistence.*;
import lombok.*;

import java.io.Serializable;
import java.time.LocalDateTime;

@Entity
@NoArgsConstructor @AllArgsConstructor @Builder @ToString @EqualsAndHashCode
public class TournamentRegistration implements Serializable {

    @Getter
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "REGISTRATION_ID")
    private Integer id;

    @Getter @Setter
    @Column(name = "REGISTRATION_DATE",nullable = false) @Temporal(TemporalType.TIMESTAMP)
    private LocalDateTime registrationDate;
}
