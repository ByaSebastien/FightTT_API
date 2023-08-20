package be.paquya.fighttt_api.utils;

import be.paquya.fighttt_api.models.entities.Member;
import be.paquya.fighttt_api.models.entities.Role;
import be.paquya.fighttt_api.models.enums.Gender;
import be.paquya.fighttt_api.repositories.MemberRepository;
import be.paquya.fighttt_api.repositories.RoleRepository;
import jakarta.persistence.GeneratedValue;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.time.LocalDate;

@Component
public class DataInitializer implements CommandLineRunner {

    private final MemberRepository memberRepository;
    private final RoleRepository roleRepository;
    private final BCryptUtils bCryptUtils;

    public DataInitializer(MemberRepository memberRepository,RoleRepository roleRepository,BCryptUtils bCryptUtils) {
        this.memberRepository = memberRepository;
        this.roleRepository = roleRepository;
        this.bCryptUtils = bCryptUtils;
    }

    @Override
    public void run(String... args) throws Exception {
        //region roles
        Role adminRole = new Role("Admin");
        roleRepository.save(adminRole);

        Role memberRole = new Role("Member");
        roleRepository.save(memberRole);
        //endregion

        //region members
        Member admin = new Member(
                "Admin",
                "admin@test.be",
                bCryptUtils.hash("test1234="),
                LocalDate.of(1991,3,27),
                Gender.HOMME);
        admin.addRole(adminRole);
        admin.addRole(memberRole);
        memberRepository.save(admin);

        Member seb = new Member(
                "Bambino",
                "seb@test.be",
                bCryptUtils.hash("test1234="),
                LocalDate.of(1991,3,27),
                Gender.HOMME);
        seb.addRole(memberRole);
        memberRepository.save(seb);

        Member antoine = new Member(
                "Never ban Shako",
                "antoine@test.be",
                bCryptUtils.hash("test1234="),
                LocalDate.of(1991,3,27),
                Gender.HOMME);
        antoine.addRole(memberRole);
        memberRepository.save(antoine);

        Member lucas = new Member(
                "Pilkyo",
                "lucas@test.be",
                bCryptUtils.hash("test1234="),
                LocalDate.of(1991,3,27),
                Gender.HOMME);
        antoine.addRole(memberRole);
        memberRepository.save(lucas);
        //endregion
    }
}
