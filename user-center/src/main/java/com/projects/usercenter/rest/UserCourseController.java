package com.projects.usercenter.rest;

import com.projects.usercenter.model.UserCourse;
import com.projects.usercenter.service.UserCourseService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Slf4j
@RestController
@RequestMapping("/user-course")
public class UserCourseController {

    private final UserCourseService userCourseService;

    public UserCourseController(UserCourseService userCourseService) {
        this.userCourseService = userCourseService;
    }

    @PostMapping
    public ResponseEntity<UserCourse> createCourseForUser(@RequestBody UserCourse userCourse) {
        log.info("UserCourseController : createCourseForUser() called");
        return userCourseService.createCourseForUser(userCourse);
    }

    @GetMapping("/{userId}")
    public ResponseEntity<List<UserCourse>> getCourseForUser(@PathVariable Long userId) {
        log.info("UserCourseController : getCourseForUser() called");
        return userCourseService.getCourseForUser(userId);
    }

}
