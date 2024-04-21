package com.projects.usercenter.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "USER")
public class UserCourse {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "USER_COURSE_ID")
    private Long userCourseId;

    @Column(name = "COURSE_ID")
    private Long courseId;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "USER_ID", referencedColumnName = "USER_ID", nullable = false)
    private User user;

}