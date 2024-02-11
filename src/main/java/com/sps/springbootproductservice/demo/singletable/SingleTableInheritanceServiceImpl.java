package com.sps.springbootproductservice.demo.singletable;

import com.sps.springbootproductservice.demo.InheritanceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Service;

@Service
@Qualifier(value = "st_inheritance")
@Profile("st_inheritance")
public class SingleTableInheritanceServiceImpl implements InheritanceService {
    @Autowired
    private MentorRepository mentorRepository;
    @Autowired
    private UserRepository userRepository;

    @Override
    public void saveEntities(){
        System.out.println("Saving in Single Table Service");
        Mentor mentor = new Mentor();
        mentor.setName("Sai");
        mentor.setEmail("saiprasad@gmail.com");
        mentor.setAverageRating(4.65);
        mentorRepository.save(mentor);

        User user = new User();
        user.setName("Sushanth");
        user.setEmail("sushsanth@gmail.com");
        userRepository.save(user);
    }
}
