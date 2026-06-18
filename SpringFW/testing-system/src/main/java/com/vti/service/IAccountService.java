package com.vti.service;

import com.vti.dto.AccountDTO;
import com.vti.entity.Account;
import com.vti.form.AccountCreateForm;

import java.util.List;

public interface IAccountService {
    List<AccountDTO> findAll();

    AccountDTO findById(Integer id);

    Account findByUserName(String name);

    void create(AccountCreateForm form);

    void update(Integer id, AccountCreateForm accountCreateForm);

    void deleteById(Integer id);

}
