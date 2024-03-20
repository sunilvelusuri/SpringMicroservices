package com.techEnthusiast.studentservice.service;

import com.techEnthusiast.studentservice.dto.StudentDto;

public interface StudentService {
    StudentDto saveStudent(StudentDto studentDto);

    String getStudentWithDepartment(Long id);
}
