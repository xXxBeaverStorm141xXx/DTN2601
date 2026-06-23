package com.vti.service;

import com.vti.dto.AccountDTO;
import com.vti.entity.Account;
import com.vti.form.AccountCreateForm;
import com.vti.form.AccountSearchForm;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;

public interface IAccountService {
    Page<AccountDTO> findAll(Pageable pageable, AccountSearchForm form);

    AccountDTO findById(Integer id);

    Account findByUserName(String name);

    void create(AccountCreateForm form);

    void update(Integer id, AccountCreateForm accountCreateForm);

    void deleteById(Integer id);

}
