package com.my.Model;

public class Category {
    private int id;
    private String name;
    private String title;

    /**
     * Category constructor
     */
    public Category() {
    }
    public int getId() {
        return id;
    }
    public String getTitle() {
        return title;
    }
    public String getName() {
        return name;
    }

    public void setId(int id) {
        this.id = id;
    }
    public void setName(String name) {
        this.name = name;
    }
    public void setTitle(String title) {
        this.title = title;
    }




}
