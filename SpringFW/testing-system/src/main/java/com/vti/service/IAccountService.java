package com.vti.service;

import com.vti.entity.Account;

import java.util.List;

public interface IAccountService {
    List<Account> findAll();

    Account findById(Integer id);

    Account findByUserName(String name);

    Account create(Account account);

    Account update(Integer id, Account account);

    void deleteById(Integer id);

}
