package com.vti.service;

import com.vti.dto.DepartmentDTO;
import com.vti.entity.Department;

import java.util.List;

public interface IDepartmentService {

    List<DepartmentDTO> findAll();

    DepartmentDTO findById(Integer id);

    DepartmentDTO findByName(String name);

    void create(DepartmentDTO departmentDTO);

    void update(Integer id, DepartmentDTO departmentDTO);

    void delete(Integer id);

}
