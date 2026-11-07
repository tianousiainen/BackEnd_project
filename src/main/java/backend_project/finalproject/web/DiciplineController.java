package backend_project.finalproject.web;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import backend_project.finalproject.domain.Dicipline;
import backend_project.finalproject.domain.DiciplineRepository;
import backend_project.finalproject.domain.GroupRepository;
import backend_project.finalproject.domain.StudentRepository;

@Controller 
public class DiciplineController {

    private final DiciplineRepository dRepository;

    public DiciplineController(DiciplineRepository dRepository) {
       this.dRepository = dRepository;
    }
    
    @GetMapping("/diciplinelist")
    public String getDicipline(Model model){
        model.addAttribute("diciplines", dRepository.findAll());
        return "diciplinelist"; //diciplinelist.html
    }

    @GetMapping("/addDicipline")
    public String addDicipline(Model model) {
        model.addAttribute("newDicipline", new Dicipline());
        return "addDicipline"; // addDicipline.html
    }

    @PostMapping("/savedicipline")
    public String saveDicipline(@ModelAttribute("newDicipline") Dicipline dicipline) {
        dRepository.save(dicipline);
        return "redirect:/diciplinelist";
    }

    @RequestMapping (value = "/deletedicipline/{id}", method= RequestMethod.GET)
    public String deleteDicipline(@PathVariable ("id") Long id, Model model){
        dRepository.deleteById(id);

        return "redirect:/diciplinelist";
    }

    @RequestMapping(value = "/editdicipline/{id}", method= RequestMethod.GET)
    public String editDicipline(@PathVariable ("id") Long id, Model model){
        Dicipline dicipline = dRepository.findById(id).orElse(null);

        model.addAttribute("dicipline", dicipline);
        model.addAttribute("diciplines", dRepository.findAll());

        return("editdicipline"); //editdicipline.html
    }
}
