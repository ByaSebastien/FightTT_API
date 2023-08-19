package be.paquya.fighttt_api.repositories;

import be.paquya.fighttt_api.models.entities.Game;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface GameRepository extends JpaRepository<Game, Integer> {
    public Optional<Game> getGameByName(String name);
}
