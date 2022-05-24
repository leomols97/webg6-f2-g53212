package g52006.webg6.scrum.web;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.web.servlet.MockMvc;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

import org.hamcrest.Matchers;

@SpringBootTest
@AutoConfigureMockMvc
public class ProjectControllerTest {
    
    @Autowired
    private MockMvc mockMvc;

    @Test
    public void testGetProjectDetails() throws Exception {
        mockMvc.perform(get("/projectDetails?projectName=EsiProgramme"))
            .andExpect(status().isOk())
            .andExpect(view().name("project"))
            .andExpect(content().string(Matchers.containsString("EsiProgramme")))
            .andExpect(content().string(Matchers.containsString("Consultation programme")));
    }

}
