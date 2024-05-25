package sg.walktogether.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import sg.walktogether.service.ForumPostService;
import sg.walktogether.service.VolunteerOpportunityService;

@Controller
public class HomeController {

    @Autowired
    private VolunteerOpportunityService volunteerOpportunityService;

    @Autowired
    private ForumPostService forumPostService;

    @GetMapping("/home")
    public String home(Model model) {
        model.addAttribute("opportunities", volunteerOpportunityService.getAllOpportunities());
        model.addAttribute("posts", forumPostService.getAllPosts());
        return "home";
    }
}