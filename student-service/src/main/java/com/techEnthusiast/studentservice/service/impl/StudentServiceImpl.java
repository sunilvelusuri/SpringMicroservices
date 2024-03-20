package com.techEnthusiast.studentservice.service.impl;

import com.techEnthusiast.departmentservice.entity.Department;
import com.techEnthusiast.studentservice.dto.StudentDto;
import com.techEnthusiast.studentservice.entity.Student;
import com.techEnthusiast.studentservice.service.StudentService;
import com.techEnthusiast.studentservice.mapper.StudentMapper;
import com.techEnthusiast.studentservice.repository.StudentRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
public class StudentServiceImpl implements StudentService {

    Logger logger = LoggerFactory.getLogger(StudentService.class);
    private String baseUrl =  "http://localhost:8080/api/department/";

    private StudentRepository studentRepository;

    public StudentServiceImpl(StudentRepository studentRepository) {
        this.studentRepository = studentRepository;
    }

    @Autowired
    private RestTemplate restTemplate;


    @Override
    public StudentDto saveStudent(StudentDto studentDto) {
        Student student = StudentMapper.mapToStudent(studentDto);
        Student savedStudent = studentRepository.save(student);
        return StudentMapper.mapToStudentDto(student);
    }

    @Override
    public String getStudentWithDepartment(Long id) {
        Student student = studentRepository
                .findById(id)
                .orElseThrow(() -> new RuntimeException("No Student record found with this id"));
        Department department = restTemplate.getForObject(baseUrl+student.getDepartmentid(), Department.class);
        StringBuffer buffer = new StringBuffer();
        buffer.append("\n");
        buffer.append(student.getStudentId()+" "+student.getFirstName()+" "+student.getLastName()+" "+student.getDepartmentid());
        buffer.append("\n");
        buffer.append(department.getDepartmentName()+"  "+department.getDepartmentCode()+"  "+department.getDepartmentAddress());
        logger.info("Student with department details :"+buffer.toString());
        return buffer.toString();
    }
}
