package com.codeup.models;

/**
 * @author Created by mel on 2/8/17.
 */
public class Post {
    private int id;
    private String title;
    private String body;

    public long getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getBody() {
        return body;
    }

    public void setBody(String body) {
        this.body = body;
    }
}
