package sg.walktogether.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import sg.walktogether.entity.ForumPost;
import sg.walktogether.service.ForumPostService;

import java.time.Instant;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.Date;

@Controller
public class ForumPostController {

    @Autowired
    private ForumPostService forumPostService;

    @GetMapping("/forum")
    public String showForum(Model model) {
        model.addAttribute("posts", forumPostService.getAllPosts());
        return "forum";
    }

    @GetMapping("/create-post")
    public String showCreatePostForm(Model model) {
        model.addAttribute("post", new ForumPost());
        return "create-post";
    }

    @PostMapping("/create-post")
    public String savePost(@ModelAttribute("post") ForumPost post, Model model) {
        post.setCreatedAt(Date.from(Instant.now()));
        forumPostService.savePost(post);
        model.addAttribute("message", "Post created successfully");
        return "create-post";
    }
}
