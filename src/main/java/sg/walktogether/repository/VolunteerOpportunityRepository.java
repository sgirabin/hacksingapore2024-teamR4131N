package sg.walktogether.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import sg.walktogether.entity.VolunteerOpportunity;

import java.util.List;
import java.util.Map;

@Repository
public interface VolunteerOpportunityRepository extends JpaRepository<VolunteerOpportunity, Long> {

    /**
    @Query("SELECT new map(v.title as title, COUNT(vu) as volunteers) " +
            "FROM VolunteerOpportunity v LEFT JOIN v.volunteers vu " +
            "GROUP BY v.title")
    List<Map<String, Object>> getOpportunityStats();
    **/
}
