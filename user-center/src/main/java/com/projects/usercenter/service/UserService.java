package com.projects.usercenter.service;

import com.projects.usercenter.dao.UserRepository;
import com.projects.usercenter.model.User;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Slf4j
@Service
public class UserService {
    private final UserRepository userRepository;

    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public ResponseEntity<User> createUser(User user) {
        User savedUser = userRepository.save(user);
        return ResponseEntity.ok(savedUser);
    }

    public ResponseEntity<User> getUserById(Long userId) {
        log.info("UserService : getUserById() called");
        Optional<User> optUser = userRepository.findById(userId);
        log.info("Get from DB");
        return optUser.map(ResponseEntity::ok).orElseGet(() -> ResponseEntity.ok(null));
    }

    public ResponseEntity<List<User>> getAllUsers() {
        log.info("UserService : getAllUsers() called");
        log.info("Get from DB");
        return ResponseEntity.ok(userRepository.findAll());
    }
}
