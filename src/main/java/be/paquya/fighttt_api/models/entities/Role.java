package be.paquya.fighttt_api.models.entities;

import jakarta.persistence.*;
import lombok.*;

import java.io.Serializable;
import java.util.Set;

@Entity
@NoArgsConstructor @AllArgsConstructor @Builder @ToString @EqualsAndHashCode
public class Role implements Serializable {

    @Getter
    @Id @Column(nullable = false,unique = true,length = 50)
    private String name;

    @ManyToMany(mappedBy = "roles")
    private Set<Member> members;

    public Role(String name) {
        this.name = name;
    }
}
