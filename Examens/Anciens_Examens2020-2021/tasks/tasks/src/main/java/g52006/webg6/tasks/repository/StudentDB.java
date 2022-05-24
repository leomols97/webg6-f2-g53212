package g52006.webg6.tasks.repository;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import g52006.webg6.tasks.entity.Student;

public interface StudentDB extends CrudRepository<Student, Integer>{

    @Query(value="SELECT s.number FROM Student s JOIN s.tasks t GROUP BY s.number HAVING COUNT(s) = (SELECT COUNT(t) FROM Task t)")
    public List<Integer> getStudentWhoFinishedEverything();
}
