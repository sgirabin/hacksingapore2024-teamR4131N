package sg.walktogether.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import sg.walktogether.entity.VolunteerOpportunity;
import sg.walktogether.service.VolunteerOpportunityService;

@Controller
public class VolunteerOpportunityController {

    @Autowired
    private VolunteerOpportunityService volunteerOpportunityService;

    @GetMapping("/volunteer")
    public String showVolunteerOpportunities(Model model) {
        model.addAttribute("opportunities", volunteerOpportunityService.getAllOpportunities());
        return "volunteer";
    }

    @GetMapping("/create-opportunity")
    public String showCreateOpportunityForm(Model model) {
        model.addAttribute("opportunity", new VolunteerOpportunity());
        return "create-opportunity";
    }

    @PostMapping("/create-opportunity")
    public String saveOpportunity(@ModelAttribute("opportunity") VolunteerOpportunity opportunity, Model model) {
        volunteerOpportunityService.saveOpportunity(opportunity);
        model.addAttribute("message", "Opportunity created successfully");
        return "create-opportunity";
    }
}