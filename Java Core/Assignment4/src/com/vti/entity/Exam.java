package com.vti.entity;

import java.time.LocalDateTime;

public class Exam {
    private int id;
    private String code;
    private String title;
    private CategoryQuestion[] category;
    private int duration;
    private Account creator;
    private LocalDateTime createDate;
    private Question[] question;


    public int getId() {
        return id;
    }

    public String getCode() {
        return code;
    }

    public String getTitle() {
        return title;
    }

    public CategoryQuestion[] getCategory() {
        return category;
    }

    public int getDuration() {
        return duration;
    }

    public Account getCreator() {
        return creator;
    }

    public LocalDateTime getCreateDate() {
        return createDate;
    }

    public Question[] getQuestion() {
        return question;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public void setCategory(CategoryQuestion[] category) {
        this.category = category;
    }

    public void setDuration(int duration) {
        this.duration = duration;
    }

    public void setCreator(Account creator) {
        this.creator = creator;
    }

    public void setCreateDate(LocalDateTime createDate) {
        this.createDate = createDate;
    }

    public void setQuestion(Question[] question) {
        this.question = question;
    }
}
