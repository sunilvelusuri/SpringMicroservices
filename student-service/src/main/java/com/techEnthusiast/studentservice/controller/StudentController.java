package com.techEnthusiast.studentservice.controller;

import com.techEnthusiast.studentservice.dto.StudentDto;
import com.techEnthusiast.studentservice.entity.Student;
import com.techEnthusiast.studentservice.service.StudentService;
import io.github.resilience4j.circuitbreaker.annotation.CircuitBreaker;
import io.github.resilience4j.retry.annotation.Retry;
import io.github.resilience4j.timelimiter.annotation.TimeLimiter;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.concurrent.CompletableFuture;

@RestController
@RequestMapping("api/student")
public class StudentController {

    private StudentService studentService;

    public StudentController(StudentService studentService) {
        this.studentService = studentService;
    }

    @PostMapping("/save")
    public ResponseEntity<StudentDto> saveDepartment(@RequestBody StudentDto studentDto){
        System.out.println(studentDto + "In controller");
        return new ResponseEntity<>(studentService.saveStudent(studentDto), HttpStatus.CREATED);
    }

    @GetMapping("/{id}")
    @CircuitBreaker(name="studentservice", fallbackMethod="fallbackMethod")
    @Retry(name="studentservice")
    @TimeLimiter(name="studentservice")
    public CompletableFuture<String> getStudentWithDepartment(@PathVariable Long id) {
        return CompletableFuture.supplyAsync(()->studentService.getStudentWithDepartment(id));
    }

    @ResponseStatus(HttpStatus.BAD_REQUEST)
    public CompletableFuture<String> fallbackMethod(@PathVariable Long id, RuntimeException ex) {
        return CompletableFuture.supplyAsync(()->"Service is down. Please try after some time.");
    }

}
