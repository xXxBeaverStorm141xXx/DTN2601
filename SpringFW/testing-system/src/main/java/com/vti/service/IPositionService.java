package com.vti.service;

import com.vti.dto.PositionDTO;
import com.vti.form.PositionCreateForm;

import java.util.List;

public interface IPositionService {
    List<PositionDTO> findAll();

    void create(PositionCreateForm form);

    void update(Integer id,PositionCreateForm form);

    void delete(Integer id);
}
