package com.projects.coursecenter.dao;

import com.projects.coursecenter.model.Course;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CourseRepository extends JpaRepository<Course, Long> {
}
