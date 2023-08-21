package be.paquya.fighttt_api.models.entities;


import jakarta.persistence.*;
import lombok.*;

import java.io.Serializable;
import java.util.Set;

@Entity
@EqualsAndHashCode(of = {"id","name"})
@ToString(of = {"id","name"})
@NoArgsConstructor @AllArgsConstructor @Builder
public class TournamentType implements Serializable {
    @Getter
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "TYPE_ID")
    private Long id;

    @Getter @Setter
    @Column(nullable = false, unique = true, name = "NAME", length = 50)
    private String name;

    @Getter @Setter
    @Column(nullable = true, name = "DESCRIPTION")
    private String description;

    @OneToMany(mappedBy = "type",fetch = FetchType.LAZY)
    private Set<Tournament> tournaments;
}
