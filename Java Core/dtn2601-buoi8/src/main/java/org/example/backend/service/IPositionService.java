package org.example.backend.service;

import org.example.entity.*;

import java.util.List;

public interface IPositionService {

    List<Position> findAllPosition();

    List<Position> findByPositionIdAndName(int searchId, String searchName);

    boolean insertPositionName(String newName);

    boolean deletePosition(int idName);

    boolean updatePosition(int id, String updateName);

    List<Position> getPositionHasMaxEmployee();

    List<Position> getPositionHasMinEmployee();
}
