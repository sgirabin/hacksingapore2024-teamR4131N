package sg.walktogether.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import sg.walktogether.entity.ForumPost;

public interface ForumPostRepository extends JpaRepository<ForumPost, Long> {
}