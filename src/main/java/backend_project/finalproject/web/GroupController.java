package backend_project.finalproject.web;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import backend_project.finalproject.domain.Group;
import backend_project.finalproject.domain.GroupRepository;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;


@Controller 
public class GroupController {

    private final GroupRepository gRepository;

    GroupController(GroupRepository gRepository){
        this.gRepository = gRepository;
    }
    
    @GetMapping("/grouplist")
    public String getGroup(Model model) {
        model.addAttribute("groups", gRepository.findAll());
        return ("/grouplist"); //grouplist.html
    }
    
}
