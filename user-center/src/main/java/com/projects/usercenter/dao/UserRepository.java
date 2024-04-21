package com.projects.usercenter.dao;

import com.projects.usercenter.model.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Long> {
}
