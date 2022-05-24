package webg66.musique.entities;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Positive;

import com.fasterxml.jackson.annotation.JsonBackReference;

import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@NoArgsConstructor
public class Track {

    @Id
    private int id;

    @NotBlank
    private String title;

    @Positive
    private long stream;

    @ManyToOne
    @JsonBackReference
    private Artist artist;
}
