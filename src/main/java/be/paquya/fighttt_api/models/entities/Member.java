package be.paquya.fighttt_api.models.entities;

import be.paquya.fighttt_api.models.enums.Gender;
import jakarta.persistence.*;
import lombok.*;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.io.Serializable;
import java.time.LocalDate;
import java.util.Collection;
import java.util.HashSet;
import java.util.Set;

@AllArgsConstructor @Builder
@Entity
public class Member implements Serializable, UserDetails {

    @Getter
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "MEMBER_ID")
    private Integer id;

    @Getter @Setter
    @Column(nullable = false,length = 50,unique = true)
    private String username;

    @Getter @Setter
    @Column(nullable = false,unique = true,length = 100)
    private String email;

    @Getter @Setter
    @Column(nullable = false,length = 100)
    private String password;

    @Getter @Setter
    @Column(nullable = true)
    @Temporal(TemporalType.DATE)
    private LocalDate birthdate;

    @Getter @Setter
    @Column(nullable = false)
    @Enumerated(EnumType.STRING)
    private Gender gender;

    @Getter @Setter
    @Column(name = "IS_DELETED",nullable = false)
    private boolean isDeleted = false;

    @ManyToMany(fetch = FetchType.EAGER)
    private Set<Role> roles;

    @OneToMany(mappedBy = "member",fetch = FetchType.LAZY)
    private Set<TournamentRegistration> registrations;

    @OneToMany(mappedBy = "member")
    private Set<MatchParticipation> participations;

    public Member(){
        this.participations = new HashSet<>();
        this.registrations = new HashSet<>();
        this.roles = new HashSet<>();
    }

    public Member(String username, String email, String password, LocalDate birthdate, Gender gender) {
        this();
        this.username = username;
        this.email = email;
        this.password = password;
        this.birthdate = birthdate;
        this.gender = gender;
    }



    public Set<Role> getRoles(){
        return Set.copyOf(this.roles);
    }

    public void addRole(Role role){
        this.roles.add(role);
    }

    public void deleteRole(Role role){
        this.roles.remove(role);
    }

    public Set<TournamentRegistration> getRegistrations(){
        return Set.copyOf(this.registrations);
    }

    public void addRegistration(TournamentRegistration registration){
        this.registrations.add(registration);
    }

    public void deleteRegistration(TournamentRegistration registration){
        this.registrations.remove(registration);
    }

    public Set<MatchParticipation> getParticipations(){
        return Set.copyOf(participations);
    }

    public void addParticipation(MatchParticipation participation){
        this.participations.add(participation);
    }

    public void deleteParticipation(MatchParticipation participation){
        this.participations.remove(participation);
    }

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return getRoles().stream()
                .map(Role::toString)
                .map(SimpleGrantedAuthority::new)
                .toList();
    }

    @Override
    public boolean isAccountNonExpired() {
        return true;
    }

    @Override
    public boolean isAccountNonLocked() {
        return true;
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return true;
    }

    @Override
    public boolean isEnabled() {
        return !this.isDeleted;
    }
}
