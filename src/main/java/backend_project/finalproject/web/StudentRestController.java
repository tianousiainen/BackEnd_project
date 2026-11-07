package backend_project.finalproject.web;

import java.util.List;
import java.util.Optional;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import backend_project.finalproject.domain.Student;
import backend_project.finalproject.domain.StudentRepository;

@CrossOrigin 
@RestController 
@RequestMapping ("/rest")
public class StudentRestController {
    private StudentRepository sRepository;

    public StudentRestController(StudentRepository studentRepository){
        sRepository = studentRepository;
    }

    @GetMapping ("/students")
    public @ResponseBody List<Student> findAllStudentRest(){
        return (List<Student>) sRepository.findAll();
    }

    @GetMapping ("/students/{id}")
    public @ResponseBody Optional<Student> getOneStudentRest(@PathVariable
        (name= "id")Long studentid){
            return sRepository.findById(studentid);
    }
    
}
