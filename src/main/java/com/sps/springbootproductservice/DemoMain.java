package com.sps.springbootproductservice;

import com.sps.springbootproductservice.demo.singletable.Mentor;
import com.sps.springbootproductservice.demo.singletable.MentorRepository;
import com.sps.springbootproductservice.demo.singletable.User;
import com.sps.springbootproductservice.demo.singletable.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class DemoMain implements CommandLineRunner {
    @Autowired
    private MentorRepository mentorRepository;
    @Autowired
    private UserRepository userRepository;

    @Override
    public void run(String... args) throws Exception {
        insertIntoSingleTable();
    }

    private void insertIntoSingleTable() {
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

    public static void main(String[] args) {
        SpringApplication.run(DemoMain.class, args);
    }
}
