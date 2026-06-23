package com.vti.repository;

import com.vti.entity.Position;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

public interface IPositionRepository extends JpaRepository<Position,Integer>, JpaSpecificationExecutor<Position> {
    boolean existsById(Integer id);

}
