package be.paquya.fighttt_api.models.forms;

import be.paquya.fighttt_api.models.entities.Tournament;
import be.paquya.fighttt_api.models.enums.Status;
import com.fasterxml.jackson.annotation.JsonFormat;
import jakarta.validation.constraints.NotBlank;
import lombok.*;
import org.hibernate.validator.constraints.Length;
import org.hibernate.validator.constraints.Range;
import org.springframework.format.annotation.DateTimeFormat;

import java.time.LocalDateTime;
@Getter @Setter @NoArgsConstructor @AllArgsConstructor @Builder @ToString @EqualsAndHashCode
public class TournamentForm {
    @NotBlank @Length(max = 100)
    private String name;
    @NotBlank @Length(max = 100)
    private String location;
    @NotBlank @Range(min = 2)
    private Integer minPlayers;
    @NotBlank @Range(min = 2)
    private Integer maxPlayers;
    @NotBlank @DateTimeFormat(pattern="dd-MM-yyyy")
    private LocalDateTime endRegistration;
    @NotBlank @DateTimeFormat(pattern="dd-MM-yyyy")
    private LocalDateTime startDate;

    public Tournament toEntity(){
        Tournament t = new Tournament();
        t.setName(this.getName());
        t.setLocation(this.getLocation());
        t.setMinPlayers(this.getMinPlayers());
        t.setMaxPlayers(this.getMaxPlayers());
        t.setEndRegistration(this.getEndRegistration());
        t.setStartDate(this.getStartDate());

        return t;
    }
}
