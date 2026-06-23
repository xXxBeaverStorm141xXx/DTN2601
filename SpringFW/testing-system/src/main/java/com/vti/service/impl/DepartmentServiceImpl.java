package com.vti.service.impl;

import com.vti.dto.DepartmentDTO;
import com.vti.entity.Department;
import com.vti.form.DepartmentSearchForm;
import com.vti.repository.IDepartmentRepository;
import com.vti.service.IDepartmentService;
import com.vti.specification.DepartmentCustomSpecification;
import org.apache.commons.lang3.StringUtils;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.Optional;

@Service
public class DepartmentServiceImpl implements IDepartmentService {
    @Autowired // khoi tao doi tuong
    private IDepartmentRepository departmentRepository;
    @Autowired
    private ModelMapper modelMapper;

    @Override
    public Page<DepartmentDTO> findAll(Pageable pageable, DepartmentSearchForm form) {
//        List<Department> departments = departmentRepository.findAll();
//        List<DepartmentDTO> departmentDTOS = new ArrayList<>();
//        for (Department department : departments) {
//            departmentDTOS.add(new DepartmentDTO(department));
//        }
//        return departmentDTOS;
        Specification<Department> where = Specification.unrestricted();
        if(StringUtils.isNotEmpty(form.getName())){
            DepartmentCustomSpecification name = new DepartmentCustomSpecification("name", form.getName());
            where = where.and(name);
        }

        Page<Department> departmentPage = departmentRepository.findAll(where, pageable);
        Page<DepartmentDTO> dtoPage = departmentPage.map(department ->  modelMapper.map(department, DepartmentDTO.class));
        return dtoPage;
    }

    @Override
    public DepartmentDTO findById(Integer id) {
//       Optional<Department> optional = departmentRepository.findById(id);
//        if(optional.isPresent()){ // co gtri
//            Department department = optional.get();
//            return department;
//        } else { // khong co gtri
//            return null;
//        }
        Department department = departmentRepository.findById(id).orElse(null);
        if(Objects.isNull(department)){
            throw new RuntimeException("Không tìm thấy Department");
        }
        return new DepartmentDTO(department);
    }

    @Override
    public DepartmentDTO findByName(String name) {
        Department department = departmentRepository.findByName(name);
        return new DepartmentDTO(department);
    }

    @Override
    public void create(DepartmentDTO departmentDTO) {
        if(departmentRepository.existsByName(departmentDTO.getName()))
        {
            throw new RuntimeException("Department already exists");
        }
        Department newDepartment = modelMapper.map(departmentDTO, Department.class);
        departmentRepository.save(newDepartment);
    }

    @Override
    public void update(Integer id, DepartmentDTO departmentDTO) {
        // tim department theo id dua vao
        Department departmentUpdate = departmentRepository.findById(id).orElse(null);
        if(Objects.isNull(departmentUpdate)){
            throw new RuntimeException("ID not found");
        }
        if(departmentRepository.existsByNameAndIdNot(departmentDTO.getName(),id)){
            throw new RuntimeException("Ten này đã tồn tại");
        }
        departmentUpdate.setName(departmentDTO.getName());
        departmentRepository.save(departmentUpdate);
    }

    @Override
    public void delete(Integer id) {
        if (!departmentRepository.existsById(id)) {
            throw new RuntimeException("ID not found");
        }
        departmentRepository.deleteById(id);
    }
}
