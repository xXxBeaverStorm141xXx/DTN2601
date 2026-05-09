package com.vti.entity;

public class NhanVien extends CanBo{
    private String task;

    public NhanVien(String name, int age, Gender gender, String address, String task) {
        super(name, age, gender, address);
        this.task = task;
    }

    @Override
    public String toString() {
        return super.toString() + "Position: NhanVien [task=" + task + "]";
    }
}
