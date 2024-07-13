package com.projects.usercenter.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serial;
import java.io.Serializable;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class UserCourseReqDto implements Serializable {
    @Serial
    private static final long serialVersionUID = -5396255329881108842L;

    private Long userId;
    private Long courseId;
}