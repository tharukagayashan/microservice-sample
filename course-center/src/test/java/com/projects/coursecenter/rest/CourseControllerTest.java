package com.projects.coursecenter.rest;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.projects.coursecenter.model.Course;
import com.projects.coursecenter.service.CourseService;
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
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

import java.util.ArrayList;
import java.util.List;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

@ExtendWith(MockitoExtension.class)
class CourseControllerTest {

    private MockMvc mockMvc;

    @Mock
    private CourseService courseService;

    @InjectMocks
    private CourseController courseController;

    @Test
    public void testGetAllCourses() throws Exception {
        List<Course> courses = new ArrayList<>();
        // Add some dummy courses to the list
        courses.add(new Course(1L, "Java Programming", 100.0, 30, "Introduction to Java", "Beginner", "Active"));
        courses.add(new Course(2L, "Spring Boot", 150.0, 45, "Introduction to Spring Boot", "Intermediate", "Active"));

        when(courseService.getAllCourses()).thenReturn(ResponseEntity.ok(courses));

        mockMvc = MockMvcBuilders.standaloneSetup(courseController).build();

        mockMvc.perform(get("/course"))
                .andExpect(status().isOk())
                .andExpect(content().contentType(MediaType.APPLICATION_JSON))
                .andExpect(jsonPath("$[0].name").value("Java Programming"))
                .andExpect(jsonPath("$[1].name").value("Spring Boot"));
    }

    @Test
    public void testGetCourseById() throws Exception {
        Long courseId = 1L;
        Course course = new Course(courseId, "Java Programming", 100.0, 30, "Introduction to Java", "Beginner", "Active");

        when(courseService.getCourseById(courseId)).thenReturn(ResponseEntity.ok(course));

        mockMvc = MockMvcBuilders.standaloneSetup(courseController).build();

        mockMvc.perform(get("/course/{courseId}", courseId))
                .andExpect(status().isOk())
                .andExpect(content().contentType(MediaType.APPLICATION_JSON))
                .andExpect(jsonPath("$.name").value("Java Programming"));
    }


    @Test
    public void testCreateCourse() throws Exception {
        // Create a sample course object for testing
        Course course = new Course();
        course.setCourseId(1L);
        course.setName("Sample Course");
        course.setDescription("Sample Description");

        // Stub the behavior of courseService.createCourse() method
        when(courseService.createCourse(any(Course.class))).thenReturn(ResponseEntity.ok(course));

        // Perform the actual method invocation
        ResponseEntity<Course> response = courseController.createCourse(course);

        mockMvc = MockMvcBuilders.standaloneSetup(courseController).build();

        mockMvc.perform(post("/course")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(new ObjectMapper().writeValueAsString(course)))
                .andExpect(status().isOk())
                .andExpect(content().contentType(MediaType.APPLICATION_JSON))
                .andExpect(jsonPath("$.name").value("Sample Course"));

        // Assert the response entity
        Assertions.assertNotNull(response);
        Assertions.assertEquals(HttpStatus.OK, response.getStatusCode());
        Assertions.assertNotNull(response.getBody());
        Assertions.assertEquals(course.getCourseId(), response.getBody().getCourseId());
        Assertions.assertEquals(course.getName(), response.getBody().getName());
        Assertions.assertEquals(course.getDescription(), response.getBody().getDescription());
    }

}