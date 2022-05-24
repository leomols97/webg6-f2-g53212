package g52006.webg6.pae.repository;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

import g52006.webg6.pae.model.Course;
import g52006.webg6.pae.model.Genre;
import g52006.webg6.pae.model.Section;
import g52006.webg6.pae.model.Student;
import g52006.webg6.pae.repository.CourseRepository;
import g52006.webg6.pae.repository.StudentRepository;

@DataJpaTest
public class StudentRepositoryTest {
    @Autowired
    private CourseRepository courseRepository;

    @Autowired
    private StudentRepository studentRepository;


    @Test
    public void getStudentNames(){
        Student student1 = new Student(1, "Hal Jordan", Section.GESTION, Genre.M, new ArrayList<Course>());
        Student student2 = new Student(2, "Barry Allen", Section.GESTION, Genre.M, new ArrayList<Course>());
        studentRepository.save(student1);
        studentRepository.save(student2);


        List<String> found =  studentRepository.getStudentNames();
       
        assertEquals(2, found.size());
        assertEquals("Hal Jordan", found.get(0));
        assertEquals("Barry Allen", found.get(1));
    }

    @Test
    public void getStudentNamesAndIds(){
        Student student1 = new Student(1, "Hal Jordan", Section.GESTION, Genre.M, new ArrayList<Course>());
        Student student2 = new Student(2, "Barry Allen", Section.GESTION, Genre.M, new ArrayList<Course>());
        studentRepository.save(student1);
        studentRepository.save(student2);

        List<Object[]> found = studentRepository.getStudentNamesAndIds();
        assertEquals(2, found.size());
        assertEquals(student1.getMatricule(), found.get(0)[0]);
        assertEquals(student1.getName(), found.get(0)[1]);
    }

    @Test
    public void getStudentNamesAndTheirAmountOfEcts(){
        Student student1 = new Student(1, "Hal Jordan", Section.GESTION, Genre.M, new ArrayList<Course>());
        Student student2 = new Student(2, "Barry Allen", Section.GESTION, Genre.M, new ArrayList<Course>());
       
        Course course1 = new Course("aaa", "AAA", 5 , new ArrayList<Student>());
        Course course2 = new Course("bbb", "BBB", 6, new ArrayList<Student>());

        student1.getRegisteredCourses().add(course1);
        student2.getRegisteredCourses().add(course1);
        student2.getRegisteredCourses().add(course2);




        courseRepository.save(course1);
        courseRepository.save(course2);
        studentRepository.save(student1);
        studentRepository.save(student2);

        List<Object[]> found = studentRepository.getStudentNamesAndTheirAmountOfEcts();
        assertEquals(2, found.size());
        assertEquals(student1.getName(), found.get(0)[0]);
        assertEquals(5, found.get(0)[1]);
        assertEquals(student2.getName(), found.get(1)[0]);
        assertEquals(11, found.get(1)[1]);
    }

    @Test
    public void getStudentsWhoHaveHigherEctsCount(){
        Student student1 = new Student(1, "Hal Jordan", Section.GESTION, Genre.M, new ArrayList<Course>());
        Student student2 = new Student(2, "Barry Allen", Section.GESTION, Genre.M, new ArrayList<Course>());
       
        Course course1 = new Course("aaa", "AAA", 5 , new ArrayList<Student>());
        Course course2 = new Course("bbb", "BBB", 6, new ArrayList<Student>());

        student1.getRegisteredCourses().add(course1);
        student2.getRegisteredCourses().add(course1);
        student2.getRegisteredCourses().add(course2);

        courseRepository.save(course1);
        courseRepository.save(course2);
        studentRepository.save(student1);
        studentRepository.save(student2);

        List<Student> found = studentRepository.getStudentsWhoHaveHigherEctsCount(6);
        assertEquals(1, found.size());
        assertEquals(student2, found.get(0));

    }

    @Test
    public void getStudentWithGivenName(){
        Student student1 = new Student(1, "Hal Jordan", Section.GESTION, Genre.M, new ArrayList<Course>());
        Student student2 = new Student(2, "Barry Allen", Section.GESTION, Genre.M, new ArrayList<Course>());
        studentRepository.save(student1);
        studentRepository.save(student2);

        List<Student> found = studentRepository.getStudentWithGivenName("Jor");
        assertEquals(1, found.size());
        assertEquals(student1.getName(), found.get(0).getName());
    }
}
