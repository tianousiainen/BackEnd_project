package backend_project.finalproject.web;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;

import backend_project.finalproject.domain.Student;
import backend_project.finalproject.domain.StudentRepository;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;



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

    @GetMapping(value="/addstudent")
    public String getNewStudent(Model model) {
        model.addAttribute("student", new Student());
        return ("addstudent"); //addstudent.html
    }
    
    @PostMapping("/savestudent")
    public String saveStudent(@ModelAttribute Student student, Model model) {
        studentRepository.save(student);
        
        return "redirect:/studentlist";
    }
    
}
