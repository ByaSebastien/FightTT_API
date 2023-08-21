package be.paquya.fighttt_api.services.impl;

import be.paquya.fighttt_api.models.entities.Member;
import be.paquya.fighttt_api.models.entities.Role;
import be.paquya.fighttt_api.models.forms.member.MemberLoginForm;
import be.paquya.fighttt_api.models.forms.member.MemberRegisterForm;
import be.paquya.fighttt_api.repositories.MemberRepository;
import be.paquya.fighttt_api.services.MemberService;
import be.paquya.fighttt_api.utils.BCryptUtils;
import be.paquya.fighttt_api.utils.JwtUtils;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
public class MemberServiceImpl implements MemberService, UserDetailsService {

    private final MemberRepository memberRepository;
    private final BCryptUtils bCryptUtils;

    public MemberServiceImpl(MemberRepository memberRepository,BCryptUtils bCryptUtils,JwtUtils jwtUtils) {
        this.memberRepository = memberRepository;
        this.bCryptUtils = bCryptUtils;
    }

    @Override
    public Member login(MemberLoginForm memberLoginForm) {
        Member member = memberRepository.getMemberByEmail(memberLoginForm.getEmail()).orElseThrow();
        if(!bCryptUtils.verify(memberLoginForm.getPassword(), member.getPassword())){
            //Todo creer exception
            throw new RuntimeException("Wrong password");
        }
        return member;
    }

    @Override
    public Member register(MemberRegisterForm memberRegisterForm) {
        if(memberRepository.existsByEmail(memberRegisterForm.getEmail())){
            //TODO Creer exception
            throw new RuntimeException();
        }
        Member member = memberRegisterForm.toEntity();
        String hashedPassword = bCryptUtils.hash(member.getPassword());
        member.setPassword(hashedPassword);
        member.addRole(new Role("Member"));
        return memberRepository.save(member);
    }

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        return memberRepository.getMemberByUsername(username).orElseThrow();
    }
}
