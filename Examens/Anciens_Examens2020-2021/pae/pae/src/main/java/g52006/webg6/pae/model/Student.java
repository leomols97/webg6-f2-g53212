package g52006.webg6.pae.model;

import java.util.Collection;

import javax.persistence.Entity;
import javax.persistence.Enumerated;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.SequenceGenerator;
import javax.validation.constraints.NotBlank;

import com.fasterxml.jackson.annotation.JsonBackReference;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.EqualsAndHashCode;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode
public class Student {

    @Id
    @GeneratedValue(generator = "my_gen", strategy = GenerationType.SEQUENCE)
    @SequenceGenerator(name = "my_gen", sequenceName = "my_seq")
    private int matricule;

    @NotBlank(message = "Le nom doit �tre rempli")
    private String name;

    @Enumerated
    private Section section;

    @Enumerated
    private Genre genre;

    @ManyToMany(mappedBy = "students", fetch = FetchType.LAZY)
    @JsonBackReference
    private Collection<Course> registeredCourses;

    @Override
    public String toString() {
        return "Student [genre=" + genre + ", matricule=" + matricule + ", name=" + name + ", section=" + section + "]";
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj)
            return true;
        if (obj == null)
            return false;
        if (getClass() != obj.getClass())
            return false;
        Student other = (Student) obj;
        if (genre != other.genre)
            return false;
        if (matricule != other.matricule)
            return false;
        if (name == null) {
            if (other.name != null)
                return false;
        } else if (!name.equals(other.name))
            return false;
        if (registeredCourses == null) {
            if (other.registeredCourses != null)
                return false;
        } else if (!registeredCourses.equals(other.registeredCourses))
            return false;
        if (section != other.section)
            return false;
        return true;
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((genre == null) ? 0 : genre.hashCode());
        result = prime * result + matricule;
        result = prime * result + ((name == null) ? 0 : name.hashCode());
        result = prime * result + ((registeredCourses == null) ? 0 : registeredCourses.hashCode());
        result = prime * result + ((section == null) ? 0 : section.hashCode());
        return result;
    }
}
