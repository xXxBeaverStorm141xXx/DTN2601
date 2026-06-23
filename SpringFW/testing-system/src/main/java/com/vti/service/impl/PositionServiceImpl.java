package com.vti.service.impl;

import com.vti.dto.PositionDTO;
import com.vti.entity.Position;
import com.vti.enums.PositionName;
import com.vti.form.PositionCreateForm;
import com.vti.form.PositionSearchForm;
import com.vti.repository.IPositionRepository;
import com.vti.service.IPositionService;
import com.vti.specification.PositionCustomSpecification;
import org.apache.commons.lang3.StringUtils;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

import static com.vti.enums.PositionName.toEnum;

@Service
public class PositionServiceImpl implements IPositionService {

    @Autowired
    private IPositionRepository positionRepository;

    @Autowired
    private ModelMapper modelMapper;

//    @Override
//    public List<PositionDTO> findAll() {
//        List<Position> positions = positionRepository.findAll();
//        List<PositionDTO> positionDTOS = new ArrayList<>();
//        for (Position position : positions) {
//            PositionDTO dto = modelMapper.map(position, PositionDTO.class);
//            positionDTOS.add(dto);
//        }
//        return positionDTOS;
//    }
    @Override
    public Page<PositionDTO> findAll(Pageable pageable, PositionSearchForm form) {
        Specification<Position> where = Specification.unrestricted();

        if(StringUtils.isNotEmpty(form.getName())){
            PositionCustomSpecification name = new PositionCustomSpecification("name", form.getName());
            where = where.and(name);
        }

        Page<Position> positionPage = positionRepository.findAll(where, pageable);
        Page<PositionDTO> dtoPage = positionPage.map(position -> modelMapper.map(position, PositionDTO.class));
        return dtoPage;
    }

    @Override
    public void create(PositionCreateForm form) {
        PositionName newPositionName = toEnum(form.getName());
        if (newPositionName == null) {
            throw new RuntimeException("Chức vụ không hợp lệ!!!");
        }
        Position position = new Position();
        position.setName(newPositionName);

        positionRepository.save(position);
    }

    @Override
    public void update(Integer id,PositionCreateForm form) {
        Position position = positionRepository.findById(id).orElse(null);
        if (position == null) {
            throw new RuntimeException("ID không tồn tại!!!");
        }
        PositionName positionName = toEnum(form.getName());
        if (positionName == null) {
            throw new RuntimeException("Position không hợp lệ!");
        }
        position.setName(positionName);
        positionRepository.save(position);
    }

    @Override
    public void delete(Integer id) {
        if (!positionRepository.existsById(id)) {
            throw new RuntimeException("Position ID not found!");
        }
        positionRepository.deleteById(id);
    }
}
