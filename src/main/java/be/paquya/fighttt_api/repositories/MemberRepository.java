package be.paquya.fighttt_api.repositories;

import be.paquya.fighttt_api.models.entities.Member;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface MemberRepository extends JpaRepository<Member,Long> {

    public Optional<Member> getMemberByUsername(String username);
    public Optional<Member> getMemberByEmail(String email);
    public boolean existsByEmail(String email);
}
