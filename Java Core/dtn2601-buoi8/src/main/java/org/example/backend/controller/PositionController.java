package org.example.backend.controller;

import org.example.backend.service.IPositionService;
import org.example.backend.service.impl.PositionServiceimpl;
import org.example.entity.Position;

import java.util.List;

public class PositionController {
    IPositionService positionService = new PositionServiceimpl();

    public List<Position> findAllPosition() {
        return positionService.findAllPosition();
    }

    public List<Position> findByPositionIdAndName(int searchId, String searchName) {
        return positionService.findByPositionIdAndName(searchId, searchName);
    }

    public boolean insertPositionName(String newName) {
        return positionService.insertPositionName(newName);
    }

    public boolean deletePosition(int idName) {
        return positionService.deletePosition(idName);
    }

    public boolean updatePosition(int id, String updateName) {
        return positionService.updatePosition(id, updateName);
    }

    public List<Position> getPositionHasMaxEmployee() {
        return positionService.getPositionHasMaxEmployee();
    }

    public List<Position> getPositionHasMinEmployee() {
        return positionService.getPositionHasMinEmployee();
    }
    public boolean checkExistName(String name, Integer id) {
        return positionService.checkExistName(name, id);
    }
}
