package g52006.webg6.tasks.entity;

import java.util.Collection;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.validation.constraints.NotBlank;

import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@NoArgsConstructor
public class Student {

    @Id
    private int number;

    @NotBlank(message = "le nom de peut pas être vide")
    private String name;

    @ManyToMany(fetch = FetchType.LAZY)
    private Collection<Task> tasks;
}
