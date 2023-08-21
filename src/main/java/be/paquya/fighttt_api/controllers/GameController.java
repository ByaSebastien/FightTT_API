package be.paquya.fighttt_api.controllers;

import be.paquya.fighttt_api.models.dtos.game.GameDTO;
import be.paquya.fighttt_api.models.forms.game.GameForm;
import be.paquya.fighttt_api.services.GameService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(path = "/api/games")
public class GameController {
    private final GameService gameService;

    public GameController(GameService gameService) {
        this.gameService = gameService;
    }

    @GetMapping(path = "/name/{name}")
    public ResponseEntity<GameDTO> getByName(@PathVariable("name") String name){
        GameDTO gameDTO = GameDTO.fromEntity(this.gameService.getGameByName(name));
        return ResponseEntity.ok(gameDTO);
    }

    @GetMapping(path = "/id")
    public ResponseEntity<GameDTO> getById(@PathVariable("id") Long id){
        GameDTO gameDTO = GameDTO.fromEntity(this.gameService.getById(id));
        return ResponseEntity.ok(gameDTO);
    }

    @GetMapping()
    public ResponseEntity<List<GameDTO>> getAll() {
        List<GameDTO> games = this.gameService.getAll().stream().map(GameDTO::fromEntity).toList();
        return ResponseEntity.ok(games);
    }

    @PostMapping()
    public ResponseEntity<GameDTO> create(GameForm gameForm){
        GameDTO gameDTO = GameDTO.fromEntity(this.gameService.create(gameForm.toEntity()));
        return ResponseEntity.ok(gameDTO);
    }

    @PutMapping(path = "/{id}")
    public ResponseEntity<GameDTO> update(@PathVariable("id") Long id, GameForm gameForm){
        GameDTO gameDTO = GameDTO.fromEntity(this.gameService.update(id, gameForm.toEntity()));
        return ResponseEntity.ok(gameDTO);
    }
}
