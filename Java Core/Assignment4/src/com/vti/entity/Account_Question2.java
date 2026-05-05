package com.vti.entity;

public class Account_Question2 {
    private String id;
    private String name;
    private int balance;


    public Account_Question2(String id, String name, int balance) {
        this.id = id;
        this.name = name;
        this.balance = balance;
    }

    public String getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public int getBalance() {
        return balance;
    }

    public int credit(int amount){
        return this.balance += amount;
    }
    public int debit(int amount){
        return this.balance -= amount;
    }
    public void transferTo(Account_Question2 account_question2, int amount){
        this.balance -= amount;
        account_question2.balance += amount;
    }

}
