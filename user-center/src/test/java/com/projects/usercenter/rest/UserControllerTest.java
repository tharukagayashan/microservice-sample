package com.projects.usercenter.rest;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.projects.usercenter.model.User;
import com.projects.usercenter.service.UserService;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

import java.util.ArrayList;
import java.util.List;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

@ExtendWith(MockitoExtension.class)
class UserControllerTest {

    private MockMvc mockMvc;

    @Mock
    private UserService userService;

    @InjectMocks
    private UserController userController;

    @Test
    public void getAllUsers() throws Exception {

        List<User> users = new ArrayList<>();

        User user1 = new User(1L, "John Doe", "Active", "johndoe@gmail.com", "0711545624");
        User user2 = new User(2L, "Jacky Panther", "Active", "jackypanther@gmail.com", "0715469854");

        users.add(user1);
        users.add(user2);

        when(userService.getAllUsers()).thenReturn(ResponseEntity.ok(users));

        mockMvc = MockMvcBuilders.standaloneSetup(userController).build();

        mockMvc.perform(get("/user"))
                .andExpect(status().isOk())
                .andExpect(content().contentType(MediaType.APPLICATION_JSON))
                .andExpect(jsonPath("$[0].name").value("John Doe"))
                .andExpect(jsonPath("$[1].name").value("Jacky Panther"));
    }

    @Test
    void getUserById() throws Exception {
        Long userId = 1L;
        User user = new User(userId, "John Doe", "Active", "johndoe@gmail.com", "0711545624");

        when(userService.getUserById(userId)).thenReturn(ResponseEntity.ok(user));

        mockMvc = MockMvcBuilders.standaloneSetup(userController).build();

        mockMvc.perform(get("/user/{userId}", userId))
                .andExpect(status().isOk())
                .andExpect(content().contentType(MediaType.APPLICATION_JSON))
                .andExpect(jsonPath("$.name").value("John Doe"));
    }


    @Test
    void createUser() throws Exception {
        User user = new User(1L, "John Doe", "Active", "johndoe@gmail.com", "0711545624");

        when(userService.createUser(any(User.class))).thenReturn(ResponseEntity.ok(user));

        // Perform the actual method invocation
        ResponseEntity<User> response = userController.createUser(user);

        mockMvc = MockMvcBuilders.standaloneSetup(userController).build();

        mockMvc.perform(post("/user")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(new ObjectMapper().writeValueAsString(user)))
                .andExpect(status().isOk())
                .andExpect(content().contentType(MediaType.APPLICATION_JSON))
                .andExpect(jsonPath("$.name").value("John Doe"));

        // Assert the response entity
        Assertions.assertNotNull(response);
        Assertions.assertEquals(HttpStatus.OK, response.getStatusCode());
        Assertions.assertNotNull(response.getBody());
        Assertions.assertEquals(user.getUserId(), response.getBody().getUserId());
        Assertions.assertEquals(user.getName(), response.getBody().getName());
        Assertions.assertEquals(user.getStatus(), response.getBody().getStatus());
    }
}