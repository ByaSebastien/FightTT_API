package be.paquya.fighttt_api.models.entities;

import jakarta.persistence.*;
import lombok.*;

import java.util.HashSet;
import java.util.Set;

@Entity
@EqualsAndHashCode(of = {"id","name"}) @ToString(of = {"id","name"})
@NoArgsConstructor @AllArgsConstructor
public class Game {
    @Getter
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="GAME_ID")
    private Long id;

    @Getter @Setter
    @Column(nullable = false, unique = true, length = 100)
    private String name;

    @OneToMany(mappedBy = "game",fetch = FetchType.LAZY, cascade = CascadeType.PERSIST)
    private Set<Tournament> tournaments = new HashSet<>();

    @OneToMany(mappedBy = "game",fetch = FetchType.LAZY)
    private Set<GameCharacter> characters = new HashSet<>();

    public Game(String name) {
        this.name = name;
    }

    public Set<Tournament> getTournaments(){
        return Set.copyOf(this.tournaments);
    }

    public void addTournament(Tournament tournament){
        this.tournaments.add(tournament);
    }

    public void deleteTournament(Tournament tournament){
        this.tournaments.remove(tournament);
    }

    public Set<GameCharacter> getCharacters(){

        return Set.copyOf(this.characters);
    }

    public void addCharacters(GameCharacter character){
        this.characters.add(character);
    }

    public void deleteCharacters(GameCharacter character){
        this.characters.remove(character);
    }
}