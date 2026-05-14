package org.example.backend.repository;

import org.example.entity.Account;


import java.util.List;

public interface IAccountRepository {

    List<Account> findAllAccounts();

    List<Account> findByAccountIdAndName(int searchId, String searchName);

    boolean insertAccount(String newEmail, String newUserName, String newFullName, int newDepartmentId, int newPositionId);

    boolean deleteAccount(int idName);

    boolean updateAccount(int id, String updateEmail, String updateFullName, String updateUserName, int updateDepartmentId, int updatePositionId);
}
