package com.example.demo.models;

public class Widget {

    private Integer id;

    private String title = "New Widget";
    private String topicId;
    private String type = "HEADING";
    private int size = 2;

    public int getSize() {
        return size;
    }

    public void setSize(int size) {
        this.size = size;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getTopicId() {
        return topicId;
    }

    public void setTopicId(String topicId) {
        this.topicId = topicId;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public Widget(Integer id, String title) {
        this.id = id;
        this.title = title;
    }

    public Widget() {
    }
}