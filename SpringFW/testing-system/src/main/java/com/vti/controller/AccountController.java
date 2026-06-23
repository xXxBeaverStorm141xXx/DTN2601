package com.vti.controller;


import com.vti.dto.AccountDTO;
import com.vti.entity.Account;
import com.vti.form.AccountCreateForm;
import com.vti.form.AccountSearchForm;
import com.vti.service.IAccountService;
import jakarta.validation.Valid;
import org.springframework.data.domain.Page;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/accounts")
@Validated
public class AccountController {
    @Autowired
    private IAccountService accountService;

    @GetMapping
    public ResponseEntity<Page<AccountDTO>> findAll(Pageable pageable,AccountSearchForm form) {
        Page<AccountDTO> accounts = accountService.findAll(pageable, form);
        return new ResponseEntity<>(accounts, HttpStatus.OK);
    }


    @GetMapping(value = "/{id}")
    public ResponseEntity<AccountDTO> findById(@PathVariable(name = "id") Integer id) {
        AccountDTO dto = accountService.findById(id);
        return new ResponseEntity<>(dto, HttpStatus.OK);
    }

    @GetMapping("/search")
    public ResponseEntity<Account> findByUserName(@RequestParam String userName) {
        Account account = accountService.findByUserName(userName);
        return new ResponseEntity<>(account, HttpStatus.OK);
    }

//    @PostMapping
//    public ResponseEntity<Account> create (@RequestBody Account account) {
//        accountService.create(account);
//        return new ResponseEntity<>(account, HttpStatus.CREATED);
//    }

    @PostMapping
    public ResponseEntity<?> create(@RequestBody @Valid AccountCreateForm form){
        accountService.create(form);
        return new ResponseEntity<>("Create Successfully", HttpStatus.CREATED);
    }

//    @PutMapping(value = "/{id}")
//    public ResponseEntity<Account> update (@PathVariable(name = "id") Integer id, @RequestBody Account account) {
//        accountService.update(id, account);
//        return new ResponseEntity<>(account, HttpStatus.CREATED);
//    }


    @PutMapping(value = "/{id}")
    public ResponseEntity<?> update (@PathVariable(name = "id") Integer id, @RequestBody AccountCreateForm form) {
        accountService.update(id, form);
        return new ResponseEntity<>("Update Successfully", HttpStatus.CREATED);
    }


    @DeleteMapping("/{id}")
    public ResponseEntity<String> delete( @PathVariable Integer id) {
        accountService.deleteById(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
}
