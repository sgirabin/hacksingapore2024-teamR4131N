package sg.walktogether.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import sg.walktogether.entity.VolunteerOpportunity;

public interface VolunteerOpportunityRepository extends JpaRepository<VolunteerOpportunity, Long> {
}
