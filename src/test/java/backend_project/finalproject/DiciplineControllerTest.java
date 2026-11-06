package backend_project.finalproject;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.webmvc.test.autoconfigure.AutoConfigureMockMvc;
import org.springframework.test.web.servlet.MockMvc;

@SpringBootTest 
@AutoConfigureMockMvc 
public class DiciplineControllerTest {
    @Autowired 
    MockMvc mockMvc;

    @Test 
    public void diciplineListOpens() throws Exception{
        mockMvc.perform(get("/diciplinelist"))
        .andExpect(status().isOk());
    }

    @Test
    public void addDiciplineOpens() throws Exception {
        mockMvc.perform(get("/addDicipline"))
        .andExpect(status().isOk());
    }
}
