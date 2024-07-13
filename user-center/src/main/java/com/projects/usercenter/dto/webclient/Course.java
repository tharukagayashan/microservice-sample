package com.projects.usercenter.dto.webclient;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class Course {
    private Long courseId;
    private String name;
    private Double fee;
    private Integer duration;
    private String description;
    private String level; // Beginner, Intermediate, Advanced
    private String status;
}