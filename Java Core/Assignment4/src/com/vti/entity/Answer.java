package com.vti.entity;

public class Answer {
    private int id;
    private String content;
    private Question question;
    private Boolean isCorrect;

    public int getId() {
        return id;
    }

    public String getContent() {
        return content;
    }

    public Question getQuestion() {
        return question;
    }

    public Boolean getCorrect() {
        return isCorrect;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public void setQuestion(Question question) {
        this.question = question;
    }

    public void setCorrect(Boolean correct) {
        isCorrect = correct;
    }
}
