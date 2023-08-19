package be.paquya.fighttt_api.controllers;

import be.paquya.fighttt_api.models.dtos.MemberSessionDTO;
import be.paquya.fighttt_api.models.forms.MemberLoginForm;
import be.paquya.fighttt_api.models.forms.MemberRegisterForm;
import be.paquya.fighttt_api.services.MemberService;
import jakarta.validation.Valid;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(path = "/api")
public class MemberController {

    private final MemberService memberService;

    public MemberController(MemberService memberService) {
        this.memberService = memberService;
    }

    @PostMapping(path = "/register")
    public ResponseEntity<MemberSessionDTO> register(
            @Valid
            @RequestBody MemberRegisterForm register
    ){
        return ResponseEntity.ok(memberService.register(register));
    }

    @PostMapping(path = "/login")
    public ResponseEntity<MemberSessionDTO> login(
            @Valid
            @RequestBody MemberLoginForm login
            ){
        return ResponseEntity.ok(memberService.login(login));
    }
}
