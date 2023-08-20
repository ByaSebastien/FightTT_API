package be.paquya.fighttt_api.controllers;

import be.paquya.fighttt_api.models.dtos.GameDTO;
import be.paquya.fighttt_api.models.dtos.TournamentDTO;
import be.paquya.fighttt_api.models.forms.GameForm;
import be.paquya.fighttt_api.models.forms.TournamentForm;
import be.paquya.fighttt_api.services.TournamentService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(path = "/api/tournaments")
public class TournamentController {
    private final TournamentService tournamentService;

    public TournamentController(TournamentService tournamentService) {
        this.tournamentService = tournamentService;
    }

    @GetMapping(path = "{id}")
    public ResponseEntity<TournamentDTO> getById(@PathVariable("id") Integer id){
        TournamentDTO tournamentDTO = TournamentDTO.fromEntity(this.tournamentService.getById(id));
        return ResponseEntity.ok(tournamentDTO);
    }

    @GetMapping()
    public ResponseEntity<List<TournamentDTO>> getAll() {
        List<TournamentDTO> tournaments = this.tournamentService.getAll().stream().map(TournamentDTO::fromEntity).toList();
        return ResponseEntity.ok(tournaments);
    }

    @PostMapping()
    public ResponseEntity<TournamentDTO> create(TournamentForm tournamentForm){
        TournamentDTO tournamentDTO = TournamentDTO.fromEntity(this.tournamentService.create(tournamentForm.toEntity()));
        return ResponseEntity.ok(tournamentDTO);
    }

    @PutMapping(path = "/{id}")
    public ResponseEntity<TournamentDTO> update(@PathVariable("id") Integer id, TournamentForm tournamentForm){
        TournamentDTO tournamentDTO = TournamentDTO.fromEntity(this.tournamentService.update(tournamentForm.toEntity()));
        return ResponseEntity.ok(tournamentDTO);
    }

    @DeleteMapping()
    public ResponseEntity<Boolean> delete(@PathVariable("id") Integer id){
        this.tournamentService.delete(id);
        return ResponseEntity.ok(true);
    }
}
