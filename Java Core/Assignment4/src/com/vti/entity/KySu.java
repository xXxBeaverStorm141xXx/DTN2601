package com.vti.entity;

public class KySu extends CanBo{
    private String specialized;

    public KySu(String name, int age, Gender gender, String address, String specialized) {
        super(name, age, gender, address);
        this.specialized = specialized;
    }

    @Override
    public String toString() {
       return super.toString() + "Position: KySu [specialized=" + specialized + "]";
    }
}
