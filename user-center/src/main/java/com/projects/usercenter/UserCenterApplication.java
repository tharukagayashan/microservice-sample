package com.projects.usercenter;

import com.projects.usercenter.dao.UserCourseRepository;
import com.projects.usercenter.dao.UserRepository;
import com.projects.usercenter.model.User;
import com.projects.usercenter.model.UserCourse;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cache.annotation.EnableCaching;
import org.springframework.context.annotation.Bean;
import org.springframework.web.bind.annotation.CrossOrigin;

@CrossOrigin
@EnableCaching
@SpringBootApplication
public class UserCenterApplication {

    public static void main(String[] args) {
        SpringApplication.run(UserCenterApplication.class, args);
    }

    //Load the data to the database
    @Bean
    public CommandLineRunner loadUserData(UserRepository userRepository, UserCourseRepository userCourseRepository) {
        return (args) -> {

            if (userRepository.count() == 0) {
                userRepository.save(new User(
                        0L,
                        "John Doe",
                        "Active",
                        "john.d@gmail.com",
                        "1234567890")
                );

                userRepository.save(new User(
                        0L,
                        "Alice Smith",
                        "Active",
                        "alice.s@gmail.com",
                        "0987654321")
                );


                userRepository.save(new User(
                        0L,
                        "Bob Brown",
                        "Active",
                        "bob.b@gmail.com",
                        "1234567890")
                );
            }

        };
    }

}
