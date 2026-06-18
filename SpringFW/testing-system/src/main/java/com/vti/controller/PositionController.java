package com.vti.controller;


import com.vti.dto.PositionDTO;
import com.vti.entity.Account;
import com.vti.entity.Department;
import com.vti.entity.Position;
import com.vti.form.AccountCreateForm;
import com.vti.form.PositionCreateForm;
import com.vti.service.IPositionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/positions")
public class PositionController {

    @Autowired
    private IPositionService positionService;

    @GetMapping
    public ResponseEntity<List<PositionDTO>> findAll(){
        List<PositionDTO> positionDTOS = positionService.findAll();
        return new ResponseEntity<>(positionDTOS, HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<?> create(@RequestBody PositionCreateForm form) {
        positionService.create(form);
        return new ResponseEntity<>("Create Successfully", HttpStatus.CREATED);
    }

    @PutMapping(value = "/{id}")
    public ResponseEntity<?> update (@PathVariable(name = "id") Integer id, @RequestBody PositionCreateForm form) {
        positionService.update(id, form);
        return new ResponseEntity<>("Update Successfully", HttpStatus.CREATED);
    }


    @DeleteMapping("/{id}")
    public ResponseEntity<?> delete(@PathVariable Integer id) {
        positionService.delete(id);
        return new ResponseEntity<>("Delete Successfully", HttpStatus.OK);
    }




}
