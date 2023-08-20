package be.paquya.fighttt_api.services;

import be.paquya.fighttt_api.models.entities.Member;
import be.paquya.fighttt_api.models.forms.member.MemberLoginForm;
import be.paquya.fighttt_api.models.forms.member.MemberRegisterForm;
import org.springframework.stereotype.Service;

@Service
public interface MemberService {

    Member login(MemberLoginForm memberLoginForm);

    Member register(MemberRegisterForm memberRegisterForm);
}
