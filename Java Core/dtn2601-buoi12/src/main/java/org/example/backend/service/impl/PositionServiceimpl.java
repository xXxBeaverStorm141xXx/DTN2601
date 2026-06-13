package org.example.backend.service.impl;

import org.example.Enums.PositionEnum;
import org.example.backend.repository.IPositionRepository;
import org.example.backend.repository.impl.PositionRepositoryimpl;
import org.example.backend.service.IPositionService;
import org.example.entity.Position;

import java.util.List;

public class PositionServiceimpl implements IPositionService {
    // khoi tao positionRepository
    private IPositionRepository positionRepository = new PositionRepositoryimpl();

    @Override
    public List<Position> findAll() {
        return positionRepository.findAll();
    }

    @Override
    public boolean create(PositionEnum name) {
        return positionRepository.create(name);
    }

    @Override
    public boolean update(int id, PositionEnum name) {
        return positionRepository.update(id, name);
    }

    @Override
    public boolean delete(int id) {
        return positionRepository.delete(id);
    }

    @Override
    public boolean checkExist(Integer id, PositionEnum name) {
        return positionRepository.checkExist(id, name);
    }

    @Override
    public boolean checkExistID(Integer id) {
        return positionRepository.checkExistID(id);
    }
}
