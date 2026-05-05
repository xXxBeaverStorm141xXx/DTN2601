package com.vti.backend;

import com.vti.entity.Account;
import com.vti.entity.Department;
import com.vti.entity.Group;
import com.vti.entity.Position;

import java.time.LocalDate;

public class Exercise1 {
    public void Question1(){
        Department department = new Department();
        Department department1 = new Department("Department 1");
    }

    public void Question2() {
        Account account = new Account();
        Account account2 = new Account(2, "phucdh1@gmail.com", "phucdh141", "fullname2");
        Position pos3 = new Position();
        Account account3 = new Account(3, "phucdh2@gmail.com", "Phucdh14", "fullname3", pos3);
        Position pos4 = new Position();
        Account account4 = new Account(4, "phucdh3@gmail.com", "PhucDH1_1", "fullname4", pos4, LocalDate.of(2026, 05, 05));
    }

    public void Question3() {
        Account creator = new Account("admin");

        Account[] Account = new Account[2];
        Account[0] = new Account("user1");
        Account[1] = new Account("user2");

        Account creator2 = new Account("leader");

        String[] usernames = {"dev1", "dev2", "dev3"};

        Group group = new Group();
        Group group2 = new Group(
                2,
                Account,
                creator,
                LocalDate.now(),
                "Java"
        );
        Group group3 = new Group(
                3,
                "Develop",
                creator2,
                LocalDate.now(),
                usernames
        );


    }
}
