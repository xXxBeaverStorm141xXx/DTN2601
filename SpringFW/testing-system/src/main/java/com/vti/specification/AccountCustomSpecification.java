package com.vti.specification;

import com.vti.entity.Account;
import jakarta.persistence.criteria.CriteriaBuilder;
import jakarta.persistence.criteria.CriteriaQuery;
import jakarta.persistence.criteria.Predicate;
import jakarta.persistence.criteria.Root;
import lombok.AllArgsConstructor;
import lombok.NonNull;
import org.springframework.data.jpa.domain.Specification;

@AllArgsConstructor
public class AccountCustomSpecification implements Specification<Account> {
    @NonNull
    private String field;
    @NonNull
    private Object value;

    @Override
    public Predicate toPredicate(Root<Account> root,
                                 CriteriaQuery<?> query,
                                 CriteriaBuilder criteriaBuilder) {
        if("userName".equalsIgnoreCase(field))
        {
            return criteriaBuilder.like(root.get("userName"),"%"+value+"%");
        }

        if("fullName".equalsIgnoreCase(field))
        {
            return criteriaBuilder.like(root.get("fullName"),"%"+value+"%");
        }

        if("email".equalsIgnoreCase(field))
        {
            return criteriaBuilder.like(root.get("email"),"%"+value+"%");
        }

        if("departmentName".equalsIgnoreCase(field))
        {
            return criteriaBuilder.like(root.get("department").get("name"),"%"+value+"%");
        }

        if("positionName".equalsIgnoreCase(field))
        {
            return criteriaBuilder.like(root.get("position").get("name"),"%"+value+"%");
        }
        return null;
    }
}
