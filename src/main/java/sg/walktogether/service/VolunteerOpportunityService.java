package sg.walktogether.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import sg.walktogether.entity.VolunteerOpportunity;
import sg.walktogether.repository.VolunteerOpportunityRepository;

import java.util.List;

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
}
