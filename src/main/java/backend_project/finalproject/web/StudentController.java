package backend_project.finalproject.web;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller 
public class StudentController {
    
    @GetMapping("/studentlist")
    public String getStudent(){
        return("/studentlist"); //studentlist.html
    }
}
