package webg66.commitManager.entities;

import java.util.Collection;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.SequenceGenerator;
import javax.validation.constraints.NotBlank;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonManagedReference;

import lombok.Data;


@Entity
@Data
public class Repository {
    
    @Id
    @GeneratedValue(generator = "my_gen", strategy = GenerationType.SEQUENCE)
    @SequenceGenerator(name = "my_gen", sequenceName = "my_seq")
    private int id;

    @NotBlank(message = "Le dépôt doit avoir un nom")
    private String name;

    @ManyToOne
    @JsonBackReference
    private User user;

    @OneToMany(mappedBy = "repository", fetch = FetchType.LAZY)
    @JsonManagedReference
    private Collection<CommitE> commits;
}
