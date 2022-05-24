package g52006.webg6.tasks.entity;

import java.util.Collection;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.SequenceGenerator;
import javax.validation.constraints.NotBlank;

import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@NoArgsConstructor
public class Task {
    
    @Id
    @GeneratedValue(generator = "my_gen", strategy = GenerationType.SEQUENCE)
    @SequenceGenerator(name = "my_gen", sequenceName = "my_seq", allocationSize = 50)
    private int id;

    @NotBlank(message = "La description ne peut pas être vide")
    private String description;

    @ManyToMany(mappedBy = "tasks", fetch = FetchType.LAZY)
    private Collection<Student> students;
}
