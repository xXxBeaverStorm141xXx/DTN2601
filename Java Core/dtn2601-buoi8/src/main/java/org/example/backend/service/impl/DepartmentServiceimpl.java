package org.example.backend.service.impl;

import org.example.backend.repository.IDepartmentRepository;
import org.example.backend.repository.impl.DepartmentRepositoryimpl;
import org.example.backend.service.IDepartmentService;
import org.example.entity.Department;

import java.util.List;

public class DepartmentServiceimpl implements IDepartmentService {
    // khoi tao retository
    IDepartmentRepository departmentRepository = new DepartmentRepositoryimpl();

    @Override
    public List<Department> findAllDepartment() {
        return departmentRepository.findAllDepartment();
    }
    @Override
    public List<Department> findByDepartmentIdAndName(int searchId, String searchName)
    {
        return departmentRepository.findByDepartmentIdAndName(searchId, searchName);
    }

    @Override
    public boolean insertDepartmentName(String newName)
    {

        return departmentRepository.insertDepartmentName(newName);
    }

    @Override
    public boolean deleteDerpartment(int idName)
    {

        return departmentRepository.deleteDerpartment(idName);
    }

    @Override
    public boolean updateDepartment(int id, String updateName)
    {
        return departmentRepository.updateDepartment(id, updateName);
    }

    @Override
    public List<Department> getDepartmentHasMaxEmployee()
    {
        return departmentRepository.getDepartmentHasMaxEmployee();
    }

    @Override
    public List<Department> getDepartmentHasMinEmployee()
    {
        return departmentRepository.getDepartmentHasMinEmployee();
    }

}
