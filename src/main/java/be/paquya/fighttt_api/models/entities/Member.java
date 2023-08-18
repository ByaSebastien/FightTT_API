package be.paquya.fighttt_api.models.entities;

import be.paquya.fighttt_api.models.enums.Gender;
import jakarta.persistence.*;
import lombok.*;

import java.io.Serializable;
import java.time.LocalDate;
import java.util.Set;

@NoArgsConstructor @AllArgsConstructor @Builder
@Entity
public class Member implements Serializable {

    @Getter
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "MEMBER_ID")
    private Integer id;

    @Getter @Setter
    @Column(nullable = false,length = 50)
    private String username;

    @Getter @Setter
    @Column(nullable = false,unique = true,length = 100)
    private String email;

    @Getter @Setter
    @Column(nullable = false,length = 100)
    private String password;

    @Getter @Setter
    @Column(nullable = false,length = 100)
    private String salt;

    @Getter @Setter
    @Column(nullable = true)
    @Temporal(TemporalType.DATE)
    private LocalDate birthdate;

    @Getter @Setter
    @Column(nullable = false)
    @Enumerated(EnumType.STRING)
    private Gender gender;

    @Getter @Setter
    @Column(name = "IS_DELETED",nullable = false)
    private boolean isDeleted = false;

    @ManyToMany(fetch = FetchType.EAGER)
    private Set<Role> roles;

    @OneToMany(mappedBy = "member",fetch = FetchType.LAZY)
    private Set<TournamentRegistration> registrations;

    @OneToMany(mappedBy = "member")
    private Set<MatchParticipation> participations;
}
