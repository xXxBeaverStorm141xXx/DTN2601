package com.vti.entity;

import java.time.LocalDate;

public class Account {
    private int id;
    private String email;
    private String userName;
    private String fullName;
    private Department department;
    private Position position;
    private LocalDate createDate;
    private Group[] groups;


    public Account() {
    }

    public Account(String userName) {
        this.userName = userName;
    }

    public Account(int id, String email, String fullName, String userName) {
        this.id = id;
        this.email = email;
        this.fullName = fullName;
        this.userName = userName;
    }

    public Account(int id, String email, String userName, String fullName, Position position) {
        this.id = id;
        this.email = email;
        this.userName = userName;
        this.fullName = fullName;
        this.position = position;
        this.createDate = LocalDate.now();
    }

    public Account(int id, String email, String userName, String fullName, Position position, LocalDate createDate) {
        this.id = id;
        this.email = email;
        this.userName = userName;
        this.fullName = fullName;
        this.position = position;
        this.createDate = createDate;
    }

    // Getter

    public int getId() {
        return id;
    }

    public String getEmail() {
        return email;
    }

    public String getUserName() {
        return userName;
    }

    public String getFullName() {
        return fullName;
    }

    public Department getDepartment() {
        return department;
    }

    public Position getPosition() {
        return position;
    }

    public LocalDate getCreateDate() {
        return createDate;
    }

    public Group[] getGroups() {
        return groups;
    }

    // Setter
    public void setId(int id) {
        this.id = id;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public void setFullName(String fullName) {
        this.fullName = fullName;
    }

    public void setDepartment(Department department) {
        this.department = department;
    }

    public void setPosition(Position position) {
        this.position = position;
    }

    public void setCreateDate(LocalDate createDate) {
        this.createDate = createDate;
    }

    public void setGroups(Group[] groups) {
        this.groups = groups;
    }
}

