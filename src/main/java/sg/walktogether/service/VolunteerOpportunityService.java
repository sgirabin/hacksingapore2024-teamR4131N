package sg.walktogether.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import sg.walktogether.entity.VolunteerOpportunity;
import sg.walktogether.repository.VolunteerOpportunityRepository;

import java.util.List;
import java.util.Optional;

@Service
public class VolunteerOpportunityService {

    @Autowired
    private VolunteerOpportunityRepository volunteerOpportunityRepository;

    public VolunteerOpportunity saveOpportunity(VolunteerOpportunity opportunity) {
        return volunteerOpportunityRepository.save(opportunity);
    }

    public List<VolunteerOpportunity> getAllOpportunities() {
        return volunteerOpportunityRepository.findAll();
    }

    public Optional<VolunteerOpportunity> findById(Long id) {
        return volunteerOpportunityRepository.findById(id);
    }

    public void deleteById(Long id) {
        volunteerOpportunityRepository.deleteById(id);
    }
}
