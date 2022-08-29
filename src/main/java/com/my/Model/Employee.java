package com.my.Model;

public class Employee {
    private Integer id;
    private String name;
    private String surname;
    private String email;
    private String mobile;
    private String password;
    private Integer role;
    private String profile;

    private int orders;

    public int getOrders() {
        return orders;
    }

    public void setOrders(int orders) {
        this.orders = orders;
    }
    public void addOneOrder() {
        this.orders++;
    }

    public String getImageName() {
        return imageName;
    }

    public void setImageName(String imageName) {
        this.imageName = imageName;
    }

    private String imageName;

    public Integer getId() {
        return id;

    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getMobile() {
        return mobile;
    }

    public void setMobile(String mobile) {
        this.mobile = mobile;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public Integer getRole() {
        return role;
    }

    public void setRole(Integer role) {
        this.role = role;
    }

    public String getProfile() {
        return profile;
    }

    public void setProfile(String profile) {
        this.profile = profile;
    }
    public String getRoleName(){
        switch (this.role) {
            case 1:
                return "Admin";
            case 2:
                return "Cashier";
            case 3:
                return "Senior cashier";
            case 4:
                return "Commodity expert";
            default:
                return "Unknown role";
        }
    }
}

