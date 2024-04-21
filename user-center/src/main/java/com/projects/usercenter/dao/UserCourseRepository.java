package com.projects.usercenter.dao;

import com.projects.usercenter.model.UserCourse;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface UserCourseRepository extends JpaRepository<UserCourse, Long> {
    List<UserCourse> findByUserUserId(Long userId);
}