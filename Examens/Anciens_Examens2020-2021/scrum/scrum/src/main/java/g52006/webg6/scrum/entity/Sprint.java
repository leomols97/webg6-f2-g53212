package g52006.webg6.scrum.entity;

import java.util.Collection;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.SequenceGenerator;
import javax.validation.constraints.Positive;

@Entity
public class Sprint {
    
    @Id
    @GeneratedValue(generator = "my_gen", strategy = GenerationType.SEQUENCE)
    @SequenceGenerator(name="my_gen", sequenceName = "sprint_seq", allocationSize = 50)
    private int id;

    @Positive
    private int number;

    @Positive
    private int days;

    @OneToMany(mappedBy = "sprint")
    private Collection<Story> stories;

    @ManyToOne
    private Project project;
}
