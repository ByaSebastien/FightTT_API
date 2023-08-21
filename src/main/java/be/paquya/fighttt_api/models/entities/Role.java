package be.paquya.fighttt_api.models.entities;

import jakarta.persistence.*;
import lombok.*;

import java.io.Serializable;
import java.util.HashSet;
import java.util.Objects;
import java.util.Set;

@Entity
@EqualsAndHashCode(of = {"name"}) @ToString(of = {"name"})
public class Role implements Serializable {

    @Getter
    @Id @Column(nullable = false,unique = true,length = 50)
    private String name;

    @ManyToMany(mappedBy = "roles")
    private Set<Member> members;

    public Role(){
        this.members = new HashSet<>();
    }
    public Role(String name) {
        this();
        this.name = name;
    }

    public Set<Member> getMembers() {
        return members;
    }

    public void addMember(Member member){
        this.members.add(member);
    }

    public void deleteMember(Member member){
        this.members.remove(member);
    }

    public static Role copyOf(Role role){
        return new Role(role.getName());
    }
}
