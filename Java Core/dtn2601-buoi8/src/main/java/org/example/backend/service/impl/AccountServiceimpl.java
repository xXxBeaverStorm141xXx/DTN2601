package org.example.backend.service.impl;

import org.example.backend.repository.IAccountRepository;
import org.example.backend.repository.impl.AccountRepositoryimpl;
import org.example.backend.service.IAccountService;
import org.example.entity.Account;

import java.util.List;

public class AccountServiceimpl implements IAccountService {
    IAccountRepository accountRepository = new AccountRepositoryimpl();

    @Override
    public List<Account> findAllAccounts() {
        return accountRepository.findAllAccounts();
    }

    @Override
    public List<Account> findByAccountIdAndName(int searchId, String searchName) {
        return accountRepository.findByAccountIdAndName(searchId, searchName);
    }

    @Override
    public boolean insertAccount(String newEmail, String newUserName, String newFullName, int newDepartmentId, int newPositionId) {
        return accountRepository.insertAccount(newEmail, newUserName, newFullName, newDepartmentId, newPositionId);
    }

    @Override
    public boolean deleteAccount(int idName) {
        return accountRepository.deleteAccount(idName);
    }

    @Override
    public boolean updateAccount(int id, String updateEmail, String updateFullName, String updateUserName, int updateDepartmentId, int updatePositionId) {
        return accountRepository.updateAccount(id, updateEmail, updateFullName, updateUserName, updateDepartmentId, updatePositionId);
    }

    @Override
    public boolean checkExistUserName(String userName, Integer id) {
        return accountRepository.checkExistUserName(userName, id);
    }

    @Override
    public boolean checkExistEmail(String email, Integer id) {
        return accountRepository.checkExistEmail(email, id);
    }
}
