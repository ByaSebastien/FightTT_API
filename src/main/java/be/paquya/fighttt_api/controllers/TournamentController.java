package be.paquya.fighttt_api.controllers;

import be.paquya.fighttt_api.models.dtos.tournament.TournamentDetailDTO;
import be.paquya.fighttt_api.models.dtos.tournament.TournamentSimpleDTO;
import be.paquya.fighttt_api.models.entities.Tournament;
import be.paquya.fighttt_api.models.forms.tournament.TournamentForm;
import be.paquya.fighttt_api.services.TournamentService;
import org.springframework.data.domain.Page;
import org.springframework.http.RequestEntity;
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
    public ResponseEntity<TournamentDetailDTO> getById(
            @PathVariable("id") Long id
    ){
        TournamentDetailDTO tournamentDetailDTO = TournamentDetailDTO.fromEntity(this.tournamentService.getById(id));
        return ResponseEntity.ok(tournamentDetailDTO);
    }

    @GetMapping()
    public ResponseEntity<List<TournamentSimpleDTO>> getAll(
            @RequestParam(defaultValue = "0",required = false)
            Integer page,
            @RequestParam(defaultValue = "10",required = false)
            Integer size
    ) {
        Page<Tournament> tournaments = this.tournamentService.getAll(page,size);
        List<TournamentSimpleDTO> response = tournaments.stream()
                .map(TournamentSimpleDTO::fromEntity)
                .toList();
        return ResponseEntity.ok(response);
    }

    @PostMapping()
    public ResponseEntity<TournamentDetailDTO> create(
            @RequestBody TournamentForm tournamentForm
    ){
        TournamentDetailDTO tournamentDetailDTO = TournamentDetailDTO.fromEntity(this.tournamentService.create(tournamentForm.toEntity()));
        return ResponseEntity.ok(tournamentDetailDTO);
    }

    @PutMapping(path = "/{id}")
    public ResponseEntity<TournamentDetailDTO> update(
            @PathVariable("id") Long id,
            @RequestBody TournamentForm tournamentForm
    ){
        TournamentDetailDTO tournamentDetailDTO = TournamentDetailDTO.fromEntity(this.tournamentService.update(id,tournamentForm.toEntity()));
        return ResponseEntity.ok(tournamentDetailDTO);
    }

    @DeleteMapping()
    public ResponseEntity.BodyBuilder delete(
            @PathVariable("id") Long id
    ){
        this.tournamentService.delete(id);
        return ResponseEntity.ok();
    }
}
