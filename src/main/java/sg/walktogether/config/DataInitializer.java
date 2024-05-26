package sg.walktogether.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import sg.walktogether.entity.ForumPost;
import sg.walktogether.entity.User;
import sg.walktogether.entity.VolunteerOpportunity;
import sg.walktogether.repository.ForumPostRepository;
import sg.walktogether.repository.UserRepository;
import sg.walktogether.repository.VolunteerOpportunityRepository;

import java.time.Instant;
import java.time.LocalDate;
import java.util.Date;

@Configuration
public class DataInitializer {

    @Autowired
    private BCryptPasswordEncoder passwordEncoder;

    @Bean
    public CommandLineRunner initData(
            UserRepository userRepository,
            VolunteerOpportunityRepository volunteerOpportunityRepository,
            ForumPostRepository forumPostRepository) {
        return args -> {
            // Create dummy users
            User admin = new User();
            admin.setFullName("Admin User");
            admin.setEmail("admin@example.com");
            admin.setPassword(passwordEncoder.encode("admin"));
            admin.setDateOfBirth(LocalDate.of(1980, 01, 01));
            admin.setNationality(User.Nationality.SINGAPORE_CITIZEN);
            admin.setContactNo("12345678");
            admin.setGender(User.Gender.MALE);
            admin.setRole("ADMIN");
            userRepository.save(admin);

            User user = new User();
            user.setFullName("Regular User");
            user.setEmail("user@example.com");
            user.setPassword(passwordEncoder.encode("user"));
            user.setDateOfBirth(LocalDate.of(1980, 01, 01));
            user.setNationality(User.Nationality.SINGAPORE_PR);
            user.setContactNo("87654321");
            user.setGender(User.Gender.FEMALE);
            user.setRole("USER");
            userRepository.save(user);

            // Create dummy volunteer opportunities
            VolunteerOpportunity vo1 = new VolunteerOpportunity();
            vo1.setTitle("Beach Cleanup");
            vo1.setDescription("Join us for a beach cleanup event to keep our beaches clean.");
            vo1.setLocation("Changi Beach");
            vo1.setDate(LocalDate.of(2030, 01, 01));
            volunteerOpportunityRepository.save(vo1);

            VolunteerOpportunity vo2 = new VolunteerOpportunity();
            vo2.setTitle("Tree Planting");
            vo2.setDescription("Participate in our tree planting event to help the environment.");
            vo2.setLocation("Pasir Risk Park");
            vo2.setDate(LocalDate.of(2030, 01, 01));
            volunteerOpportunityRepository.save(vo2);

            // Create dummy forum posts
            ForumPost fp1 = new ForumPost();
            fp1.setTitle("Welcome to the Community");
            fp1.setContent("This is the first post in our community forum. Feel free to introduce yourself!");
            fp1.setAuthor("user 1");
            fp1.setCreatedAt(Date.from(Instant.now()));
            forumPostRepository.save(fp1);

            ForumPost fp2 = new ForumPost();
            fp2.setTitle("Upcoming Events");
            fp2.setContent("Check out our upcoming events and join us in making a difference.");
            fp2.setAuthor("user 2");
            fp2.setCreatedAt(Date.from(Instant.now()));
            forumPostRepository.save(fp2);
        };
    }
}
