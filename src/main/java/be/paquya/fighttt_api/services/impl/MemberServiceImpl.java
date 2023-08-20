package be.paquya.fighttt_api.services.impl;

import be.paquya.fighttt_api.models.dtos.MemberSessionDTO;
import be.paquya.fighttt_api.models.entities.Member;
import be.paquya.fighttt_api.models.entities.Role;
import be.paquya.fighttt_api.models.forms.MemberLoginForm;
import be.paquya.fighttt_api.models.forms.MemberRegisterForm;
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
    private final JwtUtils jwtUtils;

    public MemberServiceImpl(MemberRepository memberRepository,BCryptUtils bCryptUtils,JwtUtils jwtUtils) {
        this.memberRepository = memberRepository;
        this.bCryptUtils = bCryptUtils;
        this.jwtUtils = jwtUtils;
    }

    @Override
    public MemberSessionDTO login(MemberLoginForm memberLoginForm) {
        Member member = memberRepository.getMemberByEmail(memberLoginForm.getEmail()).orElseThrow();
        if(!bCryptUtils.verify(memberLoginForm.getPassword(), member.getPassword())){
            //Todo creer exception
            throw new RuntimeException("Wrong password");
        }
        String token = jwtUtils.generateToken(member);
        MemberSessionDTO memberSessionDTO = MemberSessionDTO.fromEntity(member);
        memberSessionDTO.setToken(token);
        return memberSessionDTO;
    }

    @Override
    public MemberSessionDTO register(MemberRegisterForm memberRegisterForm) {
        if(memberRepository.existsByEmail(memberRegisterForm.getEmail())){
            //TODO Creer exception
            throw new RuntimeException();
        }
        Member member = memberRegisterForm.toEntity();
        member.setPassword(bCryptUtils.hash(member.getPassword()));
        member.addRole(new Role("Member"));
        Member newMember = memberRepository.save(member);
        String token = jwtUtils.generateToken(newMember);
        MemberSessionDTO memberSessionDTO = MemberSessionDTO.fromEntity(newMember);
        memberSessionDTO.setToken(token);
        return memberSessionDTO;
    }

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        return memberRepository.getMemberByUsername(username).orElseThrow();
    }
}
