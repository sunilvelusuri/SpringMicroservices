package com.techEnthusiast.departmentservice.dto;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Data
@AllArgsConstructor
public class DepartmentDto {
    private String departmentName;
    private String departmentAddress;
    private String departmentCode;
}
