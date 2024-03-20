package com.techEnthusiast.departmentservice.mapper;

import com.techEnthusiast.departmentservice.dto.DepartmentDto;
import com.techEnthusiast.departmentservice.entity.Department;

public class DepartmentMapper {

    public static Department mapToDepartment(DepartmentDto departmentDto){
        Department department = new Department(
                departmentDto.getDepartmentName(),
                departmentDto.getDepartmentAddress(),
                departmentDto.getDepartmentCode()
        );
        return department;
    }


    public static DepartmentDto mapTodepartmentDto(Department department){
        DepartmentDto departmentDto = new DepartmentDto(
                department.getDepartmentName(),
                department.getDepartmentAddress(),
                department.getDepartmentCode()
        );
        return departmentDto;
    }
}
