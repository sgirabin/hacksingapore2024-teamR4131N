package sg.walktogether.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import sg.walktogether.entity.ForumPost;
import sg.walktogether.repository.ForumPostRepository;

import java.util.List;

@Service
public class ForumPostService {

    @Autowired
    private ForumPostRepository forumPostRepository;

    public ForumPost savePost(ForumPost post) {
        return forumPostRepository.save(post);
    }

    public List<ForumPost> getAllPosts() {
        return forumPostRepository.findAll();
    }
}