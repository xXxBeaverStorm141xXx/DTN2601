package com.vti.controller;

import com.vti.dto.DepartmentDTO;
import com.vti.entity.Department;
import com.vti.service.IDepartmentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/departments")
public class DepartmentController {
    @Autowired
    private IDepartmentService departmentService;

    @GetMapping
    public ResponseEntity<List<DepartmentDTO>> findAll() {
        List<DepartmentDTO> departmentDTOS = departmentService.findAll();
        return new ResponseEntity<>(departmentDTOS, HttpStatus.OK);
    }


    // xem thong tin department theo id http://localhost:8080/api/departments/{id}
    @GetMapping(value = "/{id}")
    public ResponseEntity<DepartmentDTO> findById(@PathVariable(name = "id") Integer i) {
        DepartmentDTO departmentDTO = departmentService.findById(i);
        return new ResponseEntity<>(departmentDTO, HttpStatus.OK);
    }

    // tim kiem theo ten phong ban  name like name
    @GetMapping("/search")
    public ResponseEntity<DepartmentDTO> findByName(@RequestParam String name) {
        DepartmentDTO departmentDTO = departmentService.findByName(name);
        return new ResponseEntity<>(departmentDTO, HttpStatus.OK);
    }


    @PostMapping
    public ResponseEntity<?> create(@RequestBody DepartmentDTO departmentDTO) {
        departmentService.create(departmentDTO);
        return new ResponseEntity<>("Create Successfully", HttpStatus.CREATED);
    }


    // update tên phòng ban của id = ? thành hello
    @PutMapping(value = "/{id}")
    public ResponseEntity<?> update(@PathVariable(name = "id") Integer id,@RequestBody DepartmentDTO departmentDTO) {
        departmentService.update(id, departmentDTO);
        return new ResponseEntity<>("Update Successfully", HttpStatus.OK);
    }

    //xoa phong ban
    @DeleteMapping(value = "/{id}")
    public ResponseEntity<?> delete(@PathVariable(name = "id") Integer id) {
        departmentService.delete(id);
        return new ResponseEntity<>("Delete Successfully", HttpStatus.OK);
    }
}
