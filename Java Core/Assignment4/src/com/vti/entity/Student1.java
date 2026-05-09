package com.vti.entity;

public abstract class Student1 extends Person {
    private int id;

    public Student1(String name, int id) {
        super(name);
        this.id = id;
    }
    public int getId() {
        return id;
    }
    public void setId(int id) {
        this.id = id;
    }
}
