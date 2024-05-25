package sg.walktogether.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import sg.walktogether.entity.VolunteerOpportunity;
import sg.walktogether.service.VolunteerOpportunityService;

@Controller
@RequestMapping("/admin")
public class AdminController {

    @Autowired
    private VolunteerOpportunityService volunteerOpportunityService;

    @GetMapping("/opportunities")
    public String manageOpportunities(Model model) {
        model.addAttribute("opportunities", volunteerOpportunityService.getAllOpportunities());
        return "admin/opportunities";
    }

    @GetMapping("/opportunities/new")
    public String createOpportunityForm(Model model) {
        model.addAttribute("opportunity", new VolunteerOpportunity());
        return "admin/opportunity-form";
    }

    @PostMapping("/opportunities")
    public String createOpportunity(@ModelAttribute VolunteerOpportunity opportunity) {
        volunteerOpportunityService.saveOpportunity(opportunity);
        return "redirect:/admin/opportunities";
    }

    @GetMapping("/opportunities/edit/{id}")
    public String editOpportunityForm(@PathVariable Long id, Model model) {
        model.addAttribute("opportunity", volunteerOpportunityService.findById(id).orElse(null));
        return "admin/opportunity-form";
    }

    @PostMapping("/opportunities/{id}")
    public String updateOpportunity(@PathVariable Long id, @ModelAttribute VolunteerOpportunity opportunity) {
        opportunity.setId(id);
        volunteerOpportunityService.saveOpportunity(opportunity);
        return "redirect:/admin/opportunities";
    }

    @GetMapping("/opportunities/delete/{id}")
    public String deleteOpportunity(@PathVariable Long id) {
        volunteerOpportunityService.deleteById(id);
        return "redirect:/admin/opportunities";
    }
}