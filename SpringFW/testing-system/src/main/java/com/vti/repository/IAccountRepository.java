package com.vti.repository;

import com.vti.entity.Account;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IAccountRepository extends JpaRepository<Account, Integer> {
    Account findByUserName(String name);

    boolean existsByEmailAndId(String email, Integer id);

    boolean existsByUserNameAndId(String userName, Integer id);

    boolean existsByEmailOrUserName(String email, String userName);


}
