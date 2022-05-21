package g53212.webg6.pae.business;

import org.springframework.data.repository.CrudRepository;

import g53212.webg6.pae.model.Course;

public interface CourseDB extends CrudRepository<Course, String> {

}