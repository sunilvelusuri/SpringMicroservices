package com.techEnthusiast.studentservice.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "table_student")
@Entity
public class Student {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long studentId;
    private String firstName;
    private String lastName;
    private String email;
    private Long departmentid;

    public Student(String firstName, String lastName, String email, Long departmentid) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.email = email;
        this.departmentid = departmentid;
    }
}
