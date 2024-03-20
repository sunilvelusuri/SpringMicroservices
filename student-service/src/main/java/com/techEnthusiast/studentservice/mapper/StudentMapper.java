package com.techEnthusiast.studentservice.mapper;

import com.techEnthusiast.studentservice.dto.StudentDto;
import com.techEnthusiast.studentservice.entity.Student;

public class StudentMapper {

    public static Student mapToStudent(StudentDto studentDto){
        Student student = new Student(
                studentDto.getFirstName(),
                studentDto.getLastName(),
                studentDto.getEmail(),
                studentDto.getDepartmentid()
        );

        return student;
    }

    public static StudentDto mapToStudentDto(Student student){
        StudentDto studentDto = new StudentDto(
                student.getFirstName(),
                student.getLastName(),
                student.getEmail(),
                student.getDepartmentid()
        );
        return studentDto;
    }


}
