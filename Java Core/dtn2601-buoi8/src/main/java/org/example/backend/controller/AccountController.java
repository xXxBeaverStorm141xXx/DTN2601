package org.example.backend.controller;

import org.example.backend.service.IAccountService;
import org.example.backend.service.impl.AccountServiceimpl;
import org.example.entity.Account;

import java.util.List;

public class AccountController {
    IAccountService accountService = new AccountServiceimpl();

    public List<Account> findAllAccounts() {
        return accountService.findAllAccounts();
    }

    public List<Account> findByAccountIdAndName(int searchId, String searchName) {
        return accountService.findByAccountIdAndName(searchId, searchName);
    }

    public boolean insertAccount(String newEmail, String newUserName, String newFullName, int newDepartmentId, int newPositionId) {
        return accountService.insertAccount(newEmail, newUserName, newFullName, newDepartmentId, newPositionId);
    }

    public boolean deleteAccount(int idName) {
        return accountService.deleteAccount(idName);
    }

    public boolean updateAccount(int id, String updateEmail, String updateFullName, String updateUserName, int updateDepartmentId, int updatePositionId) {
        return accountService.updateAccount(id, updateEmail, updateFullName, updateUserName, updateDepartmentId, updatePositionId);
    }

    public boolean checkExistUserName(String userName, Integer id) {
        return accountService.checkExistUserName(userName,id);
    }

    public boolean checkExistEmail(String email, Integer id) {
        return accountService.checkExistEmail(email,id);
    }
}
