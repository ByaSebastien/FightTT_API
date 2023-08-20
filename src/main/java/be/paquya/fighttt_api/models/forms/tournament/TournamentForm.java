package be.paquya.fighttt_api.models.forms.tournament;

import be.paquya.fighttt_api.models.entities.Tournament;
import be.paquya.fighttt_api.models.enums.Rules;
import be.paquya.fighttt_api.models.enums.Status;
import be.paquya.fighttt_api.models.forms.validators.NbPlayer;
import com.fasterxml.jackson.annotation.JsonFormat;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.Temporal;
import jakarta.persistence.TemporalType;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.*;
import org.hibernate.validator.constraints.Length;
import org.hibernate.validator.constraints.Range;
import org.springframework.format.annotation.DateTimeFormat;

import java.time.LocalDateTime;

@NbPlayer
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
    @NotNull @Temporal(TemporalType.TIMESTAMP)
    private LocalDateTime endRegistration;
    @NotNull @Temporal(TemporalType.TIMESTAMP)
    private LocalDateTime startDate;
    @NotNull @Enumerated(EnumType.STRING)
    private Rules rules;
    // todo GameDTO TournamentTypeDTO


    public Tournament toEntity(){

        return new Tournament(
                this.name,
                this.location,
                this.minPlayers,
                this.maxPlayers,
                this.endRegistration,
                this.startDate,
                this.rules
        );
    }
}