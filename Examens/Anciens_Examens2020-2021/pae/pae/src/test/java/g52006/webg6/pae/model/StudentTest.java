package g52006.webg6.pae.model;

import javax.validation.constraints.NotBlank;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import g52006.webg6.pae.model.Student;


@SpringBootTest
public class StudentTest {
    
    @Autowired
    private BeanValidationUtil<Student> validator;

    @Test
    public void nameValid() {
        Student student = new Student();
        student.setName("Hal Jordan");
        validator.assertIsValid(student);
    }

    @Test
    public void nameBlank(){
        Student student = new Student();
        validator.assertHasError(student, "name", NotBlank.class);
    }
}
