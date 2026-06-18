package com.vti.dto;

import com.vti.entity.Department;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class DepartmentDTO {
    private Integer id;
    private String name;

    public DepartmentDTO(Department department) {
        this.id = department.getId();
        this.name = department.getName();
    }
}
