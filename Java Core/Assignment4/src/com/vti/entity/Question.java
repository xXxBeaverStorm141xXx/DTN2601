package com.vti.entity;

import java.time.LocalDate;

public class Question {
    private int id;
    private String content;
    private TypeQuestion type;
    private Account creator;
    private LocalDate createDate;

    public int getId() {
        return id;
    }

    public String getContent() {
        return content;
    }

    public TypeQuestion getType() {
        return type;
    }

    public Account getCreator() {
        return creator;
    }

    public LocalDate getCreateDate() {
        return createDate;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public void setType(TypeQuestion type) {
        this.type = type;
    }

    public void setCreator(Account creator) {
        this.creator = creator;
    }

    public void setCreateDate(LocalDate createDate) {
        this.createDate = createDate;
    }
}
