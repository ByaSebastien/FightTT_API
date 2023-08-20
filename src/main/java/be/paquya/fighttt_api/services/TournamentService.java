package be.paquya.fighttt_api.services;

import be.paquya.fighttt_api.models.entities.Tournament;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Service;

@Service
public interface TournamentService {
    public Tournament getById(Integer id);
    public Page<Tournament> getAll(int page, int size);
    public void delete(Integer id);
    public Tournament create(Tournament tournament);
    public Tournament update(Integer id,Tournament tournament);
}
