package be.paquya.fighttt_api.services;

import be.paquya.fighttt_api.models.dtos.MemberSessionDTO;
import be.paquya.fighttt_api.models.forms.MemberLoginForm;
import be.paquya.fighttt_api.models.forms.MemberRegisterForm;
import org.springframework.stereotype.Service;

@Service
public interface MemberService {

    MemberSessionDTO login(MemberLoginForm memberLoginForm);

    MemberSessionDTO register(MemberRegisterForm memberRegisterForm);
}
