package webg66.commitManager.entities;


import java.time.LocalDate;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.SequenceGenerator;
import javax.validation.constraints.NotBlank;

import com.fasterxml.jackson.annotation.JsonBackReference;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
public class CommitE {

    @Id
    @GeneratedValue(generator = "my_gen2", strategy = GenerationType.SEQUENCE)
    @SequenceGenerator(name = "my_gen2", sequenceName = "my_seq2", allocationSize = 50)
    private int id;

  
    private LocalDate date;

    @NotBlank(message = "Le commit doit contenir un message")
    private String message;

    @ManyToOne
    @JsonBackReference
    private Repository repository;

    @Override
    public String toString() {
        return "Commit [date=" + date + ", id=" + id + ", message=" + message + "]";
    }

    
}
