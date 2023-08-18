package be.paquya.fighttt_api.repositories;

import be.paquya.fighttt_api.models.entities.Member;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface MemberRepository extends JpaRepository<Member,Integer> {


    public Member getMemberByUsername(String username);

    public boolean existsByUsername(String username);
}
