package be.paquya.fighttt_api.models.entities;

import jakarta.persistence.*;
import lombok.*;

import java.io.Serializable;

@Entity
@NoArgsConstructor @AllArgsConstructor @Builder @ToString @EqualsAndHashCode
public class GameCharacter implements Serializable {

    @Getter
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "CHARACTER_ID")
    private Integer id;

    @Getter @Setter
    @Column(nullable = false)
    private String name;
}
