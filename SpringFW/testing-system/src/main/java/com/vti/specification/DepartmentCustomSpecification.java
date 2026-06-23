package com.vti.specification;

import com.vti.entity.Department;
import jakarta.persistence.criteria.CriteriaBuilder;
import jakarta.persistence.criteria.CriteriaQuery;
import jakarta.persistence.criteria.Predicate;
import jakarta.persistence.criteria.Root;
import lombok.AllArgsConstructor;
import org.springframework.data.jpa.domain.Specification;

@AllArgsConstructor
public class DepartmentCustomSpecification implements Specification<Department> {
    private String field;
    private Object value;


    @Override
    public Predicate toPredicate(Root<Department> root,
                                 CriteriaQuery<?> query,
                                 CriteriaBuilder criteriaBuilder) {
        if(field.equalsIgnoreCase("name"))
        {
            return criteriaBuilder.like(root.get("name"), "%"+value+"%");
        }

        return null;
    }
}
