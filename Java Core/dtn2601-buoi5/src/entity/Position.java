package entity;

import Enum.PositionEnum;
public class Position {
    private int id;
    private PositionEnum name;

    public Position() {
    }

    public Position(int id, PositionEnum name) {
        this.id = id;
        this.name = name;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public PositionEnum getName() {
        return name;
    }

    public void setName(PositionEnum name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "Position{" +
                "id=" + id +
                ", name=" + name +
                '}';
    }
}
