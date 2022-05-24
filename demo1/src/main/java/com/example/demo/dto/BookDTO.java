package com.example.demo.dto;

public class BookDTO {
    private String id;
    private String title;
    private String type;
    private String author;
    private int inUse;

    @Override
    public String toString() {
        return "BookDTO{" +
                "id='" + id + '\'' +
                ", title='" + title + '\'' +
                ", type='" + type + '\'' +
                ", author='" + author + '\'' +
                ", inuse=" + inUse +
                '}';
    }

    public BookDTO() {
    }

    public BookDTO(String id, String title, String type, String author, int inuse) {
        this.id = id;
        this.title = title;
        this.type = type;
        this.author = author;
        this.inUse = inuse;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public int getInUse() {
        return inUse;
    }

    public void setInUse(int inuse) {
        this.inUse = inuse;
    }
}
