package com.my.model;

public class Item {
    private Integer id;
    private String name;
    private Integer quantity;
    private String title;
    private float price;
    private String photo;
    private Category category;
    private String unit;

public  Item(){

}
    public Category getCategory() {
        return category;
    }
    public String getUnit() {
        return unit;
    }
    public Integer getId() {
        return id;
    }
    public String getName() {
        return name;
    }
    public String getPhoto() {
        return photo;
    }
    public Integer getQuantity() {
        return quantity;
    }
    public float getPrice() {
        return price;
    }
    public String getTitle() {
        return title;
    }

    public void setUnit(String unit) {
        this.unit = unit;
    }
    public void setName(String name) {
        this.name = name;

    }
    public void setCategory(Category category) {
        this.category = category;
    }
    public void setQuantity(Integer quantity) {
        this.quantity = quantity;
    }
    public void setTitle(String title) {
        this.title = title;
    }
    public void setPrice(float price) {
        this.price = price;
    }
    public void setPhoto(String photo) {
        this.photo = photo;
    }
    public void setId(Integer id) {
        this.id = id;
    }



}