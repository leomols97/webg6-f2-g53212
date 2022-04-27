package g53212.webg6.pae.model;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.validation.constraints.NotBlank;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import javax.validation.constraints.Min;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Course {

    @Id
    @NotBlank(message = "Le champs pour l'id du cours ne peut pas être vide !")
    private String id;

    @NotBlank(message = "Le champs pour le titre du cours ne peut pas être vide !")
    private String title;

    // @NotBlank(message = "Le champs pour les ECTS du cours ne peut pas être vide
    // !") --> ceci n'est pas reconnu
    @Min(1)
    private int ects;

    // @Query("SELECT course FROM courses c WHERE c.id=:searchID")
    // public static Course getCourse(@Param("searchID") String id) {
    // }
}