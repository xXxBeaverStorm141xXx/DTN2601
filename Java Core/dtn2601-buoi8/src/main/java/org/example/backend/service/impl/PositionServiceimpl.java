package org.example.backend.service.impl;

import org.example.backend.repository.IPositionRepository;
import org.example.backend.repository.impl.PositionRepositoryimpl;
import org.example.backend.service.IPositionService;
import org.example.entity.Position;

import java.util.List;

public class PositionServiceimpl implements IPositionService {
    // khoi tao retository
    IPositionRepository positionRepository = new PositionRepositoryimpl();

    @Override
    public List<Position> findAllPosition() {
        return positionRepository.findAllPosition();
    }

    @Override
    public List<Position> findByPositionIdAndName(int searchId, String searchName) {
        return positionRepository.findByPositionIdAndName(searchId, searchName);
    }

    @Override
    public boolean insertPositionName(String newName) {
        return positionRepository.insertPositionName(newName);
    }

    @Override
    public boolean deletePosition(int idName) {
        return positionRepository.deletePosition(idName);
    }

    @Override
    public boolean updatePosition(int id, String updateName) {
        return positionRepository.updatePosition(id, updateName);
    }

    @Override
    public List<Position> getPositionHasMaxEmployee() {
        return positionRepository.getPositionHasMaxEmployee();
    }

    @Override
    public List<Position> getPositionHasMinEmployee() {
        return positionRepository.getPositionHasMinEmployee();
    }

    @Override
    public boolean checkExistName(String name, Integer id) {
        return positionRepository.checkExistName(name, id);
    }
}
