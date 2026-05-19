package org.example.backend.repository;

import org.example.entity.Position;

import java.util.List;

public interface IPositionRepository {
    List<Position> findAllPosition();

    List<Position> findByPositionIdAndName(int searchId, String searchName);

    boolean insertPositionName(String newName);

    boolean deletePosition(int idName);

    boolean updatePosition(int id, String updateName);

    List<Position> getPositionHasMaxEmployee();

    List<Position> getPositionHasMinEmployee();

    boolean checkExistName(String name, Integer id);


}
