package be.paquya.fighttt_api.services.impl;

import be.paquya.fighttt_api.models.entities.Tournament;
import be.paquya.fighttt_api.models.enums.Status;
import be.paquya.fighttt_api.repositories.TournamentRepository;
import be.paquya.fighttt_api.services.TournamentService;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
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
    public Tournament getById(Long id){
        return this.tournamentRepository.findById(id).orElseThrow();
    }

    @Override
    public Page<Tournament> getAll(int page, int size){
        return this.tournamentRepository.findAll(PageRequest.of(page,size));
    }

    @Override
    public void delete(Long id){
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
    public Tournament update(Long id, Tournament tournament){
        Tournament tournamentToChange = tournamentRepository.findById(id).orElseThrow();
        tournamentToChange.setName(tournament.getName());
        tournamentToChange.setLocation(tournament.getLocation());
        tournamentToChange.setMinPlayers(tournament.getMinPlayers());
        tournamentToChange.setMaxPlayers(tournament.getMaxPlayers());
        tournamentToChange.setEndRegistration(tournament.getEndRegistration());
        tournamentToChange.setStartDate(tournament.getStartDate());
        tournamentToChange.setRules(tournament.getRules());
        tournamentToChange.setUpdateDate(LocalDateTime.now());
        return this.tournamentRepository.save(tournament);
    }

}
