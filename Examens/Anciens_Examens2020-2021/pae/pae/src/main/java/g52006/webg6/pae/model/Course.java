package g52006.webg6.pae.model;

import java.util.Collection;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Positive;

import com.fasterxml.jackson.annotation.JsonManagedReference;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.EqualsAndHashCode;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@EqualsAndHashCode
// A mettre au dessus de la classe qui extends la classe Course s'il y en a une
// @EqualsAndHashCode(callSuper=true)
public class Course {

    @Id
    @NotBlank(message = "Le texte entré ne peut pas être blanc")
    private String id;

    @NotBlank(message = "Le texte entré ne peut pas être blanc")
    private String label;

    @Positive(message = "Le nombré entré doit être positif")
    private int ects;

    @ManyToMany(fetch = FetchType.LAZY)
    @JsonManagedReference
    private Collection<Student> students;

    @Override
    public String toString() {
        return "Course [ects=" + ects + ", id=" + id + ", label=" + label + "]";
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj)
            return true;
        if (obj == null)
            return false;
        if (getClass() != obj.getClass())
            return false;
        Course other = (Course) obj;
        if (ects != other.ects)
            return false;
        if (id == null) {
            if (other.id != null)
                return false;
        } else if (!id.equals(other.id))
            return false;
        if (label == null) {
            if (other.label != null)
                return false;
        } else if (!label.equals(other.label))
            return false;
        if (students == null) {
            if (other.students != null)
                return false;
        } else if (!students.equals(other.students))
            return false;
        return true;
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ects;
        result = prime * result + ((id == null) ? 0 : id.hashCode());
        result = prime * result + ((label == null) ? 0 : label.hashCode());
        result = prime * result + ((students == null) ? 0 : students.hashCode());
        return result;
    }
}