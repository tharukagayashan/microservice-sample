package com.projects.coursecenter;

import com.projects.coursecenter.dao.CourseRepository;
import com.projects.coursecenter.model.Course;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cache.annotation.EnableCaching;
import org.springframework.context.annotation.Bean;

@EnableCaching
@SpringBootApplication
public class CourseCenterApplication {

    public static void main(String[] args) {
        SpringApplication.run(CourseCenterApplication.class, args);
    }

    @Bean
    public CommandLineRunner loadCourseData(CourseRepository courseRepository) {
        return (args) -> {

            if (courseRepository.count() == 0) {
                courseRepository.save(new Course(
                                0L,
                                "Java Programming",
                                50000.00,
                                12,
                                "Learn Java Programming from scratch",
                                "Beginner",
                                "Active"
                        )
                );

                courseRepository.save(new Course(
                                0L,
                                "Spring Boot",
                                60000.00,
                                8,
                                "Learn Spring Boot from scratch",
                                "Intermediate",
                                "Active"
                        )
                );

                courseRepository.save(new Course(
                                0L,
                                "React JS",
                                40000.00,
                                10,
                                "Learn React JS from scratch",
                                "Intermediate",
                                "Active"
                        )
                );

                courseRepository.save(new Course(
                                0L,
                                "Angular",
                                45000.00,
                                10,
                                "Learn Angular from scratch",
                                "Intermediate",
                                "Active"
                        )
                );
            }
        };
    }
}