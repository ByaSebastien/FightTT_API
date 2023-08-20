package be.paquya.fighttt_api.services;

import be.paquya.fighttt_api.models.entities.Tournament;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface TournamentService {
    public Tournament getById(Integer id);
    public List<Tournament> getAll();
    public void delete(Integer id);
    public Tournament create(Tournament tournament);
    public Tournament update(Tournament tournament);
}
