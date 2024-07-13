package com.projects.usercenter.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class UserCourseReqDto {
    private Long userId;
    private Long courseId;
}