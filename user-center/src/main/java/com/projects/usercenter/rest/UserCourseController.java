package com.projects.usercenter.rest;

import com.projects.usercenter.dto.UserCourseReqDto;
import com.projects.usercenter.model.UserCourse;
import com.projects.usercenter.service.UserCourseService;
import io.github.resilience4j.circuitbreaker.annotation.CircuitBreaker;
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
    @CircuitBreaker(name = "course-center", fallbackMethod = "fallbackMethod")
//    @TimeLimiter(name = "course-center")
//    @Retry(name = "course-center")
    public ResponseEntity<UserCourse> createCourseForUser(@RequestBody UserCourseReqDto userCourseReqDto) {
        log.info("UserCourseController : createCourseForUser() called");
        return userCourseService.createCourseForUser(userCourseReqDto);
    }

    public ResponseEntity<UserCourse> fallbackMethod(UserCourseReqDto userCourseReqDto, RuntimeException runtimeException) {
        throw new RuntimeException("Oops! Something went wrong. Please try again later.");
    }

    @GetMapping("/{userId}")
    public ResponseEntity<List<UserCourse>> getCourseForUser(@PathVariable Long userId) {
        log.info("UserCourseController : getCourseForUser() called");
        return userCourseService.getCourseForUser(userId);
    }

}
