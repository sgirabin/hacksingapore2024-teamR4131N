package sg.walktogether.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import sg.walktogether.repository.UserRepository;
import sg.walktogether.repository.VolunteerOpportunityRepository;

import java.util.List;
import java.util.Map;

@Service
public class DashboardService {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private VolunteerOpportunityRepository volunteerOpportunityRepository;

    public long getActiveUsers() {
        return userRepository.count();
    }

    /**
    public List<Map<String, Object>> getOpportunityStats() {
        return volunteerOpportunityRepository.getOpportunityStats();
    }
     **/
}