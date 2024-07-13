package com.projects.usercenter.service;

import com.projects.usercenter.config.WebClientConfig;
import com.projects.usercenter.dao.UserCourseRepository;
import com.projects.usercenter.dao.UserRepository;
import com.projects.usercenter.dto.UserCourseReqDto;
import com.projects.usercenter.dto.webclient.Course;
import com.projects.usercenter.model.User;
import com.projects.usercenter.model.UserCourse;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Slf4j
@Service
public class UserCourseService {

    private final UserCourseRepository userCourseRepository;
    private final WebClientConfig webClientConfig;
    private final UserRepository userRepository;

    public UserCourseService(UserCourseRepository userCourseRepository, WebClientConfig webClientConfig, UserRepository userRepository) {
        this.userCourseRepository = userCourseRepository;
        this.webClientConfig = webClientConfig;
        this.userRepository = userRepository;
    }

    public ResponseEntity<UserCourse> createCourseForUser(UserCourseReqDto userCourseReqDto) {
        log.info("UserCourseService : createCourseForUser() called");

        Optional<User> optUser = userRepository.findById(userCourseReqDto.getUserId());
        if (optUser.isEmpty()) {
            throw new RuntimeException("User not found for id : " + userCourseReqDto.getUserId());
        }

        Course courseResult = webClientConfig
                .webClient()
                .get()
                .uri("http://localhost:8082/api/v1/course-center/course/" + userCourseReqDto.getCourseId())
                .retrieve()
                .bodyToMono(Course.class)
                .block();

        if (courseResult == null) {
            throw new RuntimeException("Course not found for id : " + userCourseReqDto.getCourseId());
        }

        UserCourse userCourse = new UserCourse();
        userCourse.setCourseId(courseResult.getCourseId());
        userCourse.setUser(optUser.get());

        UserCourse savedUserCourse = userCourseRepository.save(userCourse);
        return ResponseEntity.ok(savedUserCourse);
    }

    public ResponseEntity<List<UserCourse>> getCourseForUser(Long userId) {
        log.info("UserCourseService : getCourseForUser() called");
        List<UserCourse> userCourses = userCourseRepository.findByUserUserId(userId);
        return ResponseEntity.ok(userCourses);
    }
}