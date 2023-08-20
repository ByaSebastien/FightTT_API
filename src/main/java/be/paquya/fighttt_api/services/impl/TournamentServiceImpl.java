package be.paquya.fighttt_api.services.impl;

import be.paquya.fighttt_api.models.entities.Tournament;
import be.paquya.fighttt_api.models.enums.Status;
import be.paquya.fighttt_api.repositories.TournamentRepository;
import be.paquya.fighttt_api.services.TournamentService;
import org.springframework.stereotype.Service;

import java.sql.Timestamp;
import java.time.LocalDateTime;
import java.util.List;

@Service
public class TournamentServiceImpl implements TournamentService {
    private final TournamentRepository tournamentRepository;

    public TournamentServiceImpl(TournamentRepository tournamentRepository) {
        this.tournamentRepository = tournamentRepository;
    }

    @Override
    public Tournament getById(Integer id){
        return this.tournamentRepository.findById(id).orElseThrow(RuntimeException::new);
    }

    @Override
    public List<Tournament> getAll(){
        return this.tournamentRepository.findAll();
    }

    @Override
    public void delete(Integer id){
        Tournament tournament = this.getById(id);
        this.tournamentRepository.delete(tournament);
    }

    @Override
    public Tournament create(Tournament tournament){
        tournament.setStatus(Status.OPEN);
        tournament.setCreationDate(LocalDateTime.now());
        tournament.setUpdateDate(LocalDateTime.now());
        return this.tournamentRepository.save(tournament);
    }

    @Override
    public Tournament update(Tournament tournament){
        tournament.setUpdateDate(LocalDateTime.now());
        return this.tournamentRepository.save(tournament);
    }

}
