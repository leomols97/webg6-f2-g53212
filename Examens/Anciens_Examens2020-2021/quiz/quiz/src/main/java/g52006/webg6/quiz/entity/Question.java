package g52006.webg6.quiz.entity;

import java.util.Collection;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.SequenceGenerator;
import javax.validation.constraints.NotBlank;

import lombok.Data;

@Entity
@Data
public class Question {
    
    @Id
    @GeneratedValue(generator = "my_gen1" , strategy = GenerationType.SEQUENCE)
    @SequenceGenerator(name= "my_gen1", sequenceName = "question_seq", allocationSize = 50)
    private int number;

    @NotBlank
    private String text;

    @OneToMany(mappedBy = "question", fetch = FetchType.LAZY)
    private Collection<Answer> answers;
}
