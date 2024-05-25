package sg.walktogether.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import sg.walktogether.entity.User;
import sg.walktogether.repository.UserRepository;

@Service
public class UserService {

    @Autowired
    private UserRepository userRepository;

    public  User saveUser(User user) {
        return userRepository.save(user);
    }

}

