package org.example.backend.controller;

import org.example.backend.service.IDepartmentService;
import org.example.backend.service.impl.DepartmentServiceimpl;
import org.example.entity.Department;

import java.util.List;

public class DepartmentController {
    IDepartmentService departmentService = new DepartmentServiceimpl();

    public List<Department> findAllDepartment(){
        return departmentService.findAllDepartment();
    }

    public List<Department> findByDepartmentIdAndName(int id, String name){
        return departmentService.findByDepartmentIdAndName(id,name);
    }

    public boolean insertDepartment(String name){
        return departmentService.insertDepartmentName(name);
    }

    public boolean updateDepartment(int id, String name){
        return departmentService.updateDepartment(id, name);
    }

    public boolean deleteDepartment(int id){
        return departmentService.deleteDerpartment(id);
    }

    public List<Department> getDepartmentHasMaxEmployee()
    {
        return departmentService.getDepartmentHasMaxEmployee();
    }

    public List<Department> getDepartmentHasMinEmployee()
    {
        return departmentService.getDepartmentHasMinEmployee();
    }
}
