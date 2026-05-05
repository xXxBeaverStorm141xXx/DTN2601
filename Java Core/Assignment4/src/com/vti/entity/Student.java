package com.vti.entity;

public class Student {
    private int id;
    private String name;
    private String homeTown;
    private float score;

    public Student(String name, String homeTown) {
        this.name = name;
        this.homeTown = homeTown;
        this.score = 0;
    }

    public void setScore(float score) {
        this.score = score;
    }

    public void plusScore(float score) {
        this.score += score;
    }

    @Override
    public String toString() {
        String rank;
        if (this.score < 4.0)
        {
            rank = "Yếu";
        }
        else if  (this.score < 6.0)
        {
            rank = "Trung bình";
        }
        else  if  (this.score < 8.0)
        {
            rank = "Khá";
        }
        else {
            rank = "Giỏi";
        }
        return "Student: " +
                "name = '" + name + '\'' +
                ", score = " + score + ", Xếp loại: " + rank;
    }
}
