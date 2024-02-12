package com.sps.springbootproductservice.demo.tableperclass;

import com.sps.springbootproductservice.demo.InheritanceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@Qualifier(value = "tbc_inheritance")
@Profile("tbc_inheritance")
public class TBCInheritanceServiceImpl implements InheritanceService {
    @Autowired
    private UserRepository userRepository;
    @Autowired
    private MentorRepository mentorRepository;

    @Override
    public void saveEntities() {
        System.out.println();
        System.out.println("********************* Saving Mentor in Table Per Class *********************");
        Mentor mentor = new Mentor();
        mentor.setName("Sai");
        mentor.setEmail("saiprasad@gmail.com");
        mentor.setAverageRating(4.65);
        mentorRepository.save(mentor);

        System.out.println();
        System.out.println("********************* Saving User in Table Per Class *********************");
        User user = new User();
        user.setName("Sushanth");
        user.setEmail("sushsanth@gmail.com");
        userRepository.save(user);

        List<User> userList = userRepository.findAll();
        userList.forEach(System.out::println);

    }

}
