    package backend_project.finalproject.web;

    import java.util.HashSet;
    import java.util.Set;

    import org.springframework.stereotype.Controller;
    import org.springframework.ui.Model;
    import org.springframework.web.bind.annotation.GetMapping;
    import org.springframework.web.bind.annotation.ModelAttribute;
    import org.springframework.web.bind.annotation.PathVariable;

import backend_project.finalproject.domain.DiciplineRepository;
import backend_project.finalproject.domain.Group;
import backend_project.finalproject.domain.GroupRepository;
    import backend_project.finalproject.domain.Student;
    import backend_project.finalproject.domain.StudentRepository;
    import org.springframework.web.bind.annotation.RequestParam;
    import org.springframework.web.bind.annotation.PostMapping;
    import org.springframework.web.bind.annotation.RequestMapping;
    import org.springframework.web.bind.annotation.RequestMethod;


    @Controller 
    public class StudentController {
        
        private final StudentRepository studentRepository;
        private final GroupRepository groupRepository;
        private final DiciplineRepository diciplineRepository;

        public StudentController(StudentRepository studentRepository,
            GroupRepository groupRepository, DiciplineRepository diciplineRepository
        ){
            this.studentRepository = studentRepository;
            this.groupRepository = groupRepository;
            this.diciplineRepository = diciplineRepository;
        }
        
        @GetMapping("/studentlist")
        public String getStudent(Model model){
            model.addAttribute("students", studentRepository.findAll());
            return("studentlist"); //studentlist.html
        }

        @GetMapping(value="/addstudent")
        public String getNewStudent(Model model) {
            model.addAttribute("student", new Student());
            model.addAttribute("groups", groupRepository.findAll());
            model.addAttribute("diciplines", diciplineRepository.findAll());
            return ("addstudent"); //addstudent.html
        }
        
        @PostMapping("/savestudent")
        public String saveStudent(@ModelAttribute Student student, 
            @RequestParam (required = false) Set<Long> groupIds) {
            
           Set<Group> groups = new HashSet<>();
            
           if(groupIds != null){
            for (Group group : groupRepository.findAllById(groupIds)){
                groups.add(group);
            }
           }
            student.setGroups(groups);
            studentRepository.save(student);
            return "redirect:/studentlist";
        }

        @RequestMapping (value="/delete/{id}", method = RequestMethod.GET)
        public String deleteStudent(@PathVariable ("id") Long id, Model model){
            studentRepository.deleteById(id);
            return "redirect:/studentlist";
        }

        @RequestMapping (value = "/edit/{id}", method = RequestMethod.GET)
        public String editStudent(@PathVariable ("id") Long id, Model model){
            Student student = studentRepository.findById(id).orElse(null);
            model.addAttribute("student", student);
            model.addAttribute("groups", groupRepository.findAll());
            model.addAttribute("diciplines", diciplineRepository.findAll());
            return ("editstudent"); //editstudent.html
        }
        
        
        
    }
