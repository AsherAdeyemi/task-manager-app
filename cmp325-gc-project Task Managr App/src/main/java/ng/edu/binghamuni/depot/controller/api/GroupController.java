package ng.edu.binghamuni.depot.controller.api;

import ng.edu.binghamuni.depot.Domain.Med;
import ng.edu.binghamuni.depot.services.MedService;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

@Controller

public class GroupController {
    @Autowired
    MedService medService;

    @GetMapping("/")
    public String homePage(Model model){
        model.addAttribute("meds", medService.getAllMeds());
        return "home";
    }

    @GetMapping("/addForm")
    public String addForm(Model model){
        Med med = new Med();
        model.addAttribute("med", med);
        model.addAttribute("pageTitle", "Add Tasks");

        return "new_drink";
    }

    @PostMapping("/saveMed")
    public String saveMed(@ModelAttribute("med") Med med, RedirectAttributes redirectAttributes){
        medService.saveMed(med);
        redirectAttributes.addFlashAttribute("message", "Task Added successfully");
        return "redirect:/";
    }

    @GetMapping("/addForm/{id}")
    public String addForm(@PathVariable("id") Long id, Model model) {
        try {
            Med med = medService.getMedById(id);
            model.addAttribute("med", med);
            model.addAttribute("pageTitle", "Edit Task Id:" + id);
            return "addForm";
        } catch (Exception e) {
            return "redirect:/";
        }
    }

    @PostMapping("/updateMed")
    public String updateMed(@ModelAttribute("med") Med updatedMed, RedirectAttributes redirectAttributes) {
        try {

            Med existingMed = medService.getMedById(updatedMed.getId());


            BeanUtils.copyProperties(updatedMed, existingMed, "id", "created_at", "updated_at");


            medService.saveMed(existingMed);

            redirectAttributes.addFlashAttribute("message", "Task updated successfully");
            return "redirect:/";
        } catch (Exception e) {
            redirectAttributes.addFlashAttribute("message", e.getMessage());
            return "redirect:/";
        }
    }

    @GetMapping("deleteMed/{id}")
    public String deleteMed(@PathVariable long id, RedirectAttributes redirectAttributes){
        MedService.deleteMedById(id);
        redirectAttributes.addFlashAttribute("message", "Task Deleted successfully");

        return "redirect:/";
    }

}

