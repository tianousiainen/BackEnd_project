package backend_project.finalproject.web;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.PathVariable;

import backend_project.finalproject.domain.Group;
import backend_project.finalproject.domain.GroupRepository;
import backend_project.finalproject.domain.Student;
import backend_project.finalproject.domain.StudentRepository;

@Controller
public class GroupController {

    private final GroupRepository gRepository;
    private final StudentRepository sRepository;

    public GroupController(GroupRepository gRepository
        ,StudentRepository sRepository) {
        this.gRepository = gRepository;
        this.sRepository = sRepository;
    }

    @GetMapping("/grouplist")
    public String getGroup(Model model) {
        model.addAttribute("groups", gRepository.findAll());
        return "grouplist"; //grouplist.html
    }

    @GetMapping("/addgroup")
    public String addGroup(Model model) {
        model.addAttribute("group", new Group());
        return "addgroup"; // addgroup.html
    }

    @PostMapping("/savegroup")
    public String saveGroup(@ModelAttribute Group group) {
        gRepository.save(group);
        return "redirect:/grouplist";
    }

    @RequestMapping(value= "/deletegroup/{id}", method= RequestMethod.GET)
    public String deleteGroup(@PathVariable ("id") Long id, Model model){
        Group group = gRepository.findById(id).orElse(null);

        if(group != null){
            for (Student student : group.getStudents()){
                student.getGroups().remove(group);
            }
            gRepository.delete(group);
        }

        return "redirect:/grouplist";
    }

    @RequestMapping(value = "/editgroup/{id}", method= RequestMethod.GET)
    public String editGroup(@PathVariable ("id") Long id, Model model){
        Group group = gRepository.findById(id).orElse(null);

        model.addAttribute("group", group);
        model.addAttribute("groups", gRepository.findAll());

        return("editgroup"); //editgroup.html
    }

}