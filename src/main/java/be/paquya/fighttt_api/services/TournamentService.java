package be.paquya.fighttt_api.services;

import be.paquya.fighttt_api.models.entities.Tournament;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Service;

@Service
public interface TournamentService {
    public Tournament getById(Long id);
    public Page<Tournament> getAll(int page, int size);
    public void delete(Long id);
    public Tournament create(Tournament tournament);
    public Tournament update(Long id,Tournament tournament);
}
