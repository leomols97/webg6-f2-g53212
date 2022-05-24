package g52006.webg6.pae.repository;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;


import g52006.webg6.pae.model.Course;
import g52006.webg6.pae.model.Student;
import g52006.webg6.pae.repository.CourseRepository;

@DataJpaTest
public class CourseRepositoryTest {
    
    @Autowired
    private CourseRepository courseRepository;

    @Test
    public void findByEctsGreaterThanEqual(){
        Course course1 = new Course("abc", "ABC", 5, new ArrayList<Student>());
        courseRepository.save(course1);

        Course course2 = new Course("xyz", "XYZ", 6, new ArrayList<Student>()); 
        courseRepository.save(course2);

        Course course3 = new Course("omega", "OMEGA", 7, new ArrayList<Student>()); 
        courseRepository.save(course3);
        
        List<Course> found = courseRepository.findByEctsGreaterThanEqual(6);
        assertEquals(2, found.size());
        assertEquals(course2, found.get(0));
        assertEquals(course3, found.get(1));

    }

    @Test
    public void findByLabelContaining(){
        Course course1 = new Course("abc", "ABC", 5, new ArrayList<Student>());
        courseRepository.save(course1);

        Course course2 = new Course("xyz", "XYZ", 6, new ArrayList<Student>()); 
        courseRepository.save(course2);

        Course course3 = new Course("omega", "OMEGA", 7, new ArrayList<Student>()); 
        courseRepository.save(course3);

        List<Course> found = courseRepository.findByLabelContaining("A");
        assertEquals(2, found.size());
        assertEquals(course1, found.get(0));
        assertEquals(course3, found.get(1));
    }

    
    
}
