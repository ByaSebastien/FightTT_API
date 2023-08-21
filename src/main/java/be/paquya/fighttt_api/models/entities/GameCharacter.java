package be.paquya.fighttt_api.models.entities;

import jakarta.persistence.*;
import lombok.*;

import java.io.Serializable;
import java.util.Set;

@Entity
@EqualsAndHashCode(of = {"id","name"}) @ToString(of = {"id","name"})
@NoArgsConstructor @AllArgsConstructor @Builder
public class GameCharacter implements Serializable {

    @Getter
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "CHARACTER_ID")
    private Long id;

    @Getter @Setter
    @Column(nullable = false)
    private String name;

    @Getter @Setter
    @Column(nullable = false,unique = true,length = 100)
    private String image;

    @ManyToOne(fetch = FetchType.EAGER)
    private Game game;

    @OneToMany(mappedBy = "character")
    private Set<MatchParticipation> participations;
}
