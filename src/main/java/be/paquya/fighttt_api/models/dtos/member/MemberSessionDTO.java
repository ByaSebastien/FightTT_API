package be.paquya.fighttt_api.models.dtos.member;

import be.paquya.fighttt_api.models.entities.Member;
import be.paquya.fighttt_api.models.entities.Role;
import lombok.*;

import java.util.Set;

@Getter @Setter @NoArgsConstructor @AllArgsConstructor @Builder @ToString @EqualsAndHashCode
public class MemberSessionDTO {

    private Long id;

    private String username;

    private Set<Role> roles;

    private String token;

    public MemberSessionDTO(Long id, String username, Set<Role> roles) {
        this.id = id;
        this.username = username;
        this.roles = roles;
    }

    public static MemberSessionDTO fromEntity(Member m){
        return new MemberSessionDTO(m.getId(),m.getUsername(),m.getRoles());
    }
}
