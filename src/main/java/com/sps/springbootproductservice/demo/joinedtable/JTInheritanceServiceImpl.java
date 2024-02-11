package com.sps.springbootproductservice.demo.joinedtable;

import com.sps.springbootproductservice.demo.InheritanceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@Qualifier(value = "jt_inheritance")
@Profile("jt_inheritance")
public class JTInheritanceServiceImpl implements InheritanceService {
    @Autowired
    private MentorRepository mentorRepository;

    @Autowired
    private UserRepository userRepository;

    @Override
    public void saveEntities() {
        System.out.println("Saving in Joined Tables Service");
        Mentor mentor = new Mentor();
        mentor.setName("Sai");
        mentor.setEmail("saiprasad@gmail.com");
        mentor.setAverageRating(4.65);
        mentorRepository.save(mentor);

        User user = new User();
        user.setName("Sushanth");
        user.setEmail("sushsanth@gmail.com");
        userRepository.save(user);

        List<User> userList = userRepository.findAll();
        userList.forEach(System.out::println);

    }
}
