package com.vti.entity;

import java.time.LocalDate;

public class Group {
    private int id;
    private String name;
    private Account creator;
    private LocalDate createDate;
    private Account[] accounts;


    public Group() {
    }

    public Group(int id, Account[] accounts, Account creator, LocalDate createDate, String name) {
        this.id = id;
        this.accounts = accounts;
        this.creator = creator;
        this.createDate = createDate;
        this.name = name;
    }

    public Group(int id, String name, Account creator, LocalDate createDate, String[] username) {
        this.id = id;
        this.name = name;
        this.creator = creator;
        this.createDate = createDate;
        //Account
        Account[] accounts = new Account[username.length];
        for (int i = 0; i < username.length; i++) {
            accounts[i] = new Account(username[i]);
        }
    }

    // Getter

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public Account getCreator() {
        return creator;
    }

    public LocalDate getCreateDate() {
        return createDate;
    }

    public Account[] getAccounts() {
        return accounts;
    }

    //Setter

    public void setId(int id) {
        this.id = id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setCreator(Account creator) {
        this.creator = creator;
    }

    public void setCreateDate(LocalDate createDate) {
        this.createDate = createDate;
    }

    public void setAccounts(Account[] accounts) {
        this.accounts = accounts;
    }
}
