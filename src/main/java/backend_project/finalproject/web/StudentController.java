package backend_project.finalproject.web;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import backend_project.finalproject.domain.StudentRepository;

@Controller 
public class StudentController {
    
    private final StudentRepository studentRepository;

    public StudentController(StudentRepository studentRepository){
        this.studentRepository = studentRepository;
    }
    
    @GetMapping("/studentlist")
    public String getStudent(Model model){
        model.addAttribute("students", studentRepository.findAll());
        return("/studentlist"); //studentlist.html
    }
}
