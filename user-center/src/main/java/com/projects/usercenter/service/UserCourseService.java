package com.projects.usercenter.service;

import com.projects.usercenter.dao.UserCourseRepository;
import com.projects.usercenter.model.UserCourse;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;

@Slf4j
@Service
public class UserCourseService {

    private final UserCourseRepository userCourseRepository;

    public UserCourseService(UserCourseRepository userCourseRepository) {
        this.userCourseRepository = userCourseRepository;
    }

    public ResponseEntity<UserCourse> createCourseForUser(UserCourse userCourse) {
        log.info("UserCourseService : createCourseForUser() called");
        UserCourse savedUserCourse = userCourseRepository.save(userCourse);
        return ResponseEntity.ok(savedUserCourse);
    }

    public ResponseEntity<List<UserCourse>> getCourseForUser(Long userId) {
        log.info("UserCourseService : getCourseForUser() called");
        List<UserCourse> userCourses = userCourseRepository.findByUserUserId(userId);
        return ResponseEntity.ok(userCourses);
    }
}