package com.vti.service.impl;

import com.vti.entity.Account;
import com.vti.entity.Department;
import com.vti.repository.IAccountRepository;
import com.vti.service.IAccountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Objects;

@Service
public class AccountServiceImpl implements IAccountService {
    @Autowired
    private IAccountRepository accountRepository;


    @Override
    public List<Account> findAll() {
        return accountRepository.findAll();
    }

    @Override
    public Account findById(Integer id) {
        return accountRepository.findById(id).orElse(null);
    }

    @Override
    public Account findByUserName(String name) {
        Account account = accountRepository.findByUserName(name);
        if(Objects.isNull(account))
        {
            throw new RuntimeException("Không tìm thấy Account");
        }
        return account;
    }

    @Override
    public Account create(Account account) {
        if (accountRepository.existsByEmailOrUserName(
                account.getEmail(),
                account.getUserName())) {

            throw new RuntimeException("Email hoặc User Name đã tồn tại");
        }
        return accountRepository.save(account);
    }

    @Override
    public Account update(Integer id, Account account) {
        Account accountUpdate = accountRepository.findById(id).orElse(null);
        if(Objects.isNull(accountUpdate)){
            throw new RuntimeException("ID not found");
        }
        if(accountRepository.existsByEmailAndId(account.getEmail(),id)){
            throw new RuntimeException("Email này đã tồn tại");
        }
        if (accountRepository.existsByUserNameAndId(account.getUserName(),id)){
            throw new RuntimeException("User này đã tồn tại");
        }
        accountUpdate.setUserName(account.getUserName());
        accountUpdate.setEmail(account.getEmail());
        accountUpdate.setFullName(account.getFullName());
        accountRepository.save(accountUpdate);
        return accountUpdate;
    }

    @Override
    public void deleteById(Integer id) {
        accountRepository.deleteById(id);
    }
}
