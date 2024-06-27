package com.projects.usercenter.model;


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
@Table(name = "USERS")
public class User implements Serializable {

    @Serial
    private static final long serialVersionUID = 2161917454458987330L;

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "USER_ID")
    private Long userId;

    @Column(name = "NAME")
    private String name;

    @Column(name = "STATUS")
    private String status; // Active, Inactive

    @Column(name = "EMAIL")
    private String email;

    @Column(name = "MOBILE_NO")
    private String mobileNo;

}
