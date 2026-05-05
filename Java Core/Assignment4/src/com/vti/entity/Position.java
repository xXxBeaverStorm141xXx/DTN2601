package com.vti.entity;

public class Position {
    private int id;
    private PositionName name;

    public enum PositionName {
        Dev, Test, Scrum_Master, PM
    }

    public int getId() {
        return id;
    }

    public PositionName getName() {
        return name;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setName(PositionName name) {
        this.name = name;
    }
}
