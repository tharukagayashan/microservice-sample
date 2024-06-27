package com.projects.coursecenter.rest;

import com.projects.coursecenter.model.Course;
import com.projects.coursecenter.service.CourseService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Slf4j
@RestController
@RequestMapping("/course")
public class CourseController {
    private final CourseService courseService;

    public CourseController(CourseService courseService) {
        this.courseService = courseService;
    }

    @Cacheable(value = "CourseCache")
    @GetMapping
    public ResponseEntity<List<Course>> getAllCourses() {
        log.info("CourseController : getAllCourses() called");
        return courseService.getAllCourses();
    }

    @Cacheable(key = "#courseId", value = "CourseCache")
    @GetMapping("/{courseId}")
    public ResponseEntity<Course> getCourseById(@PathVariable("courseId") Long courseId) {
        log.info("CourseController : getCourseById() called");
        return courseService.getCourseById(courseId);
    }

    @PostMapping
    public ResponseEntity<Course> createCourse(@RequestBody Course course) {
        log.info("CourseController : createCourse() called");
        return courseService.createCourse(course);
    }

}
