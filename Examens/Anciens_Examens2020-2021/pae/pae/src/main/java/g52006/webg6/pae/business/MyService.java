package g52006.webg6.pae.business;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import g52006.webg6.pae.model.Course;
import g52006.webg6.pae.model.Student;
import g52006.webg6.pae.repository.CourseRepository;
import g52006.webg6.pae.repository.StudentRepository;

@Service
public class MyService {

    @Autowired
    private CourseRepository courseDB;

    @Autowired
    private StudentRepository studentDB;

    public Iterable<Course> getAllCourses() {
        return courseDB.findAll();
    }

    public Optional<Course> getCourse(String courseId) {
        return courseDB.findById(courseId);
    }

    public void saveCourse(Course course) {
        courseDB.save(course);
    }

    public Iterable<Student> getAllStudents() {
        return studentDB.findAll();
    }

    public Optional<Student> getStudent(int id) {
        return studentDB.findById(id);
    }

    public void saveStudent(Student student) {
        studentDB.save(student);
    }

    public List<Course> getCoursesResemblingByName(String name) {
        return courseDB.findByLabelContaining(name);
    }

    public List<Course> getCourseWithGreaterEctsCountThan(int ects) {
        return courseDB.findByEctsGreaterThanEqual(ects);
    }

    public List<Object[]> getStudentNamesAndTheirAmountOfEcts() {
        return studentDB.getStudentNamesAndTheirAmountOfEcts();
    }

    public List<Student> getStudentsWhoHaveHigherEctsCount(long ectsAmount) {
        return studentDB.getStudentsWhoHaveHigherEctsCount(ectsAmount);
    }

    public List<Student> getStudentWithGivenName(String name) {
        return studentDB.getStudentWithGivenName(name);
    }
}
