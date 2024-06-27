package com.projects.coursecenter.model;


import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.io.Serial;
import java.io.Serializable;

@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "COURSE")
public class Course implements Serializable {

    @Serial
    private static final long serialVersionUID = -5865139291882441529L;

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "COURSE_ID")
    private Long courseId;

    @Column(name = "NAME")
    private String name;

    @Column(name = "FEE")
    private Double fee;

    @Column(name = "DURATION")
    private Integer duration;

    @Column(name = "DESCRIPTION")
    private String description;

    @Column(name = "LEVEL")
    private String level; // Beginner, Intermediate, Advanced

    @Column(name = "STATUS")
    private String status; // Active, Inactive

}
