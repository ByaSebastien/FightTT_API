package be.paquya.fighttt_api.services;

import be.paquya.fighttt_api.models.entities.Game;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public interface GameService {
    public Game getById(Long Id);
    public Game getGameByName(String name);
    public List<Game> getAll();
    public Game create(Game game);
    public Game update(Long id, Game game);
}
