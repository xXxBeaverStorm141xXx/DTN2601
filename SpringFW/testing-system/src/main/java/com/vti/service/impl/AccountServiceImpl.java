package com.vti.service.impl;

import com.vti.dto.AccountDTO;
import com.vti.entity.Account;
import com.vti.entity.Department;
import com.vti.entity.Position;
import com.vti.form.AccountCreateForm;
import com.vti.form.AccountSearchForm;
import com.vti.repository.IAccountRepository;
import com.vti.repository.IDepartmentRepository;
import com.vti.repository.IPositionRepository;
import com.vti.service.IAccountService;
import com.vti.specification.AccountCustomSpecification;
import org.apache.commons.lang3.StringUtils;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Objects;

@Service
public class AccountServiceImpl implements IAccountService {
    @Autowired
    private IAccountRepository accountRepository;

    @Autowired
    private ModelMapper modelMapper;

    @Autowired
    private IDepartmentRepository departmentRepository;

    @Autowired
    private IPositionRepository positionRepository;

//    @Override
//    public List<AccountDTO> findAll() {
//        List<Account> accounts = accountRepository.findAll();
//        // chuyen tu list account -> LIST accountDTO
//        List<AccountDTO> dtos = new ArrayList<>();
//        for (Account account : accounts) {
////            dtos.add(new AccountDTO(account));
//
//            // 1.account: entity muon convert sang DTO
//            AccountDTO dto = modelMapper.map(account, AccountDTO.class);
//            dtos.add(dto);
//        }
//        return dtos;
//    }

    @Override
    public Page<AccountDTO> findAll(Pageable pageable, AccountSearchForm form) {
        Specification<Account> where = Specification.unrestricted();
        if(StringUtils.isNotEmpty(form.getUsername())){
            AccountCustomSpecification username = new AccountCustomSpecification("userName", form.getUsername());
            where = where.and(username);
        }
        if(StringUtils.isNotEmpty(form.getEmail())){
            AccountCustomSpecification email = new AccountCustomSpecification("email", form.getEmail());
            where = where.and(email);
        }
        if(StringUtils.isNotEmpty(form.getFullname())){
            AccountCustomSpecification fullName = new AccountCustomSpecification("fullName", form.getFullname());
            where = where.and(fullName);
        }
        if(StringUtils.isNotEmpty(form.getDepartmentName())){
            AccountCustomSpecification departmentName = new AccountCustomSpecification("departmentName", form.getDepartmentName());
            where = where.and(departmentName);
        }
        if(StringUtils.isNotEmpty(form.getPositionName())){
            AccountCustomSpecification positionName = new AccountCustomSpecification("positionName", form.getPositionName());
            where = where.and(positionName);
        }

        Page<Account> accountPage = accountRepository.findAll(where, pageable);


        Page<AccountDTO> dtoPage = accountPage.map(account -> modelMapper.map(account, AccountDTO.class));
        return dtoPage;
    }

    @Override
    public AccountDTO findById(Integer id) {
        //tim account theo id
        Account account = accountRepository.findById(id).orElse(null);
        if (Objects.isNull(account)) {
            throw new RuntimeException("ID not found");
        }
        // chuyen tu account -> accountDTO
        return new AccountDTO(account);
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
    @Transactional
    public void create(AccountCreateForm form) {
//        if (accountRepository.existsByEmailOrUserName(
//                account.getEmail(),
//                account.getUserName())) {
//
//            throw new RuntimeException("Email hoặc User Name đã tồn tại");
//        }
//        return accountRepository.save(account);

        // Form -> entity
        Account account = new Account();
        account.setEmail(form.getEmail());
        account.setUserName(form.getUsername());
        account.setFullName(form.getFullname());
        account.setPassword(form.getPassword());
        if (accountRepository.existsByEmailOrUserName(
                account.getEmail(),
                account.getUserName())) {

            throw new RuntimeException("Email hoặc User Name đã tồn tại");
        }
        Department department = departmentRepository.findById(form.getDepartmentId()).orElse(null);
        if(Objects.isNull(department)){
            throw new RuntimeException("Department ID not found");
        }
        account.setDepartment(department);
        Position position = positionRepository.findById(form.getPositionId()).orElse(null);
        if(Objects.isNull(position)){
            throw new RuntimeException("Position ID not found");
        }
        account.setPosition(position);

        //Luu vao DB
        accountRepository.save(account);
    }

    @Override
    public void update(Integer id, AccountCreateForm accountCreateForm) {
        Account accountUpdate = accountRepository.findById(id).orElse(null);
        if(Objects.isNull(accountUpdate)){
            throw new RuntimeException("ID not found");
        }
        if(accountRepository.existsByEmailAndIdNot(accountCreateForm.getEmail(),id)){
            throw new RuntimeException("Email này đã tồn tại");
        }
        if (accountRepository.existsByUserNameAndIdNot(accountCreateForm.getUsername(),id)){
            throw new RuntimeException("User này đã tồn tại");
        }


        Department department = departmentRepository.findById(accountCreateForm.getDepartmentId()).orElse(null);
        if(Objects.isNull(department)){
            throw new RuntimeException("Department ID not found");
        }
        Position position = positionRepository.findById(accountCreateForm.getPositionId()).orElse(null);
        if(Objects.isNull(position)){
            throw new RuntimeException("Position ID not found");
        }
        accountUpdate.setUserName(accountCreateForm.getUsername());
        accountUpdate.setEmail(accountCreateForm.getEmail());
        accountUpdate.setFullName(accountCreateForm.getFullname());
        accountUpdate.setDepartment(department);
        accountUpdate.setPosition(position);
        accountRepository.save(accountUpdate);

    }

    @Override
    public void deleteById(Integer id) {
        accountRepository.deleteById(id);
    }



}
