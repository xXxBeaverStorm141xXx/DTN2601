package com.vti.service;

import com.vti.dto.DepartmentDTO;
import com.vti.entity.Department;
import com.vti.form.DepartmentSearchForm;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;

public interface IDepartmentService {

    Page<DepartmentDTO> findAll(Pageable pageable, DepartmentSearchForm form);

    DepartmentDTO findById(Integer id);

    DepartmentDTO findByName(String name);

    void create(DepartmentDTO departmentDTO);

    void update(Integer id, DepartmentDTO departmentDTO);

    void delete(Integer id);

}
