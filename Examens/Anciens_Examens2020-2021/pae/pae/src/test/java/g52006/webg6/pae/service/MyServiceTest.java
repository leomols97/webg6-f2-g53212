package g52006.webg6.pae.service;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;

import g52006.webg6.pae.business.MyService;
import g52006.webg6.pae.model.Course;
import g52006.webg6.pae.model.Student;
import g52006.webg6.pae.repository.CourseRepository;
import g52006.webg6.pae.repository.StudentRepository;

@SpringBootTest
public class MyServiceTest {
    @Autowired
    private MyService myService;

    @MockBean
    private CourseRepository courseRepository;

    @MockBean
    private StudentRepository studentRepository;

    @Test
    public void getAllCourses(){
        Course course1 = new Course("aaa", "AAA", 5 , new ArrayList<Student>());
        Course course2 = new Course("bbb", "BBB", 6, new ArrayList<Student>());
        List<Course> iterable1 = new ArrayList<Course>();
        iterable1.add(course1);
        iterable1.add(course2);
        Mockito.when(courseRepository.findAll()).thenReturn(iterable1);
        Iterable<Course> found = myService.getAllCourses();
        assertEquals(found, iterable1);
        
    }
}
