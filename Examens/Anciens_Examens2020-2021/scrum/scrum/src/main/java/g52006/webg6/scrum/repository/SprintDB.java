package g52006.webg6.scrum.repository;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import g52006.webg6.scrum.entity.Sprint;

public interface SprintDB extends CrudRepository<Sprint, Integer>{

    @Query(value = "SELECT s FROM Sprint s JOIN s.project p WHERE p.name = :projectName ORDER BY s.number desc")
    List<Sprint> getAntichronologicalSprintIds(String projectName);
    
}
