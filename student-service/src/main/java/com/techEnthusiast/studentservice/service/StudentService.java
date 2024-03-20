package com.techEnthusiast.studentservice.service;

import com.techEnthusiast.studentservice.dto.StudentDto;

public interface StudentService {
    StudentDto saveStudent(StudentDto studentDto);

    StudentDto getStudentById(Long id);
}
