package g52006.webg6.quiz.entity;

import java.time.LocalDate;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.SequenceGenerator;
import javax.validation.constraints.NotNull;

import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@NoArgsConstructor
public class Answer {
    
    @Id
    @GeneratedValue(generator = "my_gen2" , strategy = GenerationType.SEQUENCE)
    @SequenceGenerator(name= "my_gen2", sequenceName = "answer_seq", allocationSize = 50)
    private int id;

    private boolean agree;

    //@NotNull
    private LocalDate date;

    @ManyToOne
    private Question question;

    @Override
    public String toString() {
        return "Answer [agree=" + agree + ", date=" + date + ", id=" + id + ", question=" + question + "]";
    }
}
