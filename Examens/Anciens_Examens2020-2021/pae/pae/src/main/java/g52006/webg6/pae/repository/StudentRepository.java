package g52006.webg6.pae.repository;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;


import g52006.webg6.pae.model.Student;

public interface StudentRepository extends CrudRepository<Student, Integer> {
    
    @Query(value = "SELECT s.name FROM Student s")
    List<String> getStudentNames();

    @Query(value = "SELECT s.matricule, s.name FROM Student s")
    List<Object[]> getStudentNamesAndIds();

    @Query(value = "SELECT s.name, SUM(c.ects) FROM Student s JOIN s.registeredCourses c GROUP BY s.name")
    List<Object[]> getStudentNamesAndTheirAmountOfEcts();

    @Query(value = "SELECT s1 FROM Student s1 JOIN s1.registeredCourses c1 GROUP BY s1.matricule HAVING SUM(c1.ects) > :ectsAmount")
    List<Student> getStudentsWhoHaveHigherEctsCount(long ectsAmount);

    @Query(value = "SELECT s FROM Student s WHERE s.name LIKE %:studentName%")
    List<Student> getStudentWithGivenName(String studentName);
}
