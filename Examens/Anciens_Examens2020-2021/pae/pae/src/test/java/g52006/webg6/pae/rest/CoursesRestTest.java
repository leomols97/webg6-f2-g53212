package g52006.webg6.pae.rest;

import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.Test;

import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.web.servlet.MockMvc;

import g52006.webg6.pae.business.MyService;
import g52006.webg6.pae.model.Course;
import g52006.webg6.pae.model.Student;


import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@WebMvcTest
public class CoursesRestTest {
    @Autowired
    private MockMvc mvc;

    @MockBean
    private MyService myService;

    @Test
    public void getCourses() throws Exception{
        Course course1 = new Course("aaa", "AAA", 5 , new ArrayList<Student>());
        Course course2 = new Course("aaa", "AAA", 5 , new ArrayList<Student>());
        List<Course> iterable1 = new ArrayList<Course>(); 
        iterable1.add(course1);
        iterable1.add(course2);
        Mockito.when(myService.getAllCourses()).thenReturn(iterable1);

        mvc.perform(get("/api/courses"))
        .andExpect(status().isOk());
        
    }
}
