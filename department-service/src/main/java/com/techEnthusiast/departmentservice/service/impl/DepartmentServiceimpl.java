package com.techEnthusiast.departmentservice.service.impl;

import com.techEnthusiast.departmentservice.dto.DepartmentDto;
import com.techEnthusiast.departmentservice.entity.Department;
import com.techEnthusiast.departmentservice.mapper.DepartmentMapper;
import com.techEnthusiast.departmentservice.repository.DepartmentRepository;
import com.techEnthusiast.departmentservice.service.DepartmentService;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class DepartmentServiceimpl implements DepartmentService {

    private DepartmentRepository departmentRepository;

    @Autowired
    public DepartmentServiceimpl(DepartmentRepository departmentRepository) {
        this.departmentRepository = departmentRepository;
    }

    @Override
    public DepartmentDto saveDepartment(DepartmentDto departmentDto) {

        System.out.println("saveDepartment Called");

        Department department = DepartmentMapper.mapToDepartment(departmentDto);
        Department savedDepartment = departmentRepository.save(department);
        return DepartmentMapper.mapTodepartmentDto(savedDepartment);
    }

    @Override
    public DepartmentDto getDepartmentById(Long id) {
        Department department = departmentRepository
                .findById(id)
                .orElseThrow(() -> new RuntimeException("No Department found with this id"));
        return DepartmentMapper.mapTodepartmentDto(department);

    }
}
