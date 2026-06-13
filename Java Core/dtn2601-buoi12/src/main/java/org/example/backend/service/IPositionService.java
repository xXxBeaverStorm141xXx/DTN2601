package org.example.backend.service;

import org.example.Enums.PositionEnum;
import org.example.entity.*;

import java.util.List;

public interface IPositionService {
    List<Position> findAll();
    boolean create(PositionEnum name);
    boolean update(int id, PositionEnum name);
    boolean delete(int id);
    boolean checkExist(Integer id, PositionEnum name);
    boolean checkExistID(Integer id);
}
