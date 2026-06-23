package com.vti.service;

import com.vti.dto.PositionDTO;
import com.vti.form.PositionCreateForm;
import com.vti.form.PositionSearchForm;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;

public interface IPositionService {
    Page<PositionDTO> findAll(Pageable pageable, PositionSearchForm form);

    void create(PositionCreateForm form);

    void update(Integer id,PositionCreateForm form);

    void delete(Integer id);
}
