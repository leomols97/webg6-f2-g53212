package webg66.musique.entities;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.validation.constraints.NotBlank;

import com.fasterxml.jackson.annotation.JsonManagedReference;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Artist {


    @Id
    private String login;

    @NotBlank(message = "Le nom de l'artiste ne peut pas être négligé")
    private String name;

    @OneToMany(fetch = FetchType.LAZY, mappedBy = "artist")
    @JsonManagedReference
    private List<Track> tracks;
}
