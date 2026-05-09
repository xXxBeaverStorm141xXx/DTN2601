package com.vti.entity;

public class CongNhan extends CanBo{
    private int rank;

    public CongNhan(String name, int age, Gender gender, String address, int rank) {
        super(name, age, gender, address);
        this.rank = rank;
    }

    @Override
    public String toString() {
        return super.toString() + "CongNhan{" +
                "rank=" + rank + "} ";
    }
}
