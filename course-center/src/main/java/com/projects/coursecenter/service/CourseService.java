package com.projects.coursecenter.service;

import com.projects.coursecenter.dao.CourseRepository;
import com.projects.coursecenter.model.Course;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Slf4j
@Service
public class CourseService {
    private final CourseRepository courseRepository;

    public CourseService(CourseRepository courseRepository) {
        this.courseRepository = courseRepository;
    }

    public ResponseEntity<List<Course>> getAllCourses() {
        log.info("CourseService : getAllCourses() called");
        List<Course> courses = courseRepository.findAll();
        return ResponseEntity.ok(courses);
    }

    public ResponseEntity<Course> getCourseById(Long courseId) {
        log.info("CourseService : getCourseById() called");
        Optional<Course> optCourse = courseRepository.findById(courseId);
        return optCourse.map(ResponseEntity::ok).orElseGet(() -> ResponseEntity.ok(null));
    }

    public ResponseEntity<Course> createCourse(Course course) {
        log.info("CourseService : createCourse() called");
        Course savedCourse = courseRepository.save(course);
        return ResponseEntity.ok(savedCourse);
    }
}
