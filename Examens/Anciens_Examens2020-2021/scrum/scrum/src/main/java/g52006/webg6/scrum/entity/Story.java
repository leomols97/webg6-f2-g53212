package g52006.webg6.scrum.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.SequenceGenerator;
import javax.validation.constraints.Positive;

import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@NoArgsConstructor
public class Story {
    
    @Id
    @GeneratedValue(generator = "my_gen2", strategy = GenerationType.SEQUENCE)
    @SequenceGenerator(name="my_gen2", sequenceName = "story_seq")
    private int id;

    private String title;

    @Positive
    private int estimate;

    @ManyToOne
    private Sprint sprint;
}
