package com.techEnthusiast.departmentservice.service;

import com.techEnthusiast.departmentservice.dto.DepartmentDto;

public interface DepartmentService {
    DepartmentDto saveDepartment(DepartmentDto departmentDto);

    DepartmentDto getDepartmentById(Long id);
}
