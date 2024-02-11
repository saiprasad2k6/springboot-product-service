package com.sps.springbootproductservice;

import com.sps.springbootproductservice.demo.InheritanceService;
import com.sps.springbootproductservice.demo.singletable.Mentor;
import com.sps.springbootproductservice.demo.singletable.MentorRepository;
import com.sps.springbootproductservice.demo.singletable.User;
import com.sps.springbootproductservice.demo.singletable.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class DemoMain implements CommandLineRunner {
    @Autowired
    InheritanceService inheritanceService;

    @Override
    public void run(String... args) throws Exception {
        inheritanceService.saveEntities();
    }


    public static void main(String[] args) {
        SpringApplication.run(DemoMain.class, args);
    }
}
