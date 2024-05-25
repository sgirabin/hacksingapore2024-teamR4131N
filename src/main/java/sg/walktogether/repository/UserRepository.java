package sg.walktogether.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import sg.walktogether.entity.User;

public interface UserRepository extends JpaRepository<User, Long> {
}
