package be.paquya.fighttt_api.utils;

import be.paquya.fighttt_api.models.entities.*;
import be.paquya.fighttt_api.models.enums.Gender;
import be.paquya.fighttt_api.models.enums.Rules;
import be.paquya.fighttt_api.models.enums.Status;
import be.paquya.fighttt_api.repositories.GameRepository;
import be.paquya.fighttt_api.repositories.MemberRepository;
import be.paquya.fighttt_api.repositories.RoleRepository;
import be.paquya.fighttt_api.repositories.TournamentRepository;
import jakarta.transaction.Transactional;
import org.springframework.boot.CommandLineRunner;
import org.springframework.data.domain.Example;
import org.springframework.stereotype.Component;

import java.time.LocalDate;
import java.time.LocalDateTime;

@Component
public class DataInitializer implements CommandLineRunner {

    private final RoleRepository roleRepository;
    private final MemberRepository memberRepository;
    private final GameRepository gameRepository;
    private final TournamentRepository tournamentRepository;
    private final BCryptUtils bCryptUtils;

    public DataInitializer(
            BCryptUtils bCryptUtils,
            RoleRepository roleRepository,
            MemberRepository memberRepository,
            GameRepository gameRepository,
            TournamentRepository tournamentRepository) {
        this.bCryptUtils = bCryptUtils;
        this.roleRepository = roleRepository;
        this.memberRepository = memberRepository;
        this.gameRepository = gameRepository;
        this.tournamentRepository = tournamentRepository;
    }

    @Override
    @Transactional
    public void run(String... args) throws Exception {
        //region roles

        Role adminRole = new Role("Admin");
        Role memberRole = new Role("Member");

        //endregion

        //region members

        Member admin = new Member(
                "Admin",
                "admin@test.be",
                bCryptUtils.hash("test1234="),
                LocalDate.of(1991,3,27),
                Gender.HOMME);

        Member seb = new Member(
                "Bambino",
                "seb@test.be",
                bCryptUtils.hash("test1234="),
                LocalDate.of(1991,3,27),
                Gender.HOMME);

        Member antoine = new Member(
                "Never ban Shako",
                "antoine@test.be",
                bCryptUtils.hash("test1234="),
                LocalDate.of(1991,3,27),
                Gender.HOMME);

        Member lucas = new Member(
                "Pilkyo",
                "lucas@test.be",
                bCryptUtils.hash("test1234="),
                LocalDate.of(1991,3,27),
                Gender.HOMME);

        //endregion

        //region games

        Game streetFighter = new Game("Street fighter");

        //endregion

        //region tournaments

        Tournament tournament = new Tournament(
                "Les null",
                "Liège",
                8,
                16,
                LocalDateTime.of(2023,12,12,12,00,00),
                LocalDateTime.of(2024,1,1,12,00,00),
                Rules.BO5
        );
        tournament.setCreationDate(LocalDateTime.now());
        tournament.setStatus(Status.OPEN);

        //endregion

        //region tournament registration

        TournamentRegistration registration = new TournamentRegistration();
        registration.setMember(seb);
        registration.setTournament(tournament);
        registration.setRegistrationDate(LocalDateTime.now());

        //endregion

        admin.addRole(adminRole);
        admin.addRole(memberRole);
        seb.addRole(memberRole);
        antoine.addRole(memberRole);
        antoine.addRole(memberRole);
        tournament.setGame(streetFighter);

        roleRepository.save(adminRole);
        roleRepository.save(memberRole);
        memberRepository.save(admin);
        memberRepository.save(seb);
        memberRepository.save(antoine);
        memberRepository.save(lucas);
        gameRepository.save(streetFighter);
        tournamentRepository.save(tournament);
        tournament.addRegistration(registration);
        tournamentRepository.save(tournament);
        seb.addRegistration(registration);
        tournament.addRegistration(registration);
        memberRepository.save(seb);
        tournamentRepository.save(tournament);

        Member m = memberRepository.findById(2L).orElseThrow();
        TournamentRegistration r = m.getRegistrations().stream().findFirst().orElseThrow();
        Tournament t = r.getTournament();
        Game g = t.getGame();
    }
}
