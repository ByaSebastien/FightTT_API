package be.paquya.fighttt_api.controllers;

import be.paquya.fighttt_api.models.dtos.member.MemberSessionDTO;
import be.paquya.fighttt_api.models.entities.Member;
import be.paquya.fighttt_api.models.forms.member.MemberLoginForm;
import be.paquya.fighttt_api.models.forms.member.MemberRegisterForm;
import be.paquya.fighttt_api.services.MemberService;
import be.paquya.fighttt_api.utils.JwtUtils;
import jakarta.validation.Valid;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(path = "/api")
@CrossOrigin("*")
public class AuthController {

    private final MemberService memberService;
    private final JwtUtils jwtUtils;

    public AuthController(MemberService memberService,JwtUtils jwtUtils) {
        this.memberService = memberService;
        this.jwtUtils = jwtUtils;
    }

    @PostMapping(path = "/register")
    public ResponseEntity<MemberSessionDTO> register(
            @Valid
            @RequestBody MemberRegisterForm register
    ){
        Member member = memberService.register(register);
        String token = jwtUtils.generateToken(member);
        MemberSessionDTO memberSessionDTO = MemberSessionDTO.fromEntity(member);
        memberSessionDTO.setToken(token);
        return ResponseEntity.ok(memberSessionDTO);
    }

    @PostMapping(path = "/login")
    public ResponseEntity<MemberSessionDTO> login(
            @Valid
            @RequestBody MemberLoginForm login
            ){
        Member member = memberService.login(login);
        String token = jwtUtils.generateToken(member);
        MemberSessionDTO memberSessionDTO = MemberSessionDTO.fromEntity(member);
        memberSessionDTO.setToken(token);
        return ResponseEntity.ok(memberSessionDTO);
    }
}