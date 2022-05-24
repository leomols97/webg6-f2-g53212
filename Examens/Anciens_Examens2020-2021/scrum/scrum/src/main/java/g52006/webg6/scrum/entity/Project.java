package g52006.webg6.scrum.entity;

import java.util.Collection;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToMany;

import lombok.Data;

@Entity
@Data
public class Project {
    
    @Id
    private String name;

    private boolean active;

    @OneToMany(mappedBy = "project")
    private Collection<Sprint> sprints;
}
