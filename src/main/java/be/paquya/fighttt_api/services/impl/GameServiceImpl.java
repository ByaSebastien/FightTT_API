package be.paquya.fighttt_api.services.impl;

import be.paquya.fighttt_api.models.entities.Game;
import be.paquya.fighttt_api.repositories.GameRepository;
import be.paquya.fighttt_api.services.GameService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class GameServiceImpl implements GameService {
    private final GameRepository gameRepository;

    public GameServiceImpl(GameRepository gameRepository) {
        this.gameRepository = gameRepository;
    }

    @Override
    public Game getById(Integer id) {
        //TODO créer exception
        return this.gameRepository.findById(id).orElseThrow(RuntimeException::new);
    }

    @Override
    public Game getGameByName(String name) {
        //TODO créer exception
        return this.gameRepository.getGameByName(name).orElseThrow(RuntimeException::new);
    }

    @Override
    public List<Game> getAll() {
        return this.gameRepository.findAll();
    }

    @Override
    public Game create(Game game) {
        return gameRepository.save(game);
    }

    @Override
    public Game update(Integer id, Game g) {
        Game game = this.getById(id);
        game.setName(g.getName());

        return this.gameRepository.save(game);
    }
}
