package org.example.backend.controller;

import org.example.Enums.PositionEnum;
import org.example.backend.service.IPositionService;
import org.example.backend.service.impl.PositionServiceimpl;
import org.example.entity.Position;

import java.util.List;

public class PositionController {
    // khoi tao positionService
    private IPositionService positionService = new PositionServiceimpl();

    public List<Position> findAll() {
        return positionService.findAll();
    }

    public boolean create(PositionEnum name) {
        return positionService.create(name);
    }

    public boolean update(int id, PositionEnum name) {
        return positionService.update(id, name);
    }

    public boolean delete(int id) {
        return positionService.delete(id);
    }

    public boolean checkExist(Integer id, PositionEnum name) {
        return positionService.checkExist(id, name);
    }

    public boolean checkExistID(Integer id) {
        return positionService.checkExistID(id);
    }
}
