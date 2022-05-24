package g52006.webg6.pae.model;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Positive;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import g52006.webg6.pae.model.Course;

@SpringBootTest
public class CourseTest {
    @Autowired
    private BeanValidationUtil<Course> validator;

    @Test
    public void idValid(){
        Course course = new Course("abc", "ABC", 5, null);
        validator.assertIsValid(course);
    }

    @Test
    public void idBlank(){
        Course course = new Course("", "ABC", 5, null);
        validator.assertHasError(course, "id", NotBlank.class);
    }

    @Test
    public void nameValid(){
        Course course = new Course("abc", "ABC", 5 , null);
        validator.assertIsValid(course);
    }

    @Test
    public void nameBlank(){
        Course course = new Course("abc", "", 5, null);
        validator.assertHasError(course, "label", NotBlank.class);
    }

    @Test
    public void ectsValid(){
        Course course = new Course("abc", "ABC", 5 , null);
        validator.assertIsValid(course);
    }

    @Test
    public void ectsNegative(){
        Course course = new Course("abc", "ABC", -1 , null);
        validator.assertHasError(course, "ects", Positive.class);
    }
}
