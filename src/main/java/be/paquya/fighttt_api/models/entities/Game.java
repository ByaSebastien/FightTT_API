package be.paquya.fighttt_api.models.entities;

import jakarta.persistence.*;
import lombok.*;

@Entity
@NoArgsConstructor @AllArgsConstructor @Builder @ToString @EqualsAndHashCode

public class Game {
    @Getter
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="GAME_ID")
    private Integer id;

    @Getter @Setter
    @Column(nullable = false, unique = true, length = 100)
    private String name;
}
