package be.paquya.fighttt_api.utils;

import be.paquya.fighttt_api.models.entities.Member;
import be.paquya.fighttt_api.models.enums.Gender;
import be.paquya.fighttt_api.repositories.MemberRepository;
import jakarta.persistence.GeneratedValue;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.time.LocalDate;

@Component
public class DataInitializer implements CommandLineRunner {

    private final MemberRepository memberRepository;

    public DataInitializer(MemberRepository memberRepository) {
        this.memberRepository = memberRepository;
    }

    @Override
    public void run(String... args) throws Exception {
        Member admin = new Member(
                "Admin",
                "Admin@admin.be",
                "test1234=",
                LocalDate.of(1991,3,27),
                Gender.HOMME);

        memberRepository.save(admin);
    }
}
