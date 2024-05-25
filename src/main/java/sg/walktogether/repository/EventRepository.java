package sg.walktogether.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import sg.walktogether.entity.Event;

public interface EventRepository extends JpaRepository<Event, Long> {
}
