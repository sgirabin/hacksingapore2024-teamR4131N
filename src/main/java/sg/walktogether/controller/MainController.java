package sg.walktogether.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import sg.walktogether.entity.ForumPost;
import sg.walktogether.entity.User;
import sg.walktogether.entity.VolunteerOpportunity;
import sg.walktogether.repository.ForumPostRepository;
import sg.walktogether.repository.UserRepository;
import sg.walktogether.repository.VolunteerOpportunityRepository;

import java.util.List;

@Controller
public class MainController {

    @Autowired
    private VolunteerOpportunityRepository volunteerOpportunityRepository;

    @Autowired
    private ForumPostRepository forumPostRepository;

    @Autowired
    private UserRepository userRepository;

    @GetMapping("/")
    public String main(Model model){

        List<VolunteerOpportunity> opportunities = volunteerOpportunityRepository.findAll();
        List<ForumPost> forumPosts = forumPostRepository.findAll();
        List<User> activeMembers = userRepository.findAll();  // Assuming all users are active for simplicity

        model.addAttribute("opportunities", opportunities);
        model.addAttribute("forumPosts", forumPosts);
        model.addAttribute("activeMembers", activeMembers);

        return "index";
    }
}
