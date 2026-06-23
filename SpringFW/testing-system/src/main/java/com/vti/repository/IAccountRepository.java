package com.vti.repository;

import com.vti.entity.Account;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

public interface IAccountRepository extends JpaRepository<Account, Integer>, JpaSpecificationExecutor<Account> {
    Account findByUserName(String name);

    boolean existsByEmailAndIdNot(String email, Integer id);

    boolean existsByUserNameAndIdNot(String userName, Integer id);

    boolean existsByEmailOrUserName(String email, String userName);


}
