package g52006.webg6.pae.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.web.servlet.MockMvc;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

import org.hamcrest.Matchers;
import org.junit.jupiter.api.Test;

@SpringBootTest
@AutoConfigureMockMvc
public class CourseControllerTest {
    
    @Autowired
    private MockMvc mockMvc;

    @Test
    public void testGetCourses() throws Exception {
        mockMvc.perform(get("/courses"))
            .andExpect(status().isOk())
            .andExpect(view().name("courses"))
            .andExpect(content().string(Matchers.containsString("Sigle")));
    }
}
