package be.paquya.fighttt_api.models.entities;

import jakarta.persistence.*;
import lombok.*;

import java.io.Serializable;

@Entity
@NoArgsConstructor @AllArgsConstructor @Builder @ToString @EqualsAndHashCode
public class Role implements Serializable {

    @Getter
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column
    private Integer id;

    @Getter @Setter
    @Column(nullable = false,unique = true,length = 50)
    private String name;

    @Getter @Setter
    @Column(nullable = true)
    private String Description;
}
