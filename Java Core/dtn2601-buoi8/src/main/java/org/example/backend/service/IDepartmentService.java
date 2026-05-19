package org.example.backend.service;

import org.example.entity.Department;

import java.util.List;

public interface IDepartmentService {

    List<Department> findAllDepartment();

    List<Department> findByDepartmentIdAndName(int searchId, String searchName);

    boolean insertDepartmentName(String newName);

    boolean deleteDerpartment(int idName);

    boolean updateDepartment(int id, String updateName);

    List<Department> getDepartmentHasMaxEmployee();

    List<Department> getDepartmentHasMinEmployee();

    boolean checkExistName(String name, Integer id);
}
