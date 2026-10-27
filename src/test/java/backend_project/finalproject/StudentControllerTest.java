package backend_project.finalproject;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.webmvc.test.autoconfigure.AutoConfigureMockMvc;
import org.springframework.test.web.servlet.MockMvc;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@SpringBootTest 
@AutoConfigureMockMvc 
public class StudentControllerTest {
    @Autowired 
    MockMvc mockMvc;

    @Test 
    public void studentListOpens() throws Exception{
        mockMvc.perform(get("/studentlist"))
        .andExpect(status().isOk());
    }

    @Test 
    public void addStudentOpens() throws Exception{
        mockMvc.perform(get("/addstudent"))
        .andExpect(status().isOk());
    }

}
