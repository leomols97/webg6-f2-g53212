package g52006.webg6.pae.repository;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

import g52006.webg6.pae.model.Course;

public interface CourseRepository extends CrudRepository<Course, String> {

    List<Course> findByEctsGreaterThanEqual(int ects);

    List<Course> findByLabelContaining(String name);
}
