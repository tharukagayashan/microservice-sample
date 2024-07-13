package com.projects.usercenter.dto.webclient;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serial;
import java.io.Serializable;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class Course implements Serializable {

    @Serial
    private static final long serialVersionUID = -7440742657279089918L;

    private Long courseId;
    private String name;
    private Double fee;
    private Integer duration;
    private String description;
    private String level; // Beginner, Intermediate, Advanced
    private String status;
}